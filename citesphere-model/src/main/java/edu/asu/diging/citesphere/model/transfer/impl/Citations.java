package edu.asu.diging.citesphere.model.transfer.impl;

import java.util.List;

import edu.asu.diging.citesphere.model.bib.impl.Citation;

public class Citations {
    private String id;
    private List<Citation> citations;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<Citation> getCitations() {
        return citations;
    }
    public void setPersons(List<Citation> citations) {
        this.citations = citations;
    }
}
