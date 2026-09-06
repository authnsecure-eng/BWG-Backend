package com.pcmc.bwg.service;

import com.pcmc.bwg.dto.DropdownOptionDto;
import com.pcmc.bwg.entity.DropdownOption;
import com.pcmc.bwg.repository.DropdownRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DropdownService {

    private final DropdownRepository dropdownRepository;

    public DropdownService(DropdownRepository dropdownRepository) {
        this.dropdownRepository = dropdownRepository;
    }

    @Transactional(readOnly = true)
    public List<DropdownOptionDto> getDropdownOptions(String group, String parentValue) {
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

        return result;
    }
}
