package edu.asu.diging.citesphere.model.transfer.impl;

import java.util.List;

import edu.asu.diging.citesphere.model.bib.impl.Person;

public class Persons {

    private String id;
    private List<Person> persons;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<Person> getPersons() {
        return persons;
    }
    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
