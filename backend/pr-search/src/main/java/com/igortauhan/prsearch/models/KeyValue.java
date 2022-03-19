package com.igortauhan.prsearch.models;

public class KeyValue {
    private static final Long serialVersionUID = 1L;

    private Long id;
    private String key;
    private String value;

    private Records records;

    public KeyValue() {

    }

    public KeyValue(Long id, String key, String value, Records records) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.records = records;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Records getRecords() {
        return records;
    }

    public void setRecords(Records records) {
        this.records = records;
    }
}
