package com.igortauhan.prsearch.models.intx;

public class ResponseBodyRequest {

    private String id;
    private boolean softselectorwarning;
    private Integer status;
    private String altterm;
    private String alttermh;

    public ResponseBodyRequest() {

    }

    public ResponseBodyRequest(String id, boolean softselectorwarning, Integer status, String altterm, String alttermh) {
        this.id = id;
        this.softselectorwarning = softselectorwarning;
        this.status = status;
        this.altterm = altterm;
        this.alttermh = alttermh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSoftselectorwarning() {
        return softselectorwarning;
    }

    public void setSoftselectorwarning(boolean softselectorwarning) {
        this.softselectorwarning = softselectorwarning;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAltterm() {
        return altterm;
    }

    public void setAltterm(String altterm) {
        this.altterm = altterm;
    }

    public String getAlttermh() {
        return alttermh;
    }

    public void setAlttermh(String alttermh) {
        this.alttermh = alttermh;
    }
}
