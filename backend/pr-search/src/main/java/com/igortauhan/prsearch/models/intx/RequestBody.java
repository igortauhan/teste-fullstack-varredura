package com.igortauhan.prsearch.models.intx;

public class RequestBody {

    private String term;
    private Integer maxresults;

    public RequestBody() {

    }

    public RequestBody(String term, Integer maxresults) {
        this.term = term;
        this.maxresults = maxresults;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Integer getMaxresults() {
        return maxresults;
    }

    public void setMaxresults(Integer maxresults) {
        this.maxresults = maxresults;
    }
}
