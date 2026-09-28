package com.pcmc.bwg.service;

import com.pcmc.bwg.dto.DropdownOptionDto;
import com.pcmc.bwg.entity.AdminAdministrativeWard;
import com.pcmc.bwg.entity.AdminElectoralWard;
import com.pcmc.bwg.entity.AdminZone;
import com.pcmc.bwg.entity.DropdownOption;
import com.pcmc.bwg.repository.AdminAdministrativeWardRepository;
import com.pcmc.bwg.repository.AdminElectoralWardRepository;
import com.pcmc.bwg.repository.AdminZoneRepository;
import com.pcmc.bwg.repository.DropdownRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DropdownService {

    private static final String STATUS_ACTIVE = "ACTIVE";

    private final DropdownRepository dropdownRepository;
    private final AdminZoneRepository adminZoneRepository;
    private final AdminAdministrativeWardRepository adminWardRepository;
    private final AdminElectoralWardRepository adminElectoralWardRepository;

    public DropdownService(DropdownRepository dropdownRepository,
                            AdminZoneRepository adminZoneRepository,
                            AdminAdministrativeWardRepository adminWardRepository,
                            AdminElectoralWardRepository adminElectoralWardRepository) {
        this.dropdownRepository = dropdownRepository;
        this.adminZoneRepository = adminZoneRepository;
        this.adminWardRepository = adminWardRepository;
        this.adminElectoralWardRepository = adminElectoralWardRepository;
    }

    /**
     * ZONE, WARD and ELECTORAL_WARD read live from the admin backend's
     * Zone/Administrative Ward/Electoral Ward masters (same database, see
     * AdminZone/AdminAdministrativeWard/AdminElectoralWard) instead of the
     * static dropdown_options table, so an admin adding or renaming one of
     * these is immediately visible here with no seed/sync step. Every other
     * group (category, bin infrastructure, etc.) is fixed CPCB-survey-form
     * vocabulary that has no admin-master equivalent, so it stays on the
     * static seeded table.
     */
    @Transactional(readOnly = true)
    public List<DropdownOptionDto> getDropdownOptions(String group, String parentValue) {
        if ("ZONE".equalsIgnoreCase(group)) {
            return liveZoneOptions();
        }
        if ("WARD".equalsIgnoreCase(group)) {
            return liveWardOptions(parentValue);
        }
        if ("ELECTORAL_WARD".equalsIgnoreCase(group)) {
            return liveElectoralWardOptions(parentValue);
        }

        List<DropdownOption> list;
        if (parentValue != null && !parentValue.isBlank()) {
            list = dropdownRepository.findByCategoryGroupAndParentValueAndActiveTrueOrderBySortOrderAsc(group, parentValue);
        } else {
            list = dropdownRepository.findByCategoryGroupAndActiveTrueOrderBySortOrderAsc(group);
        }

        return list.stream()
                .map(opt -> DropdownOptionDto.builder()
                        .label(opt.getOptionLabel())
                        .value(opt.getOptionValue())
                        .group(opt.getCategoryGroup())
                        .parentValue(opt.getParentValue())
                        .build())
                .collect(Collectors.toList());
    }

    private List<DropdownOptionDto> liveZoneOptions() {
        return adminZoneRepository.findByStatusOrderByNameAsc(STATUS_ACTIVE).stream()
                .map(z -> DropdownOptionDto.builder()
                        .label(z.getName())
                        .value(z.getName())
                        .group("ZONE")
                        .build())
                .collect(Collectors.toList());
    }

    private List<DropdownOptionDto> liveWardOptions(String zoneName) {
        List<AdminAdministrativeWard> wards;
        if (zoneName != null && !zoneName.isBlank()) {
            Optional<AdminZone> zone = adminZoneRepository.findByNameIgnoreCaseAndStatus(zoneName.trim(), STATUS_ACTIVE);
            if (zone.isEmpty()) {
                return List.of();
            }
            wards = adminWardRepository.findByParentIdAndStatusOrderByNameAsc(zone.get().getId(), STATUS_ACTIVE);
        } else {
            wards = adminWardRepository.findByStatusOrderByNameAsc(STATUS_ACTIVE);
        }

        return wards.stream()
                .map(w -> DropdownOptionDto.builder()
                        .label(w.getName())
                        .value(w.getName())
                        .group("WARD")
                        .parentValue(zoneName)
                        .build())
                .collect(Collectors.toList());
    }

    private List<DropdownOptionDto> liveElectoralWardOptions(String wardName) {
        List<AdminElectoralWard> electoralWards;
        if (wardName != null && !wardName.isBlank()) {
            Optional<AdminAdministrativeWard> ward = adminWardRepository.findByNameIgnoreCaseAndStatus(wardName.trim(), STATUS_ACTIVE);
            if (ward.isEmpty()) {
                return List.of();
            }
            electoralWards = adminElectoralWardRepository.findByParentIdAndStatusOrderByNameAsc(ward.get().getId(), STATUS_ACTIVE);
        } else {
            electoralWards = adminElectoralWardRepository.findByStatusOrderByNameAsc(STATUS_ACTIVE);
        }

        return electoralWards.stream()
                .map(ew -> DropdownOptionDto.builder()
                        .label(ew.getName())
                        .value(ew.getName())
                        .group("ELECTORAL_WARD")
                        .parentValue(wardName)
                        .build())
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Map<String, List<DropdownOptionDto>> getAllDropdowns() {
        List<DropdownOption> allOptions = dropdownRepository.findAll();
        Map<String, List<DropdownOptionDto>> result = new HashMap<>();

        for (DropdownOption opt : allOptions) {
            if (Boolean.TRUE.equals(opt.getActive())) {
                DropdownOptionDto dto = DropdownOptionDto.builder()
                        .label(opt.getOptionLabel())
                        .value(opt.getOptionValue())
                        .group(opt.getCategoryGroup())
                        .parentValue(opt.getParentValue())
                        .build();

                result.computeIfAbsent(opt.getCategoryGroup(), k -> new ArrayList<>()).add(dto);
            }
        }

        result.put("ZONE", liveZoneOptions());
        result.put("WARD", liveWardOptions(null));
        result.put("ELECTORAL_WARD", liveElectoralWardOptions(null));

        return result;
    }
}
