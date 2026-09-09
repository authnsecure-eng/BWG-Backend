package com.pcmc.bwg.dto;

import java.math.BigDecimal;

public class WasteVisitDto {
    private Integer dayNumber;
    private String visitDate;
    private BigDecimal wetWasteKg;
    private BigDecimal dryWasteKg;
    private BigDecimal gardenWasteKg;
    private BigDecimal totalWasteKg;
    private String wetWastePhotoUrl;
    private String dryWastePhotoUrl;
    private String gardenWastePhotoUrl;
    private String weighingScalePhotoUrl;
    private String handoverAreaPhotoUrl;
    private Boolean isCompleted;

    public WasteVisitDto() {}

    public WasteVisitDto(Integer dayNumber, String visitDate, BigDecimal wetWasteKg, BigDecimal dryWasteKg, BigDecimal gardenWasteKg, BigDecimal totalWasteKg, String wetWastePhotoUrl, String dryWastePhotoUrl, String gardenWastePhotoUrl, String weighingScalePhotoUrl, String handoverAreaPhotoUrl, Boolean isCompleted) {
        this.dayNumber = dayNumber;
        this.visitDate = visitDate;
        this.wetWasteKg = wetWasteKg;
        this.dryWasteKg = dryWasteKg;
        this.gardenWasteKg = gardenWasteKg;
        this.totalWasteKg = totalWasteKg;
        this.wetWastePhotoUrl = wetWastePhotoUrl;
        this.dryWastePhotoUrl = dryWastePhotoUrl;
        this.gardenWastePhotoUrl = gardenWastePhotoUrl;
        this.weighingScalePhotoUrl = weighingScalePhotoUrl;
        this.handoverAreaPhotoUrl = handoverAreaPhotoUrl;
        this.isCompleted = isCompleted;
    }

    public WasteVisitDto(Integer dayNumber, String visitDate, BigDecimal wetWasteKg, BigDecimal dryWasteKg, BigDecimal gardenWasteKg, BigDecimal totalWasteKg, String wetWastePhotoUrl, String dryWastePhotoUrl, String gardenWastePhotoUrl, Boolean isCompleted) {
        this(dayNumber, visitDate, wetWasteKg, dryWasteKg, gardenWasteKg, totalWasteKg, wetWastePhotoUrl, dryWastePhotoUrl, gardenWastePhotoUrl, null, null, isCompleted);
    }

    public Integer getDayNumber() { return dayNumber; }
    public void setDayNumber(Integer dayNumber) { this.dayNumber = dayNumber; }

    public String getVisitDate() { return visitDate; }
    public void setVisitDate(String visitDate) { this.visitDate = visitDate; }

    public BigDecimal getWetWasteKg() { return wetWasteKg; }
    public void setWetWasteKg(BigDecimal wetWasteKg) { this.wetWasteKg = wetWasteKg; }

    public BigDecimal getDryWasteKg() { return dryWasteKg; }
    public void setDryWasteKg(BigDecimal dryWasteKg) { this.dryWasteKg = dryWasteKg; }

    public BigDecimal getGardenWasteKg() { return gardenWasteKg; }
    public void setGardenWasteKg(BigDecimal gardenWasteKg) { this.gardenWasteKg = gardenWasteKg; }

    public BigDecimal getTotalWasteKg() { return totalWasteKg; }
    public void setTotalWasteKg(BigDecimal totalWasteKg) { this.totalWasteKg = totalWasteKg; }

    public String getWetWastePhotoUrl() { return wetWastePhotoUrl; }
    public void setWetWastePhotoUrl(String wetWastePhotoUrl) { this.wetWastePhotoUrl = wetWastePhotoUrl; }

    public String getDryWastePhotoUrl() { return dryWastePhotoUrl; }
    public void setDryWastePhotoUrl(String dryWastePhotoUrl) { this.dryWastePhotoUrl = dryWastePhotoUrl; }

    public String getGardenWastePhotoUrl() { return gardenWastePhotoUrl; }
    public void setGardenWastePhotoUrl(String gardenWastePhotoUrl) { this.gardenWastePhotoUrl = gardenWastePhotoUrl; }

    public String getWeighingScalePhotoUrl() { return weighingScalePhotoUrl; }
    public void setWeighingScalePhotoUrl(String weighingScalePhotoUrl) { this.weighingScalePhotoUrl = weighingScalePhotoUrl; }

    public String getHandoverAreaPhotoUrl() { return handoverAreaPhotoUrl; }
    public void setHandoverAreaPhotoUrl(String handoverAreaPhotoUrl) { this.handoverAreaPhotoUrl = handoverAreaPhotoUrl; }

    public Boolean getIsCompleted() { return isCompleted; }
    public void setIsCompleted(Boolean isCompleted) { this.isCompleted = isCompleted; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Integer dayNumber;
        private String visitDate;
        private BigDecimal wetWasteKg;
        private BigDecimal dryWasteKg;
        private BigDecimal gardenWasteKg;
        private BigDecimal totalWasteKg;
        private String wetWastePhotoUrl;
        private String dryWastePhotoUrl;
        private String gardenWastePhotoUrl;
        private String weighingScalePhotoUrl;
        private String handoverAreaPhotoUrl;
        private Boolean isCompleted;

        public Builder dayNumber(Integer dayNumber) { this.dayNumber = dayNumber; return this; }
        public Builder visitDate(String visitDate) { this.visitDate = visitDate; return this; }
        public Builder wetWasteKg(BigDecimal wetWasteKg) { this.wetWasteKg = wetWasteKg; return this; }
        public Builder dryWasteKg(BigDecimal dryWasteKg) { this.dryWasteKg = dryWasteKg; return this; }
        public Builder gardenWasteKg(BigDecimal gardenWasteKg) { this.gardenWasteKg = gardenWasteKg; return this; }
        public Builder totalWasteKg(BigDecimal totalWasteKg) { this.totalWasteKg = totalWasteKg; return this; }
        public Builder wetWastePhotoUrl(String wetWastePhotoUrl) { this.wetWastePhotoUrl = wetWastePhotoUrl; return this; }
        public Builder dryWastePhotoUrl(String dryWastePhotoUrl) { this.dryWastePhotoUrl = dryWastePhotoUrl; return this; }
        public Builder gardenWastePhotoUrl(String gardenWastePhotoUrl) { this.gardenWastePhotoUrl = gardenWastePhotoUrl; return this; }
        public Builder weighingScalePhotoUrl(String weighingScalePhotoUrl) { this.weighingScalePhotoUrl = weighingScalePhotoUrl; return this; }
        public Builder handoverAreaPhotoUrl(String handoverAreaPhotoUrl) { this.handoverAreaPhotoUrl = handoverAreaPhotoUrl; return this; }
        public Builder isCompleted(Boolean isCompleted) { this.isCompleted = isCompleted; return this; }

        public WasteVisitDto build() {
            return new WasteVisitDto(dayNumber, visitDate, wetWasteKg, dryWasteKg, gardenWasteKg, totalWasteKg, wetWastePhotoUrl, dryWastePhotoUrl, gardenWastePhotoUrl, weighingScalePhotoUrl, handoverAreaPhotoUrl, isCompleted);
        }
    }
}
