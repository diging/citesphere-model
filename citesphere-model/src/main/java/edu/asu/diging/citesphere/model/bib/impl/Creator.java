package edu.asu.diging.citesphere.model.bib.impl;

import org.bson.types.ObjectId;

import edu.asu.diging.citesphere.model.bib.ICreator;
import edu.asu.diging.citesphere.model.bib.IPerson;

public class Creator implements ICreator, Comparable<ICreator> {

    private ObjectId id;
    private String role;
    private IPerson person;
    
    // not ideal but ah well, crappy data model
    private int positionInList;
    

    public ObjectId getId() {
        return id;
    }
    
    public void setId(ObjectId id) {
        this.id = id;
    }
    
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.ICreator#getRole()
     */
    @Override
    public String getRole() {
        return role;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.ICreator#setRole(java.lang.String)
     */
    @Override
    public void setRole(String role) {
        this.role = role;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.ICreator#getPerson()
     */
    @Override
    public IPerson getPerson() {
        return person;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.ICreator#setPerson(edu.asu.diging.citesphere.core.model.bib.IPerson)
     */
    @Override
    public void setPerson(IPerson person) {
        this.person = person;
    }
    @Override
    public int getPositionInList() {
        return positionInList;
    }
    @Override
    public void setPositionInList(int positionInList) {
        this.positionInList = positionInList;
    }
    @Override
    public int compareTo(ICreator o) {
        int compared = getRole().compareTo(o.getRole());
        if (compared == 0) {
            compared = getPositionInList() - o.getPositionInList();
            if (compared == 0) {
                return person.getName().compareTo(o.getPerson().getName());
            }
        }
        return compared;
    }
}
