package edu.asu.diging.citesphere.model.transfer.impl;

import java.util.List;

import edu.asu.diging.citesphere.model.bib.ICitation;

public class Citations {

    private String id;
    private List<ICitation> citations;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<ICitation> getCitations() {
        return citations;
    }
    public void setCitations(List<ICitation> citations) {
        this.citations = citations;
    }
}
