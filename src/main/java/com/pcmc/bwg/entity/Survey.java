package com.pcmc.bwg.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "surveys")
public class Survey {

    @Id
    @Column(length = 50)
    private String id;

    @Column(nullable = false, length = 30)
    private String category;

    @Column(nullable = false, length = 20)
    private String status = "pending";

    @Column(name = "is_bwg", nullable = false)
    private Boolean isBwg = false;

    @Column(name = "establishment_name", nullable = false)
    private String establishmentName;

    @Column(nullable = false, length = 100)
    private String zone;

    @Column(nullable = false, length = 100)
    private String ward;

    @Column(name = "electoral_ward", length = 100)
    private String electoralWard;

    @Column(name = "contact_name", nullable = false, length = 150)
    private String contactName;

    @Column(name = "contact_designation", nullable = false, length = 100)
    private String contactDesignation;

    @Column(name = "contact_mobile", nullable = false, length = 20)
    private String contactMobile;

    @Column(name = "contact_email", length = 150)
    private String contactEmail;

    @Column(name = "contact_address", nullable = false, columnDefinition = "TEXT")
    private String contactAddress;

    @Column(name = "contact_pincode", nullable = false, length = 10)
    private String contactPincode;

    @Column(name = "year_established", length = 10)
    private String yearEstablished;

    @Column(name = "premises_photo_url", length = 500)
    private String premisesPhotoUrl;

    @Column(name = "premises_photo_geo", length = 255)
    private String premisesPhotoGeo;

    @Column(name = "premises_photo_time", length = 100)
    private String premisesPhotoTime;

    @Column(name = "signage_photo_url", length = 500)
    private String signagePhotoUrl;

    @Column(name = "signage_photo_geo", length = 255)
    private String signagePhotoGeo;

    @Column(name = "signage_photo_time", length = 100)
    private String signagePhotoTime;

    @Column(name = "gps_coordinates", length = 255)
    private String gpsCoordinates;

    @Column(name = "sub_category_type", length = 150)
    private String subCategoryType;

    @Column(name = "society_name")
    private String societyName;

    @Column(name = "chs_reg_no", length = 100)
    private String chsRegNo;

    @Column(name = "org_name")
    private String orgName;

    @Column(name = "cin_number", length = 100)
    private String cinNumber;

    @Column(name = "trade_license_no", length = 100)
    private String tradeLicenseNo;

    @Column(name = "ptin", length = 100)
    private String ptin;

    @Column(name = "gstin", length = 100)
    private String gstin;

    @Column(name = "total_floors", length = 20)
    private String totalFloors;

    @Column(name = "total_units", length = 20)
    private String totalUnits;

    @Column(name = "built_up_area_sq_m")
    private BigDecimal builtUpAreaSqM = BigDecimal.ZERO;

    @Column(name = "building_remarks", columnDefinition = "TEXT")
    private String buildingRemarks;

    @Column(name = "building_permission_ref_no", length = 100)
    private String buildingPermissionRefNo;

    @Column(name = "building_permission_doc_url", nullable = false, length = 500)
    private String buildingPermissionDocUrl;

    @Column(name = "building_permission_geo", length = 255)
    private String buildingPermissionGeo;

    @Column(name = "building_permission_time", length = 100)
    private String buildingPermissionTime;

    @Column(name = "water_consumer_no", length = 100)
    private String waterConsumerNo;

    @Column(name = "daily_water_consumption_liters")
    private BigDecimal dailyWaterConsumptionLiters = BigDecimal.ZERO;

    @Column(name = "water_billing_period", length = 100)
    private String waterBillingPeriod;

    @Column(name = "water_units_consumed", length = 100)
    private String waterUnitsConsumed;

    @Column(name = "water_bill_doc_url", length = 500)
    private String waterBillDocUrl;

    @Column(name = "bin_infrastructure", length = 50)
    private String binInfrastructure;

    @Column(name = "segregated_at_source", length = 50)
    private String segregatedAtSource;

    @Column(name = "dry_waste_channelized_to", length = 150)
    private String dryWasteChannelizedTo;

    @Column(name = "overall_disposal_mode", length = 100)
    private String overallDisposalMode;

    @Column(name = "vendor_name")
    private String vendorName;

    @Column(name = "mou_validity", length = 100)
    private String mouValidity;

    @Column(name = "processing_destination")
    private String processingDestination;

    @Column(name = "private_vendor_details", length = 500)
    private String privateVendorDetails;

    @Column(name = "has_biogas_plant")
    private Boolean hasBiogasPlant = false;

    @Column(name = "processing_method", length = 100)
    private String processingMethod;

    @Column(name = "biogas_capacity", length = 50)
    private String biogasCapacity;

    @Column(name = "biogas_capacity_unit", length = 50)
    private String biogasCapacityUnit;

    @Column(name = "space_available_sq_meters", length = 50)
    private String spaceAvailableSqMeters;

    @Column(name = "by_product_usage")
    private String byProductUsage;

    @Column(name = "biogas_operational_status", length = 50)
    private String biogasOperationalStatus;

    @Column(name = "biogas_photo_url", length = 500)
    private String biogasPhotoUrl;

    @Column(name = "biogas_remarks", columnDefinition = "TEXT")
    private String biogasRemarks;

    @Column(name = "waste_given_to_other_agency", length = 255)
    private String wasteGivenToOtherAgency;

    @Column(name = "agency_document_photo_url", length = 500)
    private String agencyDocumentPhotoUrl;

    @Column(name = "geofence_latitude", length = 50)
    private String geofenceLatitude;

    @Column(name = "geofence_longitude", length = 50)
    private String geofenceLongitude;

    @Column(name = "geofence_radius_meters", length = 50)
    private String geofenceRadiusMeters;

    @Column(name = "geofence_photo_url", length = 500)
    private String geofencePhotoUrl;

    @Column(name = "eligibility_floor_area")
    private Boolean eligibilityFloorArea = false;

    @Column(name = "eligibility_water_consumption")
    private Boolean eligibilityWaterConsumption = false;

    @Column(name = "eligibility_solid_waste")
    private Boolean eligibilitySolidWaste = false;

    @Column(name = "declarant_name", length = 150)
    private String declarantName;

    @Column(name = "declarant_designation", length = 100)
    private String declarantDesignation;

    @Column(name = "declarant_org_name")
    private String declarantOrgName;

    @Column(name = "declarant_date", length = 30)
    private String declarantDate;

    @Column(name = "declarant_place", length = 150)
    private String declarantPlace;

    @Column(name = "declaration_file_url", length = 500)
    private String declarationFileUrl;

    @Column(name = "declaration_file_geo", length = 255)
    private String declarationFileGeo;

    @Column(name = "declaration_file_time", length = 100)
    private String declarationFileTime;

    @Column(name = "surveyor_name", length = 150)
    private String surveyorName;

    @Column(name = "surveyor_selfie_url", length = 500)
    private String surveyorSelfieUrl;

    @Column(name = "surveyor_gps", length = 255)
    private String surveyorGps;

    @Column(name = "surveyor_timestamp", length = 100)
    private String surveyorTimestamp;

    @Column(name = "surveyor_verified")
    private Boolean surveyorVerified = false;

    @Column(name = "avg_wet_waste_kg")
    private BigDecimal avgWetWasteKg = BigDecimal.ZERO;

    @Column(name = "avg_dry_waste_kg")
    private BigDecimal avgDryWasteKg = BigDecimal.ZERO;

    @Column(name = "avg_total_waste_kg")
    private BigDecimal avgTotalWasteKg = BigDecimal.ZERO;

    @Column(name = "cpcb_completed")
    private Boolean cpcbCompleted = false;

    @Column(name = "cpcb_ack_number", length = 100)
    private String cpcbAckNumber;

    @Column(name = "cpcb_submission_date", length = 50)
    private String cpcbSubmissionDate;

    @Column(name = "created_by_user_id", updatable = false)
    private Long createdByUserId;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    /** Null until AdminBridgeClient successfully pushes this survey to the
     *  admin backend; a scheduled job retries every survey still null here. */
    @Column(name = "admin_synced_at")
    private LocalDateTime adminSyncedAt;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<SurveyWasteVisit> wasteVisits = new ArrayList<>();

    public Survey() {}

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Boolean getIsBwg() { return isBwg; }
    public void setIsBwg(Boolean isBwg) { this.isBwg = isBwg; }

    public String getEstablishmentName() { return establishmentName; }
    public void setEstablishmentName(String establishmentName) { this.establishmentName = establishmentName; }

    public String getZone() { return zone; }
    public void setZone(String zone) { this.zone = zone; }

    public String getWard() { return ward; }
    public void setWard(String ward) { this.ward = ward; }

    public String getElectoralWard() { return electoralWard; }
    public void setElectoralWard(String electoralWard) { this.electoralWard = electoralWard; }

    public String getContactName() { return contactName; }
    public void setContactName(String contactName) { this.contactName = contactName; }

    public String getContactDesignation() { return contactDesignation; }
    public void setContactDesignation(String contactDesignation) { this.contactDesignation = contactDesignation; }

    public String getContactMobile() { return contactMobile; }
    public void setContactMobile(String contactMobile) { this.contactMobile = contactMobile; }

    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public String getContactAddress() { return contactAddress; }
    public void setContactAddress(String contactAddress) { this.contactAddress = contactAddress; }

    public String getContactPincode() { return contactPincode; }
    public void setContactPincode(String contactPincode) { this.contactPincode = contactPincode; }

    public String getYearEstablished() { return yearEstablished; }
    public void setYearEstablished(String yearEstablished) { this.yearEstablished = yearEstablished; }

    public String getPremisesPhotoUrl() { return premisesPhotoUrl; }
    public void setPremisesPhotoUrl(String premisesPhotoUrl) { this.premisesPhotoUrl = premisesPhotoUrl; }

    public String getPremisesPhotoGeo() { return premisesPhotoGeo; }
    public void setPremisesPhotoGeo(String premisesPhotoGeo) { this.premisesPhotoGeo = premisesPhotoGeo; }

    public String getPremisesPhotoTime() { return premisesPhotoTime; }
    public void setPremisesPhotoTime(String premisesPhotoTime) { this.premisesPhotoTime = premisesPhotoTime; }

    public String getGpsCoordinates() { return gpsCoordinates; }
    public void setGpsCoordinates(String gpsCoordinates) { this.gpsCoordinates = gpsCoordinates; }

    public String getSubCategoryType() { return subCategoryType; }
    public void setSubCategoryType(String subCategoryType) { this.subCategoryType = subCategoryType; }

    public String getSocietyName() { return societyName; }
    public void setSocietyName(String societyName) { this.societyName = societyName; }

    public String getChsRegNo() { return chsRegNo; }
    public void setChsRegNo(String chsRegNo) { this.chsRegNo = chsRegNo; }

    public String getOrgName() { return orgName; }
    public void setOrgName(String orgName) { this.orgName = orgName; }

    public String getCinNumber() { return cinNumber; }
    public void setCinNumber(String cinNumber) { this.cinNumber = cinNumber; }

    public String getTradeLicenseNo() { return tradeLicenseNo; }
    public void setTradeLicenseNo(String tradeLicenseNo) { this.tradeLicenseNo = tradeLicenseNo; }

    public String getTotalFloors() { return totalFloors; }
    public void setTotalFloors(String totalFloors) { this.totalFloors = totalFloors; }

    public String getTotalUnits() { return totalUnits; }
    public void setTotalUnits(String totalUnits) { this.totalUnits = totalUnits; }

    public BigDecimal getBuiltUpAreaSqM() { return builtUpAreaSqM; }
    public void setBuiltUpAreaSqM(BigDecimal builtUpAreaSqM) { this.builtUpAreaSqM = builtUpAreaSqM; }

    public String getBuildingRemarks() { return buildingRemarks; }
    public void setBuildingRemarks(String buildingRemarks) { this.buildingRemarks = buildingRemarks; }

    public String getBuildingPermissionDocUrl() { return buildingPermissionDocUrl; }
    public void setBuildingPermissionDocUrl(String buildingPermissionDocUrl) { this.buildingPermissionDocUrl = buildingPermissionDocUrl; }

    public String getBuildingPermissionGeo() { return buildingPermissionGeo; }
    public void setBuildingPermissionGeo(String buildingPermissionGeo) { this.buildingPermissionGeo = buildingPermissionGeo; }

    public String getBuildingPermissionTime() { return buildingPermissionTime; }
    public void setBuildingPermissionTime(String buildingPermissionTime) { this.buildingPermissionTime = buildingPermissionTime; }

    public String getWaterConsumerNo() { return waterConsumerNo; }
    public void setWaterConsumerNo(String waterConsumerNo) { this.waterConsumerNo = waterConsumerNo; }

    public BigDecimal getDailyWaterConsumptionLiters() { return dailyWaterConsumptionLiters; }
    public void setDailyWaterConsumptionLiters(BigDecimal dailyWaterConsumptionLiters) { this.dailyWaterConsumptionLiters = dailyWaterConsumptionLiters; }

    public String getWaterBillDocUrl() { return waterBillDocUrl; }
    public void setWaterBillDocUrl(String waterBillDocUrl) { this.waterBillDocUrl = waterBillDocUrl; }

    public String getBinInfrastructure() { return binInfrastructure; }
    public void setBinInfrastructure(String binInfrastructure) { this.binInfrastructure = binInfrastructure; }

    public String getSegregatedAtSource() { return segregatedAtSource; }
    public void setSegregatedAtSource(String segregatedAtSource) { this.segregatedAtSource = segregatedAtSource; }

    public String getDryWasteChannelizedTo() { return dryWasteChannelizedTo; }
    public void setDryWasteChannelizedTo(String dryWasteChannelizedTo) { this.dryWasteChannelizedTo = dryWasteChannelizedTo; }

    public Boolean getHasBiogasPlant() { return hasBiogasPlant; }
    public void setHasBiogasPlant(Boolean hasBiogasPlant) { this.hasBiogasPlant = hasBiogasPlant; }

    public String getBiogasCapacity() { return biogasCapacity; }
    public void setBiogasCapacity(String biogasCapacity) { this.biogasCapacity = biogasCapacity; }

    public String getBiogasCapacityUnit() { return biogasCapacityUnit; }
    public void setBiogasCapacityUnit(String biogasCapacityUnit) { this.biogasCapacityUnit = biogasCapacityUnit; }

    public String getBiogasOperationalStatus() { return biogasOperationalStatus; }
    public void setBiogasOperationalStatus(String biogasOperationalStatus) { this.biogasOperationalStatus = biogasOperationalStatus; }

    public String getBiogasPhotoUrl() { return biogasPhotoUrl; }
    public void setBiogasPhotoUrl(String biogasPhotoUrl) { this.biogasPhotoUrl = biogasPhotoUrl; }

    public String getBiogasRemarks() { return biogasRemarks; }
    public void setBiogasRemarks(String biogasRemarks) { this.biogasRemarks = biogasRemarks; }

    public String getWasteGivenToOtherAgency() { return wasteGivenToOtherAgency; }
    public void setWasteGivenToOtherAgency(String wasteGivenToOtherAgency) { this.wasteGivenToOtherAgency = wasteGivenToOtherAgency; }

    public String getAgencyDocumentPhotoUrl() { return agencyDocumentPhotoUrl; }
    public void setAgencyDocumentPhotoUrl(String agencyDocumentPhotoUrl) { this.agencyDocumentPhotoUrl = agencyDocumentPhotoUrl; }

    public String getGeofenceLatitude() { return geofenceLatitude; }
    public void setGeofenceLatitude(String geofenceLatitude) { this.geofenceLatitude = geofenceLatitude; }

    public String getGeofenceLongitude() { return geofenceLongitude; }
    public void setGeofenceLongitude(String geofenceLongitude) { this.geofenceLongitude = geofenceLongitude; }

    public String getGeofencePhotoUrl() { return geofencePhotoUrl; }
    public void setGeofencePhotoUrl(String geofencePhotoUrl) { this.geofencePhotoUrl = geofencePhotoUrl; }

    public Boolean getEligibilityFloorArea() { return eligibilityFloorArea; }
    public void setEligibilityFloorArea(Boolean eligibilityFloorArea) { this.eligibilityFloorArea = eligibilityFloorArea; }

    public Boolean getEligibilityWaterConsumption() { return eligibilityWaterConsumption; }
    public void setEligibilityWaterConsumption(Boolean eligibilityWaterConsumption) { this.eligibilityWaterConsumption = eligibilityWaterConsumption; }

    public Boolean getEligibilitySolidWaste() { return eligibilitySolidWaste; }
    public void setEligibilitySolidWaste(Boolean eligibilitySolidWaste) { this.eligibilitySolidWaste = eligibilitySolidWaste; }

    public String getDeclarantName() { return declarantName; }
    public void setDeclarantName(String declarantName) { this.declarantName = declarantName; }

    public String getDeclarantDesignation() { return declarantDesignation; }
    public void setDeclarantDesignation(String declarantDesignation) { this.declarantDesignation = declarantDesignation; }

    public String getDeclarantOrgName() { return declarantOrgName; }
    public void setDeclarantOrgName(String declarantOrgName) { this.declarantOrgName = declarantOrgName; }

    public String getDeclarantDate() { return declarantDate; }
    public void setDeclarantDate(String declarantDate) { this.declarantDate = declarantDate; }

    public String getDeclarantPlace() { return declarantPlace; }
    public void setDeclarantPlace(String declarantPlace) { this.declarantPlace = declarantPlace; }

    public String getDeclarationFileUrl() { return declarationFileUrl; }
    public void setDeclarationFileUrl(String declarationFileUrl) { this.declarationFileUrl = declarationFileUrl; }

    public String getDeclarationFileGeo() { return declarationFileGeo; }
    public void setDeclarationFileGeo(String declarationFileGeo) { this.declarationFileGeo = declarationFileGeo; }

    public String getDeclarationFileTime() { return declarationFileTime; }
    public void setDeclarationFileTime(String declarationFileTime) { this.declarationFileTime = declarationFileTime; }

    public String getSurveyorName() { return surveyorName; }
    public void setSurveyorName(String surveyorName) { this.surveyorName = surveyorName; }

    public String getSurveyorSelfieUrl() { return surveyorSelfieUrl; }
    public void setSurveyorSelfieUrl(String surveyorSelfieUrl) { this.surveyorSelfieUrl = surveyorSelfieUrl; }

    public String getSurveyorGps() { return surveyorGps; }
    public void setSurveyorGps(String surveyorGps) { this.surveyorGps = surveyorGps; }

    public String getSurveyorTimestamp() { return surveyorTimestamp; }
    public void setSurveyorTimestamp(String surveyorTimestamp) { this.surveyorTimestamp = surveyorTimestamp; }

    public Boolean getSurveyorVerified() { return surveyorVerified; }
    public void setSurveyorVerified(Boolean surveyorVerified) { this.surveyorVerified = surveyorVerified; }

    public BigDecimal getAvgWetWasteKg() { return avgWetWasteKg; }
    public void setAvgWetWasteKg(BigDecimal avgWetWasteKg) { this.avgWetWasteKg = avgWetWasteKg; }

    public BigDecimal getAvgDryWasteKg() { return avgDryWasteKg; }
    public void setAvgDryWasteKg(BigDecimal avgDryWasteKg) { this.avgDryWasteKg = avgDryWasteKg; }

    public BigDecimal getAvgTotalWasteKg() { return avgTotalWasteKg; }
    public void setAvgTotalWasteKg(BigDecimal avgTotalWasteKg) { this.avgTotalWasteKg = avgTotalWasteKg; }

    public Boolean getCpcbCompleted() { return cpcbCompleted; }
    public void setCpcbCompleted(Boolean cpcbCompleted) { this.cpcbCompleted = cpcbCompleted; }

    public String getCpcbAckNumber() { return cpcbAckNumber; }
    public void setCpcbAckNumber(String cpcbAckNumber) { this.cpcbAckNumber = cpcbAckNumber; }

    public String getCpcbSubmissionDate() { return cpcbSubmissionDate; }
    public void setCpcbSubmissionDate(String cpcbSubmissionDate) { this.cpcbSubmissionDate = cpcbSubmissionDate; }

    public Long getCreatedByUserId() { return createdByUserId; }
    public void setCreatedByUserId(Long createdByUserId) { this.createdByUserId = createdByUserId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public LocalDateTime getAdminSyncedAt() { return adminSyncedAt; }
    public void setAdminSyncedAt(LocalDateTime adminSyncedAt) { this.adminSyncedAt = adminSyncedAt; }

    public List<SurveyWasteVisit> getWasteVisits() { return wasteVisits; }
    public void setWasteVisits(List<SurveyWasteVisit> wasteVisits) { this.wasteVisits = wasteVisits; }

    public String getSignagePhotoUrl() { return signagePhotoUrl; }
    public void setSignagePhotoUrl(String signagePhotoUrl) { this.signagePhotoUrl = signagePhotoUrl; }

    public String getSignagePhotoGeo() { return signagePhotoGeo; }
    public void setSignagePhotoGeo(String signagePhotoGeo) { this.signagePhotoGeo = signagePhotoGeo; }

    public String getSignagePhotoTime() { return signagePhotoTime; }
    public void setSignagePhotoTime(String signagePhotoTime) { this.signagePhotoTime = signagePhotoTime; }

    public String getPtin() { return ptin; }
    public void setPtin(String ptin) { this.ptin = ptin; }

    public String getGstin() { return gstin; }
    public void setGstin(String gstin) { this.gstin = gstin; }

    public String getBuildingPermissionRefNo() { return buildingPermissionRefNo; }
    public void setBuildingPermissionRefNo(String buildingPermissionRefNo) { this.buildingPermissionRefNo = buildingPermissionRefNo; }

    public String getWaterBillingPeriod() { return waterBillingPeriod; }
    public void setWaterBillingPeriod(String waterBillingPeriod) { this.waterBillingPeriod = waterBillingPeriod; }

    public String getWaterUnitsConsumed() { return waterUnitsConsumed; }
    public void setWaterUnitsConsumed(String waterUnitsConsumed) { this.waterUnitsConsumed = waterUnitsConsumed; }

    public String getOverallDisposalMode() { return overallDisposalMode; }
    public void setOverallDisposalMode(String overallDisposalMode) { this.overallDisposalMode = overallDisposalMode; }

    public String getVendorName() { return vendorName; }
    public void setVendorName(String vendorName) { this.vendorName = vendorName; }

    public String getMouValidity() { return mouValidity; }
    public void setMouValidity(String mouValidity) { this.mouValidity = mouValidity; }

    public String getProcessingDestination() { return processingDestination; }
    public void setProcessingDestination(String processingDestination) { this.processingDestination = processingDestination; }

    public String getPrivateVendorDetails() { return privateVendorDetails; }
    public void setPrivateVendorDetails(String privateVendorDetails) { this.privateVendorDetails = privateVendorDetails; }

    public String getProcessingMethod() { return processingMethod; }
    public void setProcessingMethod(String processingMethod) { this.processingMethod = processingMethod; }

    public String getSpaceAvailableSqMeters() { return spaceAvailableSqMeters; }
    public void setSpaceAvailableSqMeters(String spaceAvailableSqMeters) { this.spaceAvailableSqMeters = spaceAvailableSqMeters; }

    public String getByProductUsage() { return byProductUsage; }
    public void setByProductUsage(String byProductUsage) { this.byProductUsage = byProductUsage; }

    public String getGeofenceRadiusMeters() { return geofenceRadiusMeters; }
    public void setGeofenceRadiusMeters(String geofenceRadiusMeters) { this.geofenceRadiusMeters = geofenceRadiusMeters; }

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) createdAt = LocalDateTime.now();
        if (updatedAt == null) updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public void evaluateBwgStatus() {
        boolean isAreaBwg = builtUpAreaSqM != null && builtUpAreaSqM.compareTo(new BigDecimal("20000")) >= 0;
        boolean isWaterBwg = dailyWaterConsumptionLiters != null && dailyWaterConsumptionLiters.compareTo(new BigDecimal("40000")) >= 0;
        boolean isWasteBwg = avgTotalWasteKg != null && avgTotalWasteKg.compareTo(new BigDecimal("100")) >= 0;
        boolean isCheckBwg = Boolean.TRUE.equals(eligibilityFloorArea) || Boolean.TRUE.equals(eligibilityWaterConsumption) || Boolean.TRUE.equals(eligibilitySolidWaste);

        this.isBwg = isAreaBwg || isWaterBwg || isWasteBwg || isCheckBwg;
    }

    public void recalculateAverages() {
        if (wasteVisits == null || wasteVisits.isEmpty()) {
            this.avgWetWasteKg = BigDecimal.ZERO;
            this.avgDryWasteKg = BigDecimal.ZERO;
            this.avgTotalWasteKg = BigDecimal.ZERO;
            return;
        }

        long completedCount = wasteVisits.stream().filter(v -> Boolean.TRUE.equals(v.getIsCompleted())).count();
        if (completedCount == 0) {
            completedCount = 1;
        }

        BigDecimal totalWet = wasteVisits.stream()
                .filter(v -> Boolean.TRUE.equals(v.getIsCompleted()))
                .map(v -> v.getWetWasteKg() != null ? v.getWetWasteKg() : BigDecimal.ZERO)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalDry = wasteVisits.stream()
                .filter(v -> Boolean.TRUE.equals(v.getIsCompleted()))
                .map(v -> v.getDryWasteKg() != null ? v.getDryWasteKg() : BigDecimal.ZERO)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalWaste = wasteVisits.stream()
                .filter(v -> Boolean.TRUE.equals(v.getIsCompleted()))
                .map(v -> v.getTotalWasteKg() != null ? v.getTotalWasteKg() : BigDecimal.ZERO)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal divisor = new BigDecimal(completedCount);
        this.avgWetWasteKg = totalWet.divide(divisor, 2, java.math.RoundingMode.HALF_UP);
        this.avgDryWasteKg = totalDry.divide(divisor, 2, java.math.RoundingMode.HALF_UP);
        this.avgTotalWasteKg = totalWaste.divide(divisor, 2, java.math.RoundingMode.HALF_UP);

        if (wasteVisits.stream().filter(v -> Boolean.TRUE.equals(v.getIsCompleted())).count() >= 3 && "pending".equalsIgnoreCase(this.status)) {
            this.status = "approved";
        }

        evaluateBwgStatus();
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final Survey survey = new Survey();

        public Builder id(String id) { survey.setId(id); return this; }
        public Builder category(String category) { survey.setCategory(category); return this; }
        public Builder status(String status) { survey.setStatus(status); return this; }
        public Builder isBwg(Boolean isBwg) { survey.setIsBwg(isBwg); return this; }
        public Builder establishmentName(String establishmentName) { survey.setEstablishmentName(establishmentName); return this; }
        public Builder zone(String zone) { survey.setZone(zone); return this; }
        public Builder ward(String ward) { survey.setWard(ward); return this; }
        public Builder electoralWard(String electoralWard) { survey.setElectoralWard(electoralWard); return this; }
        public Builder contactName(String contactName) { survey.setContactName(contactName); return this; }
        public Builder contactDesignation(String contactDesignation) { survey.setContactDesignation(contactDesignation); return this; }
        public Builder contactMobile(String contactMobile) { survey.setContactMobile(contactMobile); return this; }
        public Builder contactEmail(String contactEmail) { survey.setContactEmail(contactEmail); return this; }
        public Builder contactAddress(String contactAddress) { survey.setContactAddress(contactAddress); return this; }
        public Builder contactPincode(String contactPincode) { survey.setContactPincode(contactPincode); return this; }
        public Builder yearEstablished(String yearEstablished) { survey.setYearEstablished(yearEstablished); return this; }
        public Builder premisesPhotoUrl(String premisesPhotoUrl) { survey.setPremisesPhotoUrl(premisesPhotoUrl); return this; }
        public Builder premisesPhotoGeo(String premisesPhotoGeo) { survey.setPremisesPhotoGeo(premisesPhotoGeo); return this; }
        public Builder premisesPhotoTime(String premisesPhotoTime) { survey.setPremisesPhotoTime(premisesPhotoTime); return this; }
        public Builder gpsCoordinates(String gpsCoordinates) { survey.setGpsCoordinates(gpsCoordinates); return this; }
        public Builder subCategoryType(String subCategoryType) { survey.setSubCategoryType(subCategoryType); return this; }
        public Builder societyName(String societyName) { survey.setSocietyName(societyName); return this; }
        public Builder chsRegNo(String chsRegNo) { survey.setChsRegNo(chsRegNo); return this; }
        public Builder orgName(String orgName) { survey.setOrgName(orgName); return this; }
        public Builder cinNumber(String cinNumber) { survey.setCinNumber(cinNumber); return this; }
        public Builder tradeLicenseNo(String tradeLicenseNo) { survey.setTradeLicenseNo(tradeLicenseNo); return this; }
        public Builder totalFloors(String totalFloors) { survey.setTotalFloors(totalFloors); return this; }
        public Builder totalUnits(String totalUnits) { survey.setTotalUnits(totalUnits); return this; }
        public Builder builtUpAreaSqM(BigDecimal builtUpAreaSqM) { survey.setBuiltUpAreaSqM(builtUpAreaSqM); return this; }
        public Builder buildingRemarks(String buildingRemarks) { survey.setBuildingRemarks(buildingRemarks); return this; }
        public Builder buildingPermissionDocUrl(String buildingPermissionDocUrl) { survey.setBuildingPermissionDocUrl(buildingPermissionDocUrl); return this; }
        public Builder buildingPermissionGeo(String buildingPermissionGeo) { survey.setBuildingPermissionGeo(buildingPermissionGeo); return this; }
        public Builder buildingPermissionTime(String buildingPermissionTime) { survey.setBuildingPermissionTime(buildingPermissionTime); return this; }
        public Builder waterConsumerNo(String waterConsumerNo) { survey.setWaterConsumerNo(waterConsumerNo); return this; }
        public Builder dailyWaterConsumptionLiters(BigDecimal dailyWaterConsumptionLiters) { survey.setDailyWaterConsumptionLiters(dailyWaterConsumptionLiters); return this; }
        public Builder waterBillDocUrl(String waterBillDocUrl) { survey.setWaterBillDocUrl(waterBillDocUrl); return this; }
        public Builder binInfrastructure(String binInfrastructure) { survey.setBinInfrastructure(binInfrastructure); return this; }
        public Builder segregatedAtSource(String segregatedAtSource) { survey.setSegregatedAtSource(segregatedAtSource); return this; }
        public Builder dryWasteChannelizedTo(String dryWasteChannelizedTo) { survey.setDryWasteChannelizedTo(dryWasteChannelizedTo); return this; }
        public Builder hasBiogasPlant(Boolean hasBiogasPlant) { survey.setHasBiogasPlant(hasBiogasPlant); return this; }
        public Builder biogasCapacity(String biogasCapacity) { survey.setBiogasCapacity(biogasCapacity); return this; }
        public Builder biogasCapacityUnit(String biogasCapacityUnit) { survey.setBiogasCapacityUnit(biogasCapacityUnit); return this; }
        public Builder biogasOperationalStatus(String biogasOperationalStatus) { survey.setBiogasOperationalStatus(biogasOperationalStatus); return this; }
        public Builder biogasPhotoUrl(String biogasPhotoUrl) { survey.setBiogasPhotoUrl(biogasPhotoUrl); return this; }
        public Builder biogasRemarks(String biogasRemarks) { survey.setBiogasRemarks(biogasRemarks); return this; }
        public Builder wasteGivenToOtherAgency(String wasteGivenToOtherAgency) { survey.setWasteGivenToOtherAgency(wasteGivenToOtherAgency); return this; }
        public Builder agencyDocumentPhotoUrl(String agencyDocumentPhotoUrl) { survey.setAgencyDocumentPhotoUrl(agencyDocumentPhotoUrl); return this; }
        public Builder geofenceLatitude(String geofenceLatitude) { survey.setGeofenceLatitude(geofenceLatitude); return this; }
        public Builder geofenceLongitude(String geofenceLongitude) { survey.setGeofenceLongitude(geofenceLongitude); return this; }
        public Builder geofencePhotoUrl(String geofencePhotoUrl) { survey.setGeofencePhotoUrl(geofencePhotoUrl); return this; }
        public Builder eligibilityFloorArea(Boolean eligibilityFloorArea) { survey.setEligibilityFloorArea(eligibilityFloorArea); return this; }
        public Builder eligibilityWaterConsumption(Boolean eligibilityWaterConsumption) { survey.setEligibilityWaterConsumption(eligibilityWaterConsumption); return this; }
        public Builder eligibilitySolidWaste(Boolean eligibilitySolidWaste) { survey.setEligibilitySolidWaste(eligibilitySolidWaste); return this; }
        public Builder declarantName(String declarantName) { survey.setDeclarantName(declarantName); return this; }
        public Builder declarantDesignation(String declarantDesignation) { survey.setDeclarantDesignation(declarantDesignation); return this; }
        public Builder declarantOrgName(String declarantOrgName) { survey.setDeclarantOrgName(declarantOrgName); return this; }
        public Builder declarantDate(String declarantDate) { survey.setDeclarantDate(declarantDate); return this; }
        public Builder declarantPlace(String declarantPlace) { survey.setDeclarantPlace(declarantPlace); return this; }
        public Builder declarationFileUrl(String declarationFileUrl) { survey.setDeclarationFileUrl(declarationFileUrl); return this; }
        public Builder declarationFileGeo(String declarationFileGeo) { survey.setDeclarationFileGeo(declarationFileGeo); return this; }
        public Builder declarationFileTime(String declarationFileTime) { survey.setDeclarationFileTime(declarationFileTime); return this; }
        public Builder surveyorName(String surveyorName) { survey.setSurveyorName(surveyorName); return this; }
        public Builder surveyorSelfieUrl(String surveyorSelfieUrl) { survey.setSurveyorSelfieUrl(surveyorSelfieUrl); return this; }
        public Builder surveyorGps(String surveyorGps) { survey.setSurveyorGps(surveyorGps); return this; }
        public Builder surveyorTimestamp(String surveyorTimestamp) { survey.setSurveyorTimestamp(surveyorTimestamp); return this; }
        public Builder surveyorVerified(Boolean surveyorVerified) { survey.setSurveyorVerified(surveyorVerified); return this; }
        public Builder avgWetWasteKg(BigDecimal avgWetWasteKg) { survey.setAvgWetWasteKg(avgWetWasteKg); return this; }
        public Builder avgDryWasteKg(BigDecimal avgDryWasteKg) { survey.setAvgDryWasteKg(avgDryWasteKg); return this; }
        public Builder avgTotalWasteKg(BigDecimal avgTotalWasteKg) { survey.setAvgTotalWasteKg(avgTotalWasteKg); return this; }
        public Builder cpcbCompleted(Boolean cpcbCompleted) { survey.setCpcbCompleted(cpcbCompleted); return this; }
        public Builder cpcbAckNumber(String cpcbAckNumber) { survey.setCpcbAckNumber(cpcbAckNumber); return this; }
        public Builder cpcbSubmissionDate(String cpcbSubmissionDate) { survey.setCpcbSubmissionDate(cpcbSubmissionDate); return this; }
        public Builder createdByUserId(Long createdByUserId) { survey.setCreatedByUserId(createdByUserId); return this; }
        public Builder signagePhotoUrl(String signagePhotoUrl) { survey.setSignagePhotoUrl(signagePhotoUrl); return this; }
        public Builder signagePhotoGeo(String signagePhotoGeo) { survey.setSignagePhotoGeo(signagePhotoGeo); return this; }
        public Builder signagePhotoTime(String signagePhotoTime) { survey.setSignagePhotoTime(signagePhotoTime); return this; }
        public Builder ptin(String ptin) { survey.setPtin(ptin); return this; }
        public Builder gstin(String gstin) { survey.setGstin(gstin); return this; }
        public Builder buildingPermissionRefNo(String buildingPermissionRefNo) { survey.setBuildingPermissionRefNo(buildingPermissionRefNo); return this; }
        public Builder waterBillingPeriod(String waterBillingPeriod) { survey.setWaterBillingPeriod(waterBillingPeriod); return this; }
        public Builder waterUnitsConsumed(String waterUnitsConsumed) { survey.setWaterUnitsConsumed(waterUnitsConsumed); return this; }
        public Builder overallDisposalMode(String overallDisposalMode) { survey.setOverallDisposalMode(overallDisposalMode); return this; }
        public Builder vendorName(String vendorName) { survey.setVendorName(vendorName); return this; }
        public Builder mouValidity(String mouValidity) { survey.setMouValidity(mouValidity); return this; }
        public Builder processingDestination(String processingDestination) { survey.setProcessingDestination(processingDestination); return this; }
        public Builder privateVendorDetails(String privateVendorDetails) { survey.setPrivateVendorDetails(privateVendorDetails); return this; }
        public Builder processingMethod(String processingMethod) { survey.setProcessingMethod(processingMethod); return this; }
        public Builder spaceAvailableSqMeters(String spaceAvailableSqMeters) { survey.setSpaceAvailableSqMeters(spaceAvailableSqMeters); return this; }
        public Builder byProductUsage(String byProductUsage) { survey.setByProductUsage(byProductUsage); return this; }
        public Builder geofenceRadiusMeters(String geofenceRadiusMeters) { survey.setGeofenceRadiusMeters(geofenceRadiusMeters); return this; }
        public Builder createdAt(LocalDateTime createdAt) { survey.setCreatedAt(createdAt); return this; }
        public Builder updatedAt(LocalDateTime updatedAt) { survey.setUpdatedAt(updatedAt); return this; }

        public Survey build() { return survey; }
    }
}
