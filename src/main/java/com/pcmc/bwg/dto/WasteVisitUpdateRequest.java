package com.pcmc.bwg.dto;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class WasteVisitUpdateRequest {

    @NotNull(message = "Day number is required (1, 2, or 3)")
    private Integer dayNumber;

    private String visitDate;
    private BigDecimal wetWasteKg;
    private BigDecimal dryWasteKg;
    private BigDecimal gardenWasteKg;
    private String wetWastePhotoUrl;
    private String dryWastePhotoUrl;
    private String gardenWastePhotoUrl;

    public WasteVisitUpdateRequest() {}

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

    public String getWetWastePhotoUrl() { return wetWastePhotoUrl; }
    public void setWetWastePhotoUrl(String wetWastePhotoUrl) { this.wetWastePhotoUrl = wetWastePhotoUrl; }

    public String getDryWastePhotoUrl() { return dryWastePhotoUrl; }
    public void setDryWastePhotoUrl(String dryWastePhotoUrl) { this.dryWastePhotoUrl = dryWastePhotoUrl; }

    public String getGardenWastePhotoUrl() { return gardenWastePhotoUrl; }
    public void setGardenWastePhotoUrl(String gardenWastePhotoUrl) { this.gardenWastePhotoUrl = gardenWastePhotoUrl; }
}
