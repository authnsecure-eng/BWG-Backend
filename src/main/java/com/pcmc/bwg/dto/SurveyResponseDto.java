package com.pcmc.bwg.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class SurveyResponseDto {
    private String id;
    private String category;
    private String status;
    private Boolean isBwg;
    private String bwgLabel;
    private String establishmentName;
    private String zone;
    private String ward;
    private String electoralWard;

    private String contactName;
    private String contactDesignation;
    private String contactMobile;
    private String contactEmail;
    private String contactAddress;
    private String contactPincode;
    private String yearEstablished;
    private String premisesPhotoUrl;
    private String premisesPhotoGeo;
    private String premisesPhotoTime;
    private String signagePhotoUrl;
    private String signagePhotoGeo;
    private String signagePhotoTime;
    private String gpsCoordinates;

    private String subCategoryType;
    private String societyName;
    private String chsRegNo;
    private String orgName;
    private String cinNumber;
    private String tradeLicenseNo;
    private String ptin;
    private String gstin;

    private String totalFloors;
    private String totalUnits;
    private BigDecimal builtUpAreaSqM;
    private String buildingRemarks;

    private String buildingPermissionRefNo;
    private String buildingPermissionDocUrl;
    private String buildingPermissionGeo;
    private String buildingPermissionTime;

    private String waterConsumerNo;
    private BigDecimal dailyWaterConsumptionLiters;
    private String waterBillingPeriod;
    private String waterUnitsConsumed;
    private String waterBillDocUrl;

    private String binInfrastructure;
    private String segregatedAtSource;
    private String dryWasteChannelizedTo;
    private String overallDisposalMode;
    private String vendorName;
    private String mouValidity;
    private String processingDestination;
    private String privateVendorDetails;

    private Boolean hasBiogasPlant;
    private String processingMethod;
    private String biogasCapacity;
    private String biogasCapacityUnit;
    private String spaceAvailableSqMeters;
    private String byProductUsage;
    private String biogasOperationalStatus;
    private String biogasPhotoUrl;
    private String biogasRemarks;
    private String wasteGivenToOtherAgency;
    private String agencyDocumentPhotoUrl;

    private String geofenceLatitude;
    private String geofenceLongitude;
    private String geofenceRadiusMeters;
    private String geofencePhotoUrl;

    private Boolean eligibilityFloorArea;
    private Boolean eligibilityWaterConsumption;
    private Boolean eligibilitySolidWaste;

    private String declarantName;
    private String declarantDesignation;
    private String declarantOrgName;
    private String declarantDate;
    private String declarantPlace;
    private String declarationFileUrl;
    private String declarationFileGeo;
    private String declarationFileTime;
    private String surveyorName;
    private String surveyorSelfieUrl;
    private String surveyorGps;
    private String surveyorTimestamp;
    private Boolean surveyorVerified;

    private BigDecimal avgWetWasteKg;
    private BigDecimal avgDryWasteKg;
    private BigDecimal avgTotalWasteKg;

    private Boolean cpcbCompleted;
    private String cpcbAckNumber;
    private String cpcbSubmissionDate;

    private String qrCodeDataBase64;

    private List<WasteVisitDto> wasteVisits;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public SurveyResponseDto() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Boolean getIsBwg() { return isBwg; }
    public void setIsBwg(Boolean isBwg) { this.isBwg = isBwg; }

    public String getBwgLabel() { return bwgLabel; }
    public void setBwgLabel(String bwgLabel) { this.bwgLabel = bwgLabel; }

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

    public String getQrCodeDataBase64() { return qrCodeDataBase64; }
    public void setQrCodeDataBase64(String qrCodeDataBase64) { this.qrCodeDataBase64 = qrCodeDataBase64; }

    public List<WasteVisitDto> getWasteVisits() { return wasteVisits; }
    public void setWasteVisits(List<WasteVisitDto> wasteVisits) { this.wasteVisits = wasteVisits; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

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

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final SurveyResponseDto dto = new SurveyResponseDto();

        public Builder id(String id) { dto.setId(id); return this; }
        public Builder category(String category) { dto.setCategory(category); return this; }
        public Builder status(String status) { dto.setStatus(status); return this; }
        public Builder isBwg(Boolean isBwg) { dto.setIsBwg(isBwg); return this; }
        public Builder bwgLabel(String bwgLabel) { dto.setBwgLabel(bwgLabel); return this; }
        public Builder establishmentName(String establishmentName) { dto.setEstablishmentName(establishmentName); return this; }
        public Builder zone(String zone) { dto.setZone(zone); return this; }
        public Builder ward(String ward) { dto.setWard(ward); return this; }
        public Builder electoralWard(String electoralWard) { dto.setElectoralWard(electoralWard); return this; }
        public Builder contactName(String contactName) { dto.setContactName(contactName); return this; }
        public Builder contactDesignation(String contactDesignation) { dto.setContactDesignation(contactDesignation); return this; }
        public Builder contactMobile(String contactMobile) { dto.setContactMobile(contactMobile); return this; }
        public Builder contactEmail(String contactEmail) { dto.setContactEmail(contactEmail); return this; }
        public Builder contactAddress(String contactAddress) { dto.setContactAddress(contactAddress); return this; }
        public Builder contactPincode(String contactPincode) { dto.setContactPincode(contactPincode); return this; }
        public Builder yearEstablished(String yearEstablished) { dto.setYearEstablished(yearEstablished); return this; }
        public Builder premisesPhotoUrl(String premisesPhotoUrl) { dto.setPremisesPhotoUrl(premisesPhotoUrl); return this; }
        public Builder premisesPhotoGeo(String premisesPhotoGeo) { dto.setPremisesPhotoGeo(premisesPhotoGeo); return this; }
        public Builder premisesPhotoTime(String premisesPhotoTime) { dto.setPremisesPhotoTime(premisesPhotoTime); return this; }
        public Builder gpsCoordinates(String gpsCoordinates) { dto.setGpsCoordinates(gpsCoordinates); return this; }
        public Builder subCategoryType(String subCategoryType) { dto.setSubCategoryType(subCategoryType); return this; }
        public Builder societyName(String societyName) { dto.setSocietyName(societyName); return this; }
        public Builder chsRegNo(String chsRegNo) { dto.setChsRegNo(chsRegNo); return this; }
        public Builder orgName(String orgName) { dto.setOrgName(orgName); return this; }
        public Builder cinNumber(String cinNumber) { dto.setCinNumber(cinNumber); return this; }
        public Builder tradeLicenseNo(String tradeLicenseNo) { dto.setTradeLicenseNo(tradeLicenseNo); return this; }
        public Builder totalFloors(String totalFloors) { dto.setTotalFloors(totalFloors); return this; }
        public Builder totalUnits(String totalUnits) { dto.setTotalUnits(totalUnits); return this; }
        public Builder builtUpAreaSqM(BigDecimal builtUpAreaSqM) { dto.setBuiltUpAreaSqM(builtUpAreaSqM); return this; }
        public Builder buildingRemarks(String buildingRemarks) { dto.setBuildingRemarks(buildingRemarks); return this; }
        public Builder buildingPermissionDocUrl(String buildingPermissionDocUrl) { dto.setBuildingPermissionDocUrl(buildingPermissionDocUrl); return this; }
        public Builder buildingPermissionGeo(String buildingPermissionGeo) { dto.setBuildingPermissionGeo(buildingPermissionGeo); return this; }
        public Builder buildingPermissionTime(String buildingPermissionTime) { dto.setBuildingPermissionTime(buildingPermissionTime); return this; }
        public Builder waterConsumerNo(String waterConsumerNo) { dto.setWaterConsumerNo(waterConsumerNo); return this; }
        public Builder dailyWaterConsumptionLiters(BigDecimal dailyWaterConsumptionLiters) { dto.setDailyWaterConsumptionLiters(dailyWaterConsumptionLiters); return this; }
        public Builder waterBillDocUrl(String waterBillDocUrl) { dto.setWaterBillDocUrl(waterBillDocUrl); return this; }
        public Builder binInfrastructure(String binInfrastructure) { dto.setBinInfrastructure(binInfrastructure); return this; }
        public Builder segregatedAtSource(String segregatedAtSource) { dto.setSegregatedAtSource(segregatedAtSource); return this; }
        public Builder dryWasteChannelizedTo(String dryWasteChannelizedTo) { dto.setDryWasteChannelizedTo(dryWasteChannelizedTo); return this; }
        public Builder hasBiogasPlant(Boolean hasBiogasPlant) { dto.setHasBiogasPlant(hasBiogasPlant); return this; }
        public Builder biogasCapacity(String biogasCapacity) { dto.setBiogasCapacity(biogasCapacity); return this; }
        public Builder biogasCapacityUnit(String biogasCapacityUnit) { dto.setBiogasCapacityUnit(biogasCapacityUnit); return this; }
        public Builder biogasOperationalStatus(String biogasOperationalStatus) { dto.setBiogasOperationalStatus(biogasOperationalStatus); return this; }
        public Builder biogasPhotoUrl(String biogasPhotoUrl) { dto.setBiogasPhotoUrl(biogasPhotoUrl); return this; }
        public Builder biogasRemarks(String biogasRemarks) { dto.setBiogasRemarks(biogasRemarks); return this; }
        public Builder wasteGivenToOtherAgency(String wasteGivenToOtherAgency) { dto.setWasteGivenToOtherAgency(wasteGivenToOtherAgency); return this; }
        public Builder agencyDocumentPhotoUrl(String agencyDocumentPhotoUrl) { dto.setAgencyDocumentPhotoUrl(agencyDocumentPhotoUrl); return this; }
        public Builder geofenceLatitude(String geofenceLatitude) { dto.setGeofenceLatitude(geofenceLatitude); return this; }
        public Builder geofenceLongitude(String geofenceLongitude) { dto.setGeofenceLongitude(geofenceLongitude); return this; }
        public Builder geofencePhotoUrl(String geofencePhotoUrl) { dto.setGeofencePhotoUrl(geofencePhotoUrl); return this; }
        public Builder eligibilityFloorArea(Boolean eligibilityFloorArea) { dto.setEligibilityFloorArea(eligibilityFloorArea); return this; }
        public Builder eligibilityWaterConsumption(Boolean eligibilityWaterConsumption) { dto.setEligibilityWaterConsumption(eligibilityWaterConsumption); return this; }
        public Builder eligibilitySolidWaste(Boolean eligibilitySolidWaste) { dto.setEligibilitySolidWaste(eligibilitySolidWaste); return this; }
        public Builder declarantName(String declarantName) { dto.setDeclarantName(declarantName); return this; }
        public Builder declarantDesignation(String declarantDesignation) { dto.setDeclarantDesignation(declarantDesignation); return this; }
        public Builder declarantOrgName(String declarantOrgName) { dto.setDeclarantOrgName(declarantOrgName); return this; }
        public Builder declarantDate(String declarantDate) { dto.setDeclarantDate(declarantDate); return this; }
        public Builder declarantPlace(String declarantPlace) { dto.setDeclarantPlace(declarantPlace); return this; }
        public Builder declarationFileUrl(String declarationFileUrl) { dto.setDeclarationFileUrl(declarationFileUrl); return this; }
        public Builder declarationFileGeo(String declarationFileGeo) { dto.setDeclarationFileGeo(declarationFileGeo); return this; }
        public Builder declarationFileTime(String declarationFileTime) { dto.setDeclarationFileTime(declarationFileTime); return this; }
        public Builder surveyorName(String surveyorName) { dto.setSurveyorName(surveyorName); return this; }
        public Builder surveyorSelfieUrl(String surveyorSelfieUrl) { dto.setSurveyorSelfieUrl(surveyorSelfieUrl); return this; }
        public Builder surveyorGps(String surveyorGps) { dto.setSurveyorGps(surveyorGps); return this; }
        public Builder surveyorTimestamp(String surveyorTimestamp) { dto.setSurveyorTimestamp(surveyorTimestamp); return this; }
        public Builder surveyorVerified(Boolean surveyorVerified) { dto.setSurveyorVerified(surveyorVerified); return this; }
        public Builder avgWetWasteKg(BigDecimal avgWetWasteKg) { dto.setAvgWetWasteKg(avgWetWasteKg); return this; }
        public Builder avgDryWasteKg(BigDecimal avgDryWasteKg) { dto.setAvgDryWasteKg(avgDryWasteKg); return this; }
        public Builder avgTotalWasteKg(BigDecimal avgTotalWasteKg) { dto.setAvgTotalWasteKg(avgTotalWasteKg); return this; }
        public Builder cpcbCompleted(Boolean cpcbCompleted) { dto.setCpcbCompleted(cpcbCompleted); return this; }
        public Builder cpcbAckNumber(String cpcbAckNumber) { dto.setCpcbAckNumber(cpcbAckNumber); return this; }
        public Builder cpcbSubmissionDate(String cpcbSubmissionDate) { dto.setCpcbSubmissionDate(cpcbSubmissionDate); return this; }
        public Builder signagePhotoUrl(String signagePhotoUrl) { dto.setSignagePhotoUrl(signagePhotoUrl); return this; }
        public Builder signagePhotoGeo(String signagePhotoGeo) { dto.setSignagePhotoGeo(signagePhotoGeo); return this; }
        public Builder signagePhotoTime(String signagePhotoTime) { dto.setSignagePhotoTime(signagePhotoTime); return this; }
        public Builder ptin(String ptin) { dto.setPtin(ptin); return this; }
        public Builder gstin(String gstin) { dto.setGstin(gstin); return this; }
        public Builder buildingPermissionRefNo(String buildingPermissionRefNo) { dto.setBuildingPermissionRefNo(buildingPermissionRefNo); return this; }
        public Builder waterBillingPeriod(String waterBillingPeriod) { dto.setWaterBillingPeriod(waterBillingPeriod); return this; }
        public Builder waterUnitsConsumed(String waterUnitsConsumed) { dto.setWaterUnitsConsumed(waterUnitsConsumed); return this; }
        public Builder overallDisposalMode(String overallDisposalMode) { dto.setOverallDisposalMode(overallDisposalMode); return this; }
        public Builder vendorName(String vendorName) { dto.setVendorName(vendorName); return this; }
        public Builder mouValidity(String mouValidity) { dto.setMouValidity(mouValidity); return this; }
        public Builder processingDestination(String processingDestination) { dto.setProcessingDestination(processingDestination); return this; }
        public Builder privateVendorDetails(String privateVendorDetails) { dto.setPrivateVendorDetails(privateVendorDetails); return this; }
        public Builder processingMethod(String processingMethod) { dto.setProcessingMethod(processingMethod); return this; }
        public Builder spaceAvailableSqMeters(String spaceAvailableSqMeters) { dto.setSpaceAvailableSqMeters(spaceAvailableSqMeters); return this; }
        public Builder byProductUsage(String byProductUsage) { dto.setByProductUsage(byProductUsage); return this; }
        public Builder geofenceRadiusMeters(String geofenceRadiusMeters) { dto.setGeofenceRadiusMeters(geofenceRadiusMeters); return this; }
        public Builder qrCodeDataBase64(String qrCodeDataBase64) { dto.setQrCodeDataBase64(qrCodeDataBase64); return this; }
        public Builder wasteVisits(List<WasteVisitDto> wasteVisits) { dto.setWasteVisits(wasteVisits); return this; }
        public Builder createdAt(LocalDateTime createdAt) { dto.setCreatedAt(createdAt); return this; }
        public Builder updatedAt(LocalDateTime updatedAt) { dto.setUpdatedAt(updatedAt); return this; }

        public SurveyResponseDto build() { return dto; }
    }
}
