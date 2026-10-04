package com.pcmc.bwg.service;

import com.pcmc.bwg.dto.*;
import com.pcmc.bwg.entity.Survey;
import com.pcmc.bwg.entity.SurveyWasteVisit;
import com.pcmc.bwg.repository.SurveyRepository;
import com.pcmc.bwg.repository.SurveyWasteVisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.access.AccessDeniedException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SurveyService {

    private final SurveyRepository surveyRepository;
    private final SurveyWasteVisitRepository wasteVisitRepository;
    private final QRCodeService qrCodeService;
    private final AdminBridgeClient adminBridgeClient;

    public SurveyService(SurveyRepository surveyRepository,
                         SurveyWasteVisitRepository wasteVisitRepository,
                         QRCodeService qrCodeService,
                         AdminBridgeClient adminBridgeClient) {
        this.surveyRepository = surveyRepository;
        this.wasteVisitRepository = wasteVisitRepository;
        this.qrCodeService = qrCodeService;
        this.adminBridgeClient = adminBridgeClient;
    }

    @Transactional
    public SurveyResponseDto createSurvey(SurveyCreateRequest req, Long userId, boolean isAdmin) {
        String surveyId = req.getId();
        if (surveyId == null || surveyId.trim().isEmpty()) {
            int randomNum = 10000 + new Random().nextInt(90000);
            surveyId = "BWG-2026-" + randomNum;
        }

        String docUrl = (req.getBuildingPermissionDocUrl() != null && !req.getBuildingPermissionDocUrl().trim().isEmpty())
                ? req.getBuildingPermissionDocUrl()
                : "https://placeholder.com/doc";

        Optional<Survey> existingOpt = surveyRepository.findById(surveyId);
        Survey survey;

        if (existingOpt.isPresent()) {
            survey = existingOpt.get();
            requireAccess(survey, userId, isAdmin);
            if (req.getCategory() != null) survey.setCategory(req.getCategory().toLowerCase());
            if (req.getEstablishmentName() != null) survey.setEstablishmentName(req.getEstablishmentName());
            if (req.getZone() != null) survey.setZone(req.getZone());
            if (req.getWard() != null) survey.setWard(req.getWard());
            if (req.getElectoralWard() != null) survey.setElectoralWard(req.getElectoralWard());
            if (req.getContactName() != null) survey.setContactName(req.getContactName());
            if (req.getContactDesignation() != null) survey.setContactDesignation(req.getContactDesignation());
            if (req.getContactMobile() != null) survey.setContactMobile(req.getContactMobile());
            if (req.getContactEmail() != null) survey.setContactEmail(req.getContactEmail());
            if (req.getContactAddress() != null) survey.setContactAddress(req.getContactAddress());
            if (req.getContactPincode() != null) survey.setContactPincode(req.getContactPincode());
            if (req.getYearEstablished() != null) survey.setYearEstablished(req.getYearEstablished());
            if (req.getPremisesPhotoUrl() != null) survey.setPremisesPhotoUrl(req.getPremisesPhotoUrl());
            if (req.getPremisesPhotoGeo() != null) survey.setPremisesPhotoGeo(req.getPremisesPhotoGeo());
            if (req.getPremisesPhotoTime() != null) survey.setPremisesPhotoTime(req.getPremisesPhotoTime());
            if (req.getSignagePhotoUrl() != null) survey.setSignagePhotoUrl(req.getSignagePhotoUrl());
            if (req.getSignagePhotoGeo() != null) survey.setSignagePhotoGeo(req.getSignagePhotoGeo());
            if (req.getSignagePhotoTime() != null) survey.setSignagePhotoTime(req.getSignagePhotoTime());
            if (req.getGpsCoordinates() != null) survey.setGpsCoordinates(req.getGpsCoordinates());
            if (req.getSubCategoryType() != null) survey.setSubCategoryType(req.getSubCategoryType());
            if (req.getSocietyName() != null) survey.setSocietyName(req.getSocietyName());
            if (req.getChsRegNo() != null) survey.setChsRegNo(req.getChsRegNo());
            if (req.getOrgName() != null) survey.setOrgName(req.getOrgName());
            if (req.getCinNumber() != null) survey.setCinNumber(req.getCinNumber());
            if (req.getTradeLicenseNo() != null) survey.setTradeLicenseNo(req.getTradeLicenseNo());
            if (req.getPtin() != null) survey.setPtin(req.getPtin());
            if (req.getGstin() != null) survey.setGstin(req.getGstin());
            if (req.getTotalFloors() != null) survey.setTotalFloors(req.getTotalFloors());
            if (req.getTotalUnits() != null) survey.setTotalUnits(req.getTotalUnits());
            if (req.getBuiltUpAreaSqM() != null) survey.setBuiltUpAreaSqM(req.getBuiltUpAreaSqM());
            if (req.getBuildingRemarks() != null) survey.setBuildingRemarks(req.getBuildingRemarks());
            if (req.getBuildingPermissionRefNo() != null) survey.setBuildingPermissionRefNo(req.getBuildingPermissionRefNo());
            survey.setBuildingPermissionDocUrl(docUrl);
            if (req.getBuildingPermissionGeo() != null) survey.setBuildingPermissionGeo(req.getBuildingPermissionGeo());
            if (req.getBuildingPermissionTime() != null) survey.setBuildingPermissionTime(req.getBuildingPermissionTime());
            if (req.getWaterConsumerNo() != null) survey.setWaterConsumerNo(req.getWaterConsumerNo());
            if (req.getDailyWaterConsumptionLiters() != null) survey.setDailyWaterConsumptionLiters(req.getDailyWaterConsumptionLiters());
            if (req.getWaterBillingPeriod() != null) survey.setWaterBillingPeriod(req.getWaterBillingPeriod());
            if (req.getWaterUnitsConsumed() != null) survey.setWaterUnitsConsumed(req.getWaterUnitsConsumed());
            if (req.getWaterBillDocUrl() != null) survey.setWaterBillDocUrl(req.getWaterBillDocUrl());
            if (req.getBinInfrastructure() != null) survey.setBinInfrastructure(req.getBinInfrastructure());
            if (req.getSegregatedAtSource() != null) survey.setSegregatedAtSource(req.getSegregatedAtSource());
            if (req.getDryWasteChannelizedTo() != null) survey.setDryWasteChannelizedTo(req.getDryWasteChannelizedTo());
            if (req.getOverallDisposalMode() != null) survey.setOverallDisposalMode(req.getOverallDisposalMode());
            if (req.getVendorName() != null) survey.setVendorName(req.getVendorName());
            if (req.getMouValidity() != null) survey.setMouValidity(req.getMouValidity());
            if (req.getProcessingDestination() != null) survey.setProcessingDestination(req.getProcessingDestination());
            if (req.getPrivateVendorDetails() != null) survey.setPrivateVendorDetails(req.getPrivateVendorDetails());
            if (req.getHasBiogasPlant() != null) survey.setHasBiogasPlant(req.getHasBiogasPlant());
            if (req.getProcessingMethod() != null) survey.setProcessingMethod(req.getProcessingMethod());
            if (req.getBiogasCapacity() != null) survey.setBiogasCapacity(req.getBiogasCapacity());
            if (req.getBiogasCapacityUnit() != null) survey.setBiogasCapacityUnit(req.getBiogasCapacityUnit());
            if (req.getSpaceAvailableSqMeters() != null) survey.setSpaceAvailableSqMeters(req.getSpaceAvailableSqMeters());
            if (req.getByProductUsage() != null) survey.setByProductUsage(req.getByProductUsage());
            if (req.getBiogasOperationalStatus() != null) survey.setBiogasOperationalStatus(req.getBiogasOperationalStatus());
            if (req.getBiogasPhotoUrl() != null) survey.setBiogasPhotoUrl(req.getBiogasPhotoUrl());
            if (req.getBiogasRemarks() != null) survey.setBiogasRemarks(req.getBiogasRemarks());
            if (req.getWasteGivenToOtherAgency() != null) survey.setWasteGivenToOtherAgency(req.getWasteGivenToOtherAgency());
            if (req.getAgencyDocumentPhotoUrl() != null) survey.setAgencyDocumentPhotoUrl(req.getAgencyDocumentPhotoUrl());
            if (req.getGeofenceLatitude() != null) survey.setGeofenceLatitude(req.getGeofenceLatitude());
            if (req.getGeofenceLongitude() != null) survey.setGeofenceLongitude(req.getGeofenceLongitude());
            if (req.getGeofenceRadiusMeters() != null) survey.setGeofenceRadiusMeters(req.getGeofenceRadiusMeters());
            if (req.getGeofencePhotoUrl() != null) survey.setGeofencePhotoUrl(req.getGeofencePhotoUrl());
            if (req.getEligibilityFloorArea() != null) survey.setEligibilityFloorArea(req.getEligibilityFloorArea());
            if (req.getEligibilityWaterConsumption() != null) survey.setEligibilityWaterConsumption(req.getEligibilityWaterConsumption());
            if (req.getEligibilitySolidWaste() != null) survey.setEligibilitySolidWaste(req.getEligibilitySolidWaste());
            if (req.getDeclarantName() != null) survey.setDeclarantName(req.getDeclarantName());
            if (req.getDeclarantDesignation() != null) survey.setDeclarantDesignation(req.getDeclarantDesignation());
            if (req.getDeclarantOrgName() != null) survey.setDeclarantOrgName(req.getDeclarantOrgName());
            if (req.getDeclarantDate() != null) survey.setDeclarantDate(req.getDeclarantDate());
            if (req.getDeclarantPlace() != null) survey.setDeclarantPlace(req.getDeclarantPlace());
            if (req.getDeclarationFileUrl() != null) survey.setDeclarationFileUrl(req.getDeclarationFileUrl());
            if (req.getCpcbCompleted() != null) survey.setCpcbCompleted(req.getCpcbCompleted());
            if (req.getCpcbAckNumber() != null) survey.setCpcbAckNumber(req.getCpcbAckNumber());
            if (req.getCpcbSubmissionDate() != null) survey.setCpcbSubmissionDate(req.getCpcbSubmissionDate());
            survey.setUpdatedAt(LocalDateTime.now());
        } else {
            survey = Survey.builder()
                    .id(surveyId)
                    .category(req.getCategory() != null ? req.getCategory().toLowerCase() : "residential")
                    .status("pending")
                    .establishmentName(req.getEstablishmentName())
                    .zone(req.getZone())
                    .ward(req.getWard())
                    .electoralWard(req.getElectoralWard())
                    .contactName(req.getContactName())
                    .contactDesignation(req.getContactDesignation())
                    .contactMobile(req.getContactMobile())
                    .contactEmail(req.getContactEmail())
                    .contactAddress(req.getContactAddress())
                    .contactPincode(req.getContactPincode())
                    .yearEstablished(req.getYearEstablished())
                    .premisesPhotoUrl(req.getPremisesPhotoUrl())
                    .premisesPhotoGeo(req.getPremisesPhotoGeo())
                    .premisesPhotoTime(req.getPremisesPhotoTime())
                    .signagePhotoUrl(req.getSignagePhotoUrl())
                    .signagePhotoGeo(req.getSignagePhotoGeo())
                    .signagePhotoTime(req.getSignagePhotoTime())
                    .gpsCoordinates(req.getGpsCoordinates())
                    .subCategoryType(req.getSubCategoryType())
                    .societyName(req.getSocietyName())
                    .chsRegNo(req.getChsRegNo())
                    .orgName(req.getOrgName())
                    .cinNumber(req.getCinNumber())
                    .tradeLicenseNo(req.getTradeLicenseNo())
                    .ptin(req.getPtin())
                    .gstin(req.getGstin())
                    .totalFloors(req.getTotalFloors())
                    .totalUnits(req.getTotalUnits())
                    .builtUpAreaSqM(req.getBuiltUpAreaSqM() != null ? req.getBuiltUpAreaSqM() : BigDecimal.ZERO)
                    .buildingRemarks(req.getBuildingRemarks())
                    .buildingPermissionRefNo(req.getBuildingPermissionRefNo())
                    .buildingPermissionDocUrl(docUrl)
                    .buildingPermissionGeo(req.getBuildingPermissionGeo())
                    .buildingPermissionTime(req.getBuildingPermissionTime())
                    .waterConsumerNo(req.getWaterConsumerNo())
                    .dailyWaterConsumptionLiters(req.getDailyWaterConsumptionLiters() != null ? req.getDailyWaterConsumptionLiters() : BigDecimal.ZERO)
                    .waterBillingPeriod(req.getWaterBillingPeriod())
                    .waterUnitsConsumed(req.getWaterUnitsConsumed())
                    .waterBillDocUrl(req.getWaterBillDocUrl())
                    .binInfrastructure(req.getBinInfrastructure())
                    .segregatedAtSource(req.getSegregatedAtSource())
                    .dryWasteChannelizedTo(req.getDryWasteChannelizedTo())
                    .overallDisposalMode(req.getOverallDisposalMode())
                    .vendorName(req.getVendorName())
                    .mouValidity(req.getMouValidity())
                    .processingDestination(req.getProcessingDestination())
                    .privateVendorDetails(req.getPrivateVendorDetails())
                    .hasBiogasPlant(req.getHasBiogasPlant() != null ? req.getHasBiogasPlant() : false)
                    .processingMethod(req.getProcessingMethod())
                    .biogasCapacity(req.getBiogasCapacity())
                    .biogasCapacityUnit(req.getBiogasCapacityUnit())
                    .spaceAvailableSqMeters(req.getSpaceAvailableSqMeters())
                    .byProductUsage(req.getByProductUsage())
                    .biogasOperationalStatus(req.getBiogasOperationalStatus())
                    .biogasPhotoUrl(req.getBiogasPhotoUrl())
                    .biogasRemarks(req.getBiogasRemarks())
                    .wasteGivenToOtherAgency(req.getWasteGivenToOtherAgency())
                    .agencyDocumentPhotoUrl(req.getAgencyDocumentPhotoUrl())
                    .geofenceLatitude(req.getGeofenceLatitude())
                    .geofenceLongitude(req.getGeofenceLongitude())
                    .geofenceRadiusMeters(req.getGeofenceRadiusMeters())
                    .geofencePhotoUrl(req.getGeofencePhotoUrl())
                    .eligibilityFloorArea(req.getEligibilityFloorArea() != null ? req.getEligibilityFloorArea() : false)
                    .eligibilityWaterConsumption(req.getEligibilityWaterConsumption() != null ? req.getEligibilityWaterConsumption() : false)
                    .eligibilitySolidWaste(req.getEligibilitySolidWaste() != null ? req.getEligibilitySolidWaste() : false)
                    .declarantName(req.getDeclarantName())
                    .declarantDesignation(req.getDeclarantDesignation())
                    .declarantOrgName(req.getDeclarantOrgName())
                    .declarantDate(req.getDeclarantDate())
                    .declarantPlace(req.getDeclarantPlace())
                    .declarationFileUrl(req.getDeclarationFileUrl())
                    .declarationFileGeo(req.getDeclarationFileGeo())
                    .declarationFileTime(req.getDeclarationFileTime())
                    .surveyorName(req.getSurveyorName() != null ? req.getSurveyorName() : "Rajesh Patil (Sanitary Inspector)")
                    .surveyorSelfieUrl(req.getSurveyorSelfieUrl())
                    .surveyorGps(req.getSurveyorGps())
                    .surveyorTimestamp(req.getSurveyorTimestamp())
                    .surveyorVerified(req.getSurveyorVerified() != null ? req.getSurveyorVerified() : true)
                    .cpcbCompleted(req.getCpcbCompleted() != null ? req.getCpcbCompleted() : false)
                    .cpcbAckNumber(req.getCpcbAckNumber())
                    .cpcbSubmissionDate(req.getCpcbSubmissionDate())
                    .createdByUserId(isAdmin ? null : userId)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
        }

        List<SurveyWasteVisit> visits = new ArrayList<>();
        if (req.getWasteVisits() != null && !req.getWasteVisits().isEmpty()) {
            for (WasteVisitDto vDto : req.getWasteVisits()) {
                BigDecimal wet = vDto.getWetWasteKg() != null ? vDto.getWetWasteKg() : BigDecimal.ZERO;
                BigDecimal dry = vDto.getDryWasteKg() != null ? vDto.getDryWasteKg() : BigDecimal.ZERO;
                BigDecimal garden = vDto.getGardenWasteKg() != null ? vDto.getGardenWasteKg() : BigDecimal.ZERO;
                BigDecimal total = wet.add(dry).add(garden);

                SurveyWasteVisit visit = SurveyWasteVisit.builder()
                        .survey(survey)
                        .dayNumber(vDto.getDayNumber())
                        .visitDate(vDto.getVisitDate())
                        .wetWasteKg(wet)
                        .dryWasteKg(dry)
                        .gardenWasteKg(garden)
                        .totalWasteKg(total)
                        .wetWastePhotoUrl(vDto.getWetWastePhotoUrl())
                        .dryWastePhotoUrl(vDto.getDryWastePhotoUrl())
                        .gardenWastePhotoUrl(vDto.getGardenWastePhotoUrl())
                        .weighingScalePhotoUrl(vDto.getWeighingScalePhotoUrl())
                        .handoverAreaPhotoUrl(vDto.getHandoverAreaPhotoUrl())
                        .isCompleted(vDto.getIsCompleted() != null ? vDto.getIsCompleted() : (total.compareTo(BigDecimal.ZERO) > 0 && vDto.getWetWastePhotoUrl() != null))
                        .build();

                visits.add(visit);
            }
        }
        survey.setWasteVisits(visits);
        survey.recalculateAverages();

        Survey saved = surveyRepository.save(survey);
        adminBridgeClient.push(saved);
        return mapToDto(saved);
    }

    @Transactional(readOnly = true)
    public DashboardStatsDto getDashboardStats(String year, String month, String zone, String ward, Long userId, boolean isAdmin) {
        String filterZone = (zone != null && !zone.equalsIgnoreCase("All Zones")) ? zone : null;
        String filterWard = (ward != null && !ward.equalsIgnoreCase("All Wards")) ? ward : null;

        DashboardStatsDto.CategoryStatDto residential = computeCategoryStat("residential", "Residential Survey Overview", filterZone, filterWard, userId, isAdmin);
        DashboardStatsDto.CategoryStatDto commercial = computeCategoryStat("commercial", "Commercial Survey Overview", filterZone, filterWard, userId, isAdmin);
        DashboardStatsDto.CategoryStatDto institutional = computeCategoryStat("institutional", "Institutional Survey Overview", filterZone, filterWard, userId, isAdmin);

        long overallTotal = residential.getTotalSurvey().getCount() + commercial.getTotalSurvey().getCount() + institutional.getTotalSurvey().getCount();
        long overallApproved = residential.getSurveyApproved().getCount() + commercial.getSurveyApproved().getCount() + institutional.getSurveyApproved().getCount();
        long overallRejected = residential.getSurveyRejected().getCount() + commercial.getSurveyRejected().getCount() + institutional.getSurveyRejected().getCount();
        long overallPending = residential.getApprovalPending().getCount() + commercial.getApprovalPending().getCount() + institutional.getApprovalPending().getCount();

        String ovAppPercent = overallTotal > 0 ? (Math.round((double) overallApproved / overallTotal * 100)) + "%" : "0%";
        String ovRejPercent = overallTotal > 0 ? (Math.round((double) overallRejected / overallTotal * 100)) + "%" : "0%";
        String ovPendPercent = overallTotal > 0 ? (Math.round((double) overallPending / overallTotal * 100)) + "%" : "0%";

        DashboardStatsDto.CategoryStatDto overall = DashboardStatsDto.CategoryStatDto.builder()
                .category("overall")
                .title("Overall PCMC Survey Overview")
                .totalSurvey(new DashboardStatsDto.StatCountDto(overallTotal, "100%"))
                .surveyApproved(new DashboardStatsDto.StatCountDto(overallApproved, ovAppPercent))
                .surveyRejected(new DashboardStatsDto.StatCountDto(overallRejected, ovRejPercent))
                .approvalPending(new DashboardStatsDto.StatCountDto(overallPending, ovPendPercent))
                .build();

        return DashboardStatsDto.builder()
                .residential(residential)
                .commercial(commercial)
                .institutional(institutional)
                .overall(overall)
                .build();
    }

    private DashboardStatsDto.CategoryStatDto computeCategoryStat(String category, String title, String zone, String ward, Long userId, boolean isAdmin) {
        long total = surveyRepository.countFiltered(category, null, zone, ward, userId, isAdmin);
        long approved = surveyRepository.countFiltered(category, "approved", zone, ward, userId, isAdmin);
        long rejected = surveyRepository.countFiltered(category, "rejected", zone, ward, userId, isAdmin);
        long pending = surveyRepository.countFiltered(category, "pending", zone, ward, userId, isAdmin);

        String appPercent = total > 0 ? (Math.round((double) approved / total * 100)) + "%" : "0%";
        String rejPercent = total > 0 ? (Math.round((double) rejected / total * 100)) + "%" : "0%";
        String pendPercent = total > 0 ? (Math.round((double) pending / total * 100)) + "%" : "0%";

        return DashboardStatsDto.CategoryStatDto.builder()
                .category(category)
                .title(title)
                .totalSurvey(new DashboardStatsDto.StatCountDto(total, "100%"))
                .surveyApproved(new DashboardStatsDto.StatCountDto(approved, appPercent))
                .surveyRejected(new DashboardStatsDto.StatCountDto(rejected, rejPercent))
                .approvalPending(new DashboardStatsDto.StatCountDto(pending, pendPercent))
                .build();
    }

    @Transactional(readOnly = true)
    public List<SurveyResponseDto> getSurveys(String category, String status, String zone, String ward, String search, Long userId, boolean isAdmin) {
        List<Survey> list = surveyRepository.filterSurveys(category, status, zone, ward, search, userId, isAdmin);
        return list.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public SurveyResponseDto getSurveyById(String id, Long userId, boolean isAdmin) {
        Survey survey = surveyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Survey record not found with ID: " + id));
        requireAccess(survey, userId, isAdmin);
        return mapToDto(survey);
    }

    @Transactional
    public SurveyResponseDto updateWasteVisit(String surveyId, WasteVisitUpdateRequest req, Long userId, boolean isAdmin) {
        Survey survey = surveyRepository.findById(surveyId)
                .orElseThrow(() -> new RuntimeException("Survey record not found with ID: " + surveyId));
        requireAccess(survey, userId, isAdmin);

        Optional<SurveyWasteVisit> existingOpt = wasteVisitRepository.findBySurveyIdAndDayNumber(surveyId, req.getDayNumber());

        BigDecimal wet = req.getWetWasteKg() != null ? req.getWetWasteKg() : BigDecimal.ZERO;
        BigDecimal dry = req.getDryWasteKg() != null ? req.getDryWasteKg() : BigDecimal.ZERO;
        BigDecimal garden = req.getGardenWasteKg() != null ? req.getGardenWasteKg() : BigDecimal.ZERO;
        BigDecimal total = wet.add(dry).add(garden);
        boolean completed = total.compareTo(BigDecimal.ZERO) > 0 && (req.getWetWastePhotoUrl() != null || (existingOpt.isPresent() && existingOpt.get().getWetWastePhotoUrl() != null));

        if (existingOpt.isPresent()) {
            SurveyWasteVisit visit = existingOpt.get();
            if (req.getVisitDate() != null) visit.setVisitDate(req.getVisitDate());
            visit.setWetWasteKg(wet);
            visit.setDryWasteKg(dry);
            visit.setGardenWasteKg(garden);
            visit.setTotalWasteKg(total);
            if (req.getWetWastePhotoUrl() != null) visit.setWetWastePhotoUrl(req.getWetWastePhotoUrl());
            if (req.getDryWastePhotoUrl() != null) visit.setDryWastePhotoUrl(req.getDryWastePhotoUrl());
            if (req.getGardenWastePhotoUrl() != null) visit.setGardenWastePhotoUrl(req.getGardenWastePhotoUrl());
            if (req.getWeighingScalePhotoUrl() != null) visit.setWeighingScalePhotoUrl(req.getWeighingScalePhotoUrl());
            if (req.getHandoverAreaPhotoUrl() != null) visit.setHandoverAreaPhotoUrl(req.getHandoverAreaPhotoUrl());
            visit.setIsCompleted(completed);
            wasteVisitRepository.save(visit);
        } else {
            SurveyWasteVisit newVisit = SurveyWasteVisit.builder()
                    .survey(survey)
                    .dayNumber(req.getDayNumber())
                    .visitDate(req.getVisitDate() != null ? req.getVisitDate() : java.time.LocalDate.now().toString())
                    .wetWasteKg(wet)
                    .dryWasteKg(dry)
                    .gardenWasteKg(garden)
                    .totalWasteKg(total)
                    .wetWastePhotoUrl(req.getWetWastePhotoUrl())
                    .dryWastePhotoUrl(req.getDryWastePhotoUrl())
                    .gardenWastePhotoUrl(req.getGardenWastePhotoUrl())
                    .weighingScalePhotoUrl(req.getWeighingScalePhotoUrl())
                    .handoverAreaPhotoUrl(req.getHandoverAreaPhotoUrl())
                    .isCompleted(completed)
                    .build();
            survey.getWasteVisits().add(newVisit);
        }

        survey.recalculateAverages();
        Survey saved = surveyRepository.save(survey);
        adminBridgeClient.push(saved);
        return mapToDto(saved);
    }

    @Transactional
    public SurveyResponseDto updateCpcb(String surveyId, CPCBUpdateRequest req, Long userId, boolean isAdmin) {
        Survey survey = surveyRepository.findById(surveyId)
                .orElseThrow(() -> new RuntimeException("Survey record not found with ID: " + surveyId));
        requireAccess(survey, userId, isAdmin);

        if (req.getCompleted() != null) survey.setCpcbCompleted(req.getCompleted());
        if (req.getAckNumber() != null) survey.setCpcbAckNumber(req.getAckNumber());
        if (req.getSubmissionDate() != null) survey.setCpcbSubmissionDate(req.getSubmissionDate());

        Survey saved = surveyRepository.save(survey);
        adminBridgeClient.push(saved);
        return mapToDto(saved);
    }

    @Transactional(readOnly = true)
    public QRCodeResponseDto getQrCode(String surveyId, Long userId, boolean isAdmin) {
        Survey survey = surveyRepository.findById(surveyId)
                .orElseThrow(() -> new RuntimeException("Survey record not found with ID: " + surveyId));
        requireAccess(survey, userId, isAdmin);

        String bwgStatusText = Boolean.TRUE.equals(survey.getIsBwg()) ? "BWG: YES" : "BWG: NO";
        String qrPayloadText = String.format("PCMC BWG SURVEY REGISTRATION\nID: %s\nEstablishment: %s\nCategory: %s\nStatus: %s\nBWG Classification: %s\nZone: %s | Ward: %s",
                survey.getId(), survey.getEstablishmentName(), survey.getCategory(), survey.getStatus(), bwgStatusText, survey.getZone(), survey.getWard());

        String qrBase64 = qrCodeService.generateQRCodeBase64(qrPayloadText, 300, 300);

        return QRCodeResponseDto.builder()
                .surveyId(survey.getId())
                .establishmentName(survey.getEstablishmentName())
                .category(survey.getCategory())
                .zone(survey.getZone())
                .ward(survey.getWard())
                .isBwg(survey.getIsBwg())
                .bwgBadgeText(bwgStatusText)
                .qrCodeDataBase64(qrBase64)
                .generatedAt(LocalDateTime.now().toString())
                .build();
    }

    @Transactional(readOnly = true)
    public byte[] getQrCodePngBytes(String surveyId, Long userId, boolean isAdmin) {
        Survey survey = surveyRepository.findById(surveyId)
                .orElseThrow(() -> new RuntimeException("Survey record not found with ID: " + surveyId));
        requireAccess(survey, userId, isAdmin);

        String bwgStatusText = Boolean.TRUE.equals(survey.getIsBwg()) ? "BWG: YES" : "BWG: NO";
        String qrPayloadText = String.format("PCMC BWG SURVEY REGISTRATION\nID: %s\nEstablishment: %s\nCategory: %s\nStatus: %s\nBWG Classification: %s\nZone: %s | Ward: %s",
                survey.getId(), survey.getEstablishmentName(), survey.getCategory(), survey.getStatus(), bwgStatusText, survey.getZone(), survey.getWard());

        return qrCodeService.generateQRCodePngBytes(qrPayloadText, 400, 400);
    }

    private void requireAccess(Survey survey, Long userId, boolean isAdmin) {
        if (!isAdmin && (userId == null || !userId.equals(survey.getCreatedByUserId()))) {
            throw new AccessDeniedException("You do not have permission to access this survey");
        }
    }

    private SurveyResponseDto mapToDto(Survey s) {
        String bwgLabel = Boolean.TRUE.equals(s.getIsBwg()) ? "BWG: YES" : "BWG: NO";

        List<WasteVisitDto> visitDtos = s.getWasteVisits() == null ? Collections.emptyList() :
                s.getWasteVisits().stream()
                        .map(v -> WasteVisitDto.builder()
                                .dayNumber(v.getDayNumber())
                                .visitDate(v.getVisitDate())
                                .wetWasteKg(v.getWetWasteKg())
                                .dryWasteKg(v.getDryWasteKg())
                                .gardenWasteKg(v.getGardenWasteKg())
                                .totalWasteKg(v.getTotalWasteKg())
                                .wetWastePhotoUrl(v.getWetWastePhotoUrl())
                                .dryWastePhotoUrl(v.getDryWastePhotoUrl())
                                .gardenWastePhotoUrl(v.getGardenWastePhotoUrl())
                                .weighingScalePhotoUrl(v.getWeighingScalePhotoUrl())
                                .handoverAreaPhotoUrl(v.getHandoverAreaPhotoUrl())
                                .isCompleted(v.getIsCompleted())
                                .build())
                        .sorted(Comparator.comparing(WasteVisitDto::getDayNumber))
                        .collect(Collectors.toList());

        String qrPayloadText = String.format("PCMC BWG SURVEY REGISTRATION\nID: %s\nEstablishment: %s\nCategory: %s\nStatus: %s\nBWG Classification: %s\nZone: %s | Ward: %s",
                s.getId(), s.getEstablishmentName(), s.getCategory(), s.getStatus(), bwgLabel, s.getZone(), s.getWard());
        String qrBase64 = qrCodeService.generateQRCodeBase64(qrPayloadText, 250, 250);

        return SurveyResponseDto.builder()
                .id(s.getId())
                .category(s.getCategory())
                .status(s.getStatus())
                .isBwg(s.getIsBwg())
                .bwgLabel(bwgLabel)
                .establishmentName(s.getEstablishmentName())
                .zone(s.getZone())
                .ward(s.getWard())
                .electoralWard(s.getElectoralWard())
                .contactName(s.getContactName())
                .contactDesignation(s.getContactDesignation())
                .contactMobile(s.getContactMobile())
                .contactEmail(s.getContactEmail())
                .contactAddress(s.getContactAddress())
                .contactPincode(s.getContactPincode())
                .yearEstablished(s.getYearEstablished())
                .premisesPhotoUrl(s.getPremisesPhotoUrl())
                .premisesPhotoGeo(s.getPremisesPhotoGeo())
                .premisesPhotoTime(s.getPremisesPhotoTime())
                .signagePhotoUrl(s.getSignagePhotoUrl())
                .signagePhotoGeo(s.getSignagePhotoGeo())
                .signagePhotoTime(s.getSignagePhotoTime())
                .gpsCoordinates(s.getGpsCoordinates())
                .subCategoryType(s.getSubCategoryType())
                .societyName(s.getSocietyName())
                .chsRegNo(s.getChsRegNo())
                .orgName(s.getOrgName())
                .cinNumber(s.getCinNumber())
                .tradeLicenseNo(s.getTradeLicenseNo())
                .ptin(s.getPtin())
                .gstin(s.getGstin())
                .totalFloors(s.getTotalFloors())
                .totalUnits(s.getTotalUnits())
                .builtUpAreaSqM(s.getBuiltUpAreaSqM())
                .buildingRemarks(s.getBuildingRemarks())
                .buildingPermissionRefNo(s.getBuildingPermissionRefNo())
                .buildingPermissionDocUrl(s.getBuildingPermissionDocUrl())
                .buildingPermissionGeo(s.getBuildingPermissionGeo())
                .buildingPermissionTime(s.getBuildingPermissionTime())
                .waterConsumerNo(s.getWaterConsumerNo())
                .dailyWaterConsumptionLiters(s.getDailyWaterConsumptionLiters())
                .waterBillingPeriod(s.getWaterBillingPeriod())
                .waterUnitsConsumed(s.getWaterUnitsConsumed())
                .waterBillDocUrl(s.getWaterBillDocUrl())
                .binInfrastructure(s.getBinInfrastructure())
                .segregatedAtSource(s.getSegregatedAtSource())
                .dryWasteChannelizedTo(s.getDryWasteChannelizedTo())
                .overallDisposalMode(s.getOverallDisposalMode())
                .vendorName(s.getVendorName())
                .mouValidity(s.getMouValidity())
                .processingDestination(s.getProcessingDestination())
                .privateVendorDetails(s.getPrivateVendorDetails())
                .hasBiogasPlant(s.getHasBiogasPlant())
                .processingMethod(s.getProcessingMethod())
                .biogasCapacity(s.getBiogasCapacity())
                .biogasCapacityUnit(s.getBiogasCapacityUnit())
                .spaceAvailableSqMeters(s.getSpaceAvailableSqMeters())
                .byProductUsage(s.getByProductUsage())
                .biogasOperationalStatus(s.getBiogasOperationalStatus())
                .biogasPhotoUrl(s.getBiogasPhotoUrl())
                .biogasRemarks(s.getBiogasRemarks())
                .wasteGivenToOtherAgency(s.getWasteGivenToOtherAgency())
                .agencyDocumentPhotoUrl(s.getAgencyDocumentPhotoUrl())
                .geofenceLatitude(s.getGeofenceLatitude())
                .geofenceLongitude(s.getGeofenceLongitude())
                .geofenceRadiusMeters(s.getGeofenceRadiusMeters())
                .geofencePhotoUrl(s.getGeofencePhotoUrl())
                .eligibilityFloorArea(s.getEligibilityFloorArea())
                .eligibilityWaterConsumption(s.getEligibilityWaterConsumption())
                .eligibilitySolidWaste(s.getEligibilitySolidWaste())
                .declarantName(s.getDeclarantName())
                .declarantDesignation(s.getDeclarantDesignation())
                .declarantOrgName(s.getDeclarantOrgName())
                .declarantDate(s.getDeclarantDate())
                .declarantPlace(s.getDeclarantPlace())
                .declarationFileUrl(s.getDeclarationFileUrl())
                .declarationFileGeo(s.getDeclarationFileGeo())
                .declarationFileTime(s.getDeclarationFileTime())
                .surveyorName(s.getSurveyorName())
                .surveyorSelfieUrl(s.getSurveyorSelfieUrl())
                .surveyorGps(s.getSurveyorGps())
                .surveyorTimestamp(s.getSurveyorTimestamp())
                .surveyorVerified(s.getSurveyorVerified())
                .avgWetWasteKg(s.getAvgWetWasteKg())
                .avgDryWasteKg(s.getAvgDryWasteKg())
                .avgTotalWasteKg(s.getAvgTotalWasteKg())
                .cpcbCompleted(s.getCpcbCompleted())
                .cpcbAckNumber(s.getCpcbAckNumber())
                .cpcbSubmissionDate(s.getCpcbSubmissionDate())
                .qrCodeDataBase64(qrBase64)
                .wasteVisits(visitDtos)
                .createdAt(s.getCreatedAt())
                .updatedAt(s.getUpdatedAt())
                .build();
    }
}
