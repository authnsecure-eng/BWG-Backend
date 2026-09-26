package com.pcmc.bwg.service;

import com.pcmc.bwg.config.AdminBridgeProperties;
import com.pcmc.bwg.entity.Survey;
import com.pcmc.bwg.entity.SurveyWasteVisit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Pushes a Survey to the admin backend's /api/internal/surveys/ingest so it
 * appears in the Admin "Reports" screen (see SurveyIngestController /
 * SurveyIngestService there). Deliberately best-effort: a citizen/officer
 * submitting a survey must never fail or hang because the admin backend is
 * slow or unreachable, so every failure here is caught and logged, never
 * rethrown.
 *
 * Known gap (documented, not silently worked around): Survey has no
 * authenticated-officer foreign key today, only the free-text
 * surveyorName field (which even defaults to a hardcoded name when the
 * client doesn't send one). So surveyOfficerId is always sent as null here
 * until Survey/SurveyController are changed to record the actual logged-in
 * AppUser's id.
 */
@Service
public class AdminBridgeClient {

    private static final Logger log = LoggerFactory.getLogger(AdminBridgeClient.class);

    private final AdminBridgeProperties properties;
    private final RestTemplate restTemplate;

    public AdminBridgeClient(AdminBridgeProperties properties, RestTemplateBuilder restTemplateBuilder) {
        this.properties = properties;
        this.restTemplate = restTemplateBuilder
                .setConnectTimeout(Duration.ofMillis(properties.getConnectTimeoutMs()))
                .setReadTimeout(Duration.ofMillis(properties.getReadTimeoutMs()))
                .build();
    }

    /** Fire-and-forget: logs and swallows every failure, never throws. */
    public void push(Survey survey) {
        if (!properties.isEnabled()) {
            return;
        }
        try {
            Map<String, Object> payload = toIngestPayload(survey);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            if (properties.getApiKey() != null && !properties.getApiKey().isBlank()) {
                headers.set("X-Internal-Api-Key", properties.getApiKey());
            }

            String url = properties.getBaseUrl() + "/api/internal/surveys/ingest";
            restTemplate.postForEntity(url, new HttpEntity<>(payload, headers), Map.class);
            log.info("Pushed survey {} to admin backend", survey.getId());
        } catch (RestClientException ex) {
            log.error("Failed to push survey {} to admin backend at {}: {}",
                    survey.getId(), properties.getBaseUrl(), ex.getMessage());
        } catch (Exception ex) {
            log.error("Unexpected error pushing survey {} to admin backend", survey.getId(), ex);
        }
    }

    private Map<String, Object> toIngestPayload(Survey s) {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("mobileSurveyId", s.getId());
        m.put("category", s.getCategory());
        m.put("establishmentName", s.getEstablishmentName());
        m.put("zone", s.getZone());
        m.put("ward", s.getWard());
        m.put("electoralWard", s.getElectoralWard());
        m.put("contactName", s.getContactName());
        m.put("contactDesignation", s.getContactDesignation());
        m.put("contactMobile", s.getContactMobile());
        m.put("contactEmail", s.getContactEmail());
        m.put("contactAddress", s.getContactAddress());
        m.put("contactPincode", s.getContactPincode());
        m.put("yearEstablished", s.getYearEstablished());
        m.put("premisesPhotoUrl", s.getPremisesPhotoUrl());
        m.put("premisesPhotoGeo", s.getPremisesPhotoGeo());
        m.put("premisesPhotoTime", s.getPremisesPhotoTime());
        m.put("signagePhotoUrl", s.getSignagePhotoUrl());
        m.put("signagePhotoGeo", s.getSignagePhotoGeo());
        m.put("signagePhotoTime", s.getSignagePhotoTime());
        m.put("gpsCoordinates", s.getGpsCoordinates());
        m.put("subCategoryType", s.getSubCategoryType());
        m.put("societyName", s.getSocietyName());
        m.put("chsRegNo", s.getChsRegNo());
        m.put("orgName", s.getOrgName());
        m.put("cinNumber", s.getCinNumber());
        m.put("tradeLicenseNo", s.getTradeLicenseNo());
        m.put("ptin", s.getPtin());
        m.put("gstin", s.getGstin());
        m.put("totalFloors", s.getTotalFloors());
        m.put("totalUnits", s.getTotalUnits());
        m.put("builtUpAreaSqM", s.getBuiltUpAreaSqM());
        m.put("buildingRemarks", s.getBuildingRemarks());
        m.put("buildingPermissionRefNo", s.getBuildingPermissionRefNo());
        m.put("buildingPermissionDocUrl", s.getBuildingPermissionDocUrl());
        m.put("buildingPermissionGeo", s.getBuildingPermissionGeo());
        m.put("buildingPermissionTime", s.getBuildingPermissionTime());
        m.put("waterConsumerNo", s.getWaterConsumerNo());
        m.put("dailyWaterConsumptionLiters", s.getDailyWaterConsumptionLiters());
        m.put("waterBillingPeriod", s.getWaterBillingPeriod());
        m.put("waterUnitsConsumed", s.getWaterUnitsConsumed());
        m.put("waterBillDocUrl", s.getWaterBillDocUrl());
        m.put("binInfrastructure", s.getBinInfrastructure());
        m.put("segregatedAtSource", s.getSegregatedAtSource());
        m.put("dryWasteChannelizedTo", s.getDryWasteChannelizedTo());
        m.put("overallDisposalMode", s.getOverallDisposalMode());
        m.put("vendorName", s.getVendorName());
        m.put("mouValidity", s.getMouValidity());
        m.put("processingDestination", s.getProcessingDestination());
        m.put("privateVendorDetails", s.getPrivateVendorDetails());
        m.put("hasBiogasPlant", s.getHasBiogasPlant());
        m.put("processingMethod", s.getProcessingMethod());
        m.put("biogasCapacity", s.getBiogasCapacity());
        m.put("biogasCapacityUnit", s.getBiogasCapacityUnit());
        m.put("spaceAvailableSqMeters", s.getSpaceAvailableSqMeters());
        m.put("byProductUsage", s.getByProductUsage());
        m.put("biogasOperationalStatus", s.getBiogasOperationalStatus());
        m.put("biogasPhotoUrl", s.getBiogasPhotoUrl());
        m.put("biogasRemarks", s.getBiogasRemarks());
        m.put("wasteGivenToOtherAgency", s.getWasteGivenToOtherAgency());
        m.put("agencyDocumentPhotoUrl", s.getAgencyDocumentPhotoUrl());
        m.put("geofenceLatitude", s.getGeofenceLatitude());
        m.put("geofenceLongitude", s.getGeofenceLongitude());
        m.put("geofenceRadiusMeters", s.getGeofenceRadiusMeters());
        m.put("geofencePhotoUrl", s.getGeofencePhotoUrl());
        m.put("eligibilityFloorArea", s.getEligibilityFloorArea());
        m.put("eligibilityWaterConsumption", s.getEligibilityWaterConsumption());
        m.put("eligibilitySolidWaste", s.getEligibilitySolidWaste());
        m.put("declarantName", s.getDeclarantName());
        m.put("declarantDesignation", s.getDeclarantDesignation());
        m.put("declarantOrgName", s.getDeclarantOrgName());
        m.put("declarantDate", s.getDeclarantDate());
        m.put("declarantPlace", s.getDeclarantPlace());
        m.put("declarationFileUrl", s.getDeclarationFileUrl());
        m.put("declarationFileGeo", s.getDeclarationFileGeo());
        m.put("declarationFileTime", s.getDeclarationFileTime());
        m.put("surveyorName", s.getSurveyorName());
        m.put("surveyorSelfieUrl", s.getSurveyorSelfieUrl());
        m.put("surveyorGps", s.getSurveyorGps());
        m.put("surveyorTimestamp", s.getSurveyorTimestamp());
        m.put("surveyorVerified", s.getSurveyorVerified());
        m.put("cpcbCompleted", s.getCpcbCompleted());
        m.put("cpcbAckNumber", s.getCpcbAckNumber());
        m.put("cpcbSubmissionDate", s.getCpcbSubmissionDate());
        // No authenticated-officer link exists on Survey yet - see class javadoc.
        m.put("surveyOfficerId", null);
        m.put("surveyOfficerName", s.getSurveyorName());
        m.put("wasteVisits", toWasteVisitPayload(s.getWasteVisits()));
        return m;
    }

    private List<Map<String, Object>> toWasteVisitPayload(List<SurveyWasteVisit> visits) {
        List<Map<String, Object>> result = new ArrayList<>();
        if (visits == null) {
            return result;
        }
        for (SurveyWasteVisit v : visits) {
            Map<String, Object> vm = new LinkedHashMap<>();
            vm.put("dayNumber", v.getDayNumber());
            vm.put("visitDate", v.getVisitDate());
            vm.put("wetWasteKg", v.getWetWasteKg());
            vm.put("dryWasteKg", v.getDryWasteKg());
            vm.put("gardenWasteKg", v.getGardenWasteKg());
            vm.put("totalWasteKg", v.getTotalWasteKg());
            vm.put("wetWastePhotoUrl", v.getWetWastePhotoUrl());
            vm.put("dryWastePhotoUrl", v.getDryWastePhotoUrl());
            vm.put("gardenWastePhotoUrl", v.getGardenWastePhotoUrl());
            vm.put("weighingScalePhotoUrl", v.getWeighingScalePhotoUrl());
            vm.put("handoverAreaPhotoUrl", v.getHandoverAreaPhotoUrl());
            vm.put("isCompleted", v.getIsCompleted());
            result.add(vm);
        }
        return result;
    }
}
