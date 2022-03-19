package com.igortauhan.prsearch.models.intx;

public class RequestBody {

    private String term;

    public RequestBody() {

    }

    public RequestBody(String term) {
        this.term = term;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
