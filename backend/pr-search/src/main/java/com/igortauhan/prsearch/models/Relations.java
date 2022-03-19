package com.igortauhan.prsearch.models;

public class Relations {

    private static final Long serialVersionUID = 1L;

    private Long id;
    private String target;
    private Integer relation;

    private Records records;

    public Relations() {

    }

    public Relations(Long id, String target, Integer relation, Records records) {
        this.id = id;
        this.target = target;
        this.relation = relation;
        this.records = records;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getRelation() {
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }

    public Records getRecords() {
        return records;
    }

    public void setRecords(Records records) {
        this.records = records;
    }
}
