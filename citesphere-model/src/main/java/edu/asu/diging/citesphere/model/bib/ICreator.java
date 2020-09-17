package edu.asu.diging.citesphere.model.bib;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import edu.asu.diging.citesphere.model.bib.impl.Creator;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = Creator.class)
public interface ICreator {

    String getRole();

    void setRole(String role);

    IPerson getPerson();

    void setPerson(IPerson person);

    void setPositionInList(int positionInList);

    int getPositionInList();

    ObjectId getId();
    
}