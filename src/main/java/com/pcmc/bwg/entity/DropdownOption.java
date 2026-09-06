package com.pcmc.bwg.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dropdown_options")
public class DropdownOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_group", nullable = false, length = 50)
    private String categoryGroup;

    @Column(name = "parent_value", length = 100)
    private String parentValue;

    @Column(name = "option_label", nullable = false)
    private String optionLabel;

    @Column(name = "option_value", nullable = false)
    private String optionValue;

    @Column(name = "sort_order", nullable = false)
    private Integer sortOrder = 0;

    @Column(nullable = false)
    private Boolean active = true;

    public DropdownOption() {}

    public DropdownOption(Long id, String categoryGroup, String parentValue, String optionLabel, String optionValue, Integer sortOrder, Boolean active) {
        this.id = id;
        this.categoryGroup = categoryGroup;
        this.parentValue = parentValue;
        this.optionLabel = optionLabel;
        this.optionValue = optionValue;
        this.sortOrder = sortOrder;
        this.active = active;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCategoryGroup() { return categoryGroup; }
    public void setCategoryGroup(String categoryGroup) { this.categoryGroup = categoryGroup; }

    public String getParentValue() { return parentValue; }
    public void setParentValue(String parentValue) { this.parentValue = parentValue; }

    public String getOptionLabel() { return optionLabel; }
    public void setOptionLabel(String optionLabel) { this.optionLabel = optionLabel; }

    public String getOptionValue() { return optionValue; }
    public void setOptionValue(String optionValue) { this.optionValue = optionValue; }

    public Integer getSortOrder() { return sortOrder; }
    public void setSortOrder(Integer sortOrder) { this.sortOrder = sortOrder; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
