package com.pcmc.bwg.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "survey_waste_visits")
public class SurveyWasteVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id", nullable = false)
    @JsonBackReference
    private Survey survey;

    @Column(name = "day_number", nullable = false)
    private Integer dayNumber;

    @Column(name = "visit_date", length = 50)
    private String visitDate;

    @Column(name = "wet_waste_kg")
    private BigDecimal wetWasteKg = BigDecimal.ZERO;

    @Column(name = "dry_waste_kg")
    private BigDecimal dryWasteKg = BigDecimal.ZERO;

    @Column(name = "garden_waste_kg")
    private BigDecimal gardenWasteKg = BigDecimal.ZERO;

    @Column(name = "total_waste_kg")
    private BigDecimal totalWasteKg = BigDecimal.ZERO;

    @Column(name = "wet_waste_photo_url", length = 500)
    private String wetWastePhotoUrl;

    @Column(name = "dry_waste_photo_url", length = 500)
    private String dryWastePhotoUrl;

    @Column(name = "garden_waste_photo_url", length = 500)
    private String gardenWastePhotoUrl;

    @Column(name = "weighing_scale_photo_url", length = 500)
    private String weighingScalePhotoUrl;

    @Column(name = "handover_area_photo_url", length = 500)
    private String handoverAreaPhotoUrl;

    @Column(name = "is_completed")
    private Boolean isCompleted = false;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public SurveyWasteVisit() {}

    public SurveyWasteVisit(Long id, Survey survey, Integer dayNumber, String visitDate, BigDecimal wetWasteKg, BigDecimal dryWasteKg, BigDecimal gardenWasteKg, BigDecimal totalWasteKg, String wetWastePhotoUrl, String dryWastePhotoUrl, String gardenWastePhotoUrl, String weighingScalePhotoUrl, String handoverAreaPhotoUrl, Boolean isCompleted, LocalDateTime createdAt) {
        this.id = id;
        this.survey = survey;
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
        this.createdAt = createdAt;
    }

    public SurveyWasteVisit(Long id, Survey survey, Integer dayNumber, String visitDate, BigDecimal wetWasteKg, BigDecimal dryWasteKg, BigDecimal gardenWasteKg, BigDecimal totalWasteKg, String wetWastePhotoUrl, String dryWastePhotoUrl, String gardenWastePhotoUrl, Boolean isCompleted, LocalDateTime createdAt) {
        this(id, survey, dayNumber, visitDate, wetWasteKg, dryWasteKg, gardenWasteKg, totalWasteKg, wetWastePhotoUrl, dryWastePhotoUrl, gardenWastePhotoUrl, null, null, isCompleted, createdAt);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Survey getSurvey() { return survey; }
    public void setSurvey(Survey survey) { this.survey = survey; }

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

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long id;
        private Survey survey;
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
        private LocalDateTime createdAt;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder survey(Survey survey) { this.survey = survey; return this; }
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
        public Builder createdAt(LocalDateTime createdAt) { this.createdAt = createdAt; return this; }

        public SurveyWasteVisit build() {
            return new SurveyWasteVisit(id, survey, dayNumber, visitDate, wetWasteKg, dryWasteKg, gardenWasteKg, totalWasteKg, wetWastePhotoUrl, dryWastePhotoUrl, gardenWastePhotoUrl, weighingScalePhotoUrl, handoverAreaPhotoUrl, isCompleted, createdAt);
        }
    }
}
