package com.pcmc.bwg.dto;

public class QRCodeResponseDto {
    private String surveyId;
    private String establishmentName;
    private String category;
    private String zone;
    private String ward;
    private Boolean isBwg;
    private String bwgBadgeText;
    private String qrCodeDataBase64;
    private String generatedAt;

    public QRCodeResponseDto() {}

    public QRCodeResponseDto(String surveyId, String establishmentName, String category, String zone, String ward, Boolean isBwg, String bwgBadgeText, String qrCodeDataBase64, String generatedAt) {
        this.surveyId = surveyId;
        this.establishmentName = establishmentName;
        this.category = category;
        this.zone = zone;
        this.ward = ward;
        this.isBwg = isBwg;
        this.bwgBadgeText = bwgBadgeText;
        this.qrCodeDataBase64 = qrCodeDataBase64;
        this.generatedAt = generatedAt;
    }

    public String getSurveyId() { return surveyId; }
    public void setSurveyId(String surveyId) { this.surveyId = surveyId; }

    public String getEstablishmentName() { return establishmentName; }
    public void setEstablishmentName(String establishmentName) { this.establishmentName = establishmentName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getZone() { return zone; }
    public void setZone(String zone) { this.zone = zone; }

    public String getWard() { return ward; }
    public void setWard(String ward) { this.ward = ward; }

    public Boolean getIsBwg() { return isBwg; }
    public void setIsBwg(Boolean isBwg) { this.isBwg = isBwg; }

    public String getBwgBadgeText() { return bwgBadgeText; }
    public void setBwgBadgeText(String bwgBadgeText) { this.bwgBadgeText = bwgBadgeText; }

    public String getQrCodeDataBase64() { return qrCodeDataBase64; }
    public void setQrCodeDataBase64(String qrCodeDataBase64) { this.qrCodeDataBase64 = qrCodeDataBase64; }

    public String getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(String generatedAt) { this.generatedAt = generatedAt; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String surveyId;
        private String establishmentName;
        private String category;
        private String zone;
        private String ward;
        private Boolean isBwg;
        private String bwgBadgeText;
        private String qrCodeDataBase64;
        private String generatedAt;

        public Builder surveyId(String surveyId) { this.surveyId = surveyId; return this; }
        public Builder establishmentName(String establishmentName) { this.establishmentName = establishmentName; return this; }
        public Builder category(String category) { this.category = category; return this; }
        public Builder zone(String zone) { this.zone = zone; return this; }
        public Builder ward(String ward) { this.ward = ward; return this; }
        public Builder isBwg(Boolean isBwg) { this.isBwg = isBwg; return this; }
        public Builder bwgBadgeText(String bwgBadgeText) { this.bwgBadgeText = bwgBadgeText; return this; }
        public Builder qrCodeDataBase64(String qrCodeDataBase64) { this.qrCodeDataBase64 = qrCodeDataBase64; return this; }
        public Builder generatedAt(String generatedAt) { this.generatedAt = generatedAt; return this; }

        public QRCodeResponseDto build() {
            return new QRCodeResponseDto(surveyId, establishmentName, category, zone, ward, isBwg, bwgBadgeText, qrCodeDataBase64, generatedAt);
        }
    }
}
