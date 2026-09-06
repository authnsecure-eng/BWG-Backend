package com.pcmc.bwg.dto;

public class DropdownOptionDto {
    private String label;
    private String value;
    private String group;
    private String parentValue;

    public DropdownOptionDto() {}

    public DropdownOptionDto(String label, String value, String group, String parentValue) {
        this.label = label;
        this.value = value;
        this.group = group;
        this.parentValue = parentValue;
    }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }

    public String getParentValue() { return parentValue; }
    public void setParentValue(String parentValue) { this.parentValue = parentValue; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String label;
        private String value;
        private String group;
        private String parentValue;

        public Builder label(String label) { this.label = label; return this; }
        public Builder value(String value) { this.value = value; return this; }
        public Builder group(String group) { this.group = group; return this; }
        public Builder parentValue(String parentValue) { this.parentValue = parentValue; return this; }

        public DropdownOptionDto build() {
            return new DropdownOptionDto(label, value, group, parentValue);
        }
    }
}
