package com.pcmc.bwg.dto;

public class DashboardStatsDto {

    private CategoryStatDto residential;
    private CategoryStatDto commercial;
    private CategoryStatDto institutional;
    private CategoryStatDto overall;

    public DashboardStatsDto() {}

    public DashboardStatsDto(CategoryStatDto residential, CategoryStatDto commercial, CategoryStatDto institutional, CategoryStatDto overall) {
        this.residential = residential;
        this.commercial = commercial;
        this.institutional = institutional;
        this.overall = overall;
    }

    public CategoryStatDto getResidential() { return residential; }
    public void setResidential(CategoryStatDto residential) { this.residential = residential; }

    public CategoryStatDto getCommercial() { return commercial; }
    public void setCommercial(CategoryStatDto commercial) { this.commercial = commercial; }

    public CategoryStatDto getInstitutional() { return institutional; }
    public void setInstitutional(CategoryStatDto institutional) { this.institutional = institutional; }

    public CategoryStatDto getOverall() { return overall; }
    public void setOverall(CategoryStatDto overall) { this.overall = overall; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private CategoryStatDto residential;
        private CategoryStatDto commercial;
        private CategoryStatDto institutional;
        private CategoryStatDto overall;

        public Builder residential(CategoryStatDto residential) { this.residential = residential; return this; }
        public Builder commercial(CategoryStatDto commercial) { this.commercial = commercial; return this; }
        public Builder institutional(CategoryStatDto institutional) { this.institutional = institutional; return this; }
        public Builder overall(CategoryStatDto overall) { this.overall = overall; return this; }

        public DashboardStatsDto build() {
            return new DashboardStatsDto(residential, commercial, institutional, overall);
        }
    }

    public static class CategoryStatDto {
        private String category;
        private String title;
        private StatCountDto totalSurvey;
        private StatCountDto surveyApproved;
        private StatCountDto surveyRejected;
        private StatCountDto approvalPending;

        public CategoryStatDto() {}

        public CategoryStatDto(String category, String title, StatCountDto totalSurvey, StatCountDto surveyApproved, StatCountDto surveyRejected, StatCountDto approvalPending) {
            this.category = category;
            this.title = title;
            this.totalSurvey = totalSurvey;
            this.surveyApproved = surveyApproved;
            this.surveyRejected = surveyRejected;
            this.approvalPending = approvalPending;
        }

        public String getCategory() { return category; }
        public void setCategory(String category) { this.category = category; }

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public StatCountDto getTotalSurvey() { return totalSurvey; }
        public void setTotalSurvey(StatCountDto totalSurvey) { this.totalSurvey = totalSurvey; }

        public StatCountDto getSurveyApproved() { return surveyApproved; }
        public void setSurveyApproved(StatCountDto surveyApproved) { this.surveyApproved = surveyApproved; }

        public StatCountDto getSurveyRejected() { return surveyRejected; }
        public void setSurveyRejected(StatCountDto surveyRejected) { this.surveyRejected = surveyRejected; }

        public StatCountDto getApprovalPending() { return approvalPending; }
        public void setApprovalPending(StatCountDto approvalPending) { this.approvalPending = approvalPending; }

        public static Builder builder() { return new Builder(); }

        public static class Builder {
            private String category;
            private String title;
            private StatCountDto totalSurvey;
            private StatCountDto surveyApproved;
            private StatCountDto surveyRejected;
            private StatCountDto approvalPending;

            public Builder category(String category) { this.category = category; return this; }
            public Builder title(String title) { this.title = title; return this; }
            public Builder totalSurvey(StatCountDto totalSurvey) { this.totalSurvey = totalSurvey; return this; }
            public Builder surveyApproved(StatCountDto surveyApproved) { this.surveyApproved = surveyApproved; return this; }
            public Builder surveyRejected(StatCountDto surveyRejected) { this.surveyRejected = surveyRejected; return this; }
            public Builder approvalPending(StatCountDto approvalPending) { this.approvalPending = approvalPending; return this; }

            public CategoryStatDto build() {
                return new CategoryStatDto(category, title, totalSurvey, surveyApproved, surveyRejected, approvalPending);
            }
        }
    }

    public static class StatCountDto {
        private long count;
        private String percent;

        public StatCountDto() {}

        public StatCountDto(long count, String percent) {
            this.count = count;
            this.percent = percent;
        }

        public long getCount() { return count; }
        public void setCount(long count) { this.count = count; }

        public String getPercent() { return percent; }
        public void setPercent(String percent) { this.percent = percent; }
    }
}
