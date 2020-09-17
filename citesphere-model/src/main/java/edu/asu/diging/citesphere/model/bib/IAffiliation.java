package edu.asu.diging.citesphere.model.bib;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import edu.asu.diging.citesphere.model.bib.impl.Affiliation;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = Affiliation.class)
public interface IAffiliation {

    String getName();

    void setName(String name);

    String getUri();

    void setUri(String uri);

    void setLocalAuthorityId(String localAuthorityId);

    String getLocalAuthorityId();

}