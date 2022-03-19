package com.igortauhan.prsearch.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TagsHValues {

    @JsonProperty
    private Integer classWithoutH;
    private String classh;
    private String value;
    private String valueh;

    public TagsHValues() {

    }

    public TagsHValues(Integer classWithoutH, String classh, String value, String valueh) {
        this.classWithoutH = classWithoutH;
        this.classh = classh;
        this.value = value;
        this.valueh = valueh;
    }

    public Integer getClassWithoutH() {
        return classWithoutH;
    }

    public void setClassWithoutH(Integer classWithoutH) {
        this.classWithoutH = classWithoutH;
    }

    public String getClassh() {
        return classh;
    }

    public void setClassh(String classh) {
        this.classh = classh;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueh() {
        return valueh;
    }

    public void setValueh(String valueh) {
        this.valueh = valueh;
    }
}
