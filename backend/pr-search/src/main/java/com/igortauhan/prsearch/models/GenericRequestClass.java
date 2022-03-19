package com.igortauhan.prsearch.models;


import java.util.List;

public class GenericRequestClass {

    List<Records> records;

    public GenericRequestClass() {

    }

    public GenericRequestClass(List<Records> records) {
        this.records = records;
    }

    public List<Records> getRecords() {
        return records;
    }

    public void setRecords(List<Records> records) {
        this.records = records;
    }
}
