package edu.asu.diging.citesphere.model.bib.impl;

import edu.asu.diging.citesphere.model.bib.ICitationConceptTag;

public class CitationConceptTag implements ICitationConceptTag {

    private String conceptName;
    private String conceptUri;
    private String localConceptId;
    private String typeName;
    private String typeUri;
    private String localConceptTypeId;

    @Override
    public String getConceptName() {
        return conceptName;
    }

    @Override
    public void setConceptName(String conceptName) {
        this.conceptName = conceptName;
    }

    @Override
    public String getConceptUri() {
        return conceptUri;
    }

    @Override
    public void setConceptUri(String conceptUri) {
        this.conceptUri = conceptUri;
    }

    @Override
    public String getLocalConceptId() {
        return localConceptId;
    }

    @Override
    public void setLocalConceptId(String localConceptId) {
        this.localConceptId = localConceptId;
    }

    @Override
    public String getTypeName() {
        return typeName;
    }

    @Override
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String getTypeUri() {
        return typeUri;
    }

    @Override
    public void setTypeUri(String typeUri) {
        this.typeUri = typeUri;
    }

    @Override
    public String getLocalConceptTypeId() {
        return localConceptTypeId;
    }

    @Override
    public void setLocalConceptTypeId(String localConceptTypeId) {
        this.localConceptTypeId = localConceptTypeId;
    }

}
