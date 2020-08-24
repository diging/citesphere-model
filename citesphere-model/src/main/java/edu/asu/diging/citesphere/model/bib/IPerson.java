package edu.asu.diging.citesphere.model.bib;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import edu.asu.diging.citesphere.model.bib.impl.Person;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = Person.class)
public interface IPerson {

    String getName();

    void setName(String name);

    String getUri();

    void setUri(String uri);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    int getPositionInList();

    void setPositionInList(int order);

    void setAffiliations(Set<IAffiliation> affiliations);

    Set<IAffiliation> getAffiliations();

    void setLocalAuthorityId(String localAuthorityId);

    String getLocalAuthorityId();
}