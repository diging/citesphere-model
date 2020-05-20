package edu.asu.diging.citesphere.model.bib.impl;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.javers.core.metamodel.annotation.DiffIgnore;

import com.fasterxml.jackson.annotation.JsonBackReference;

import edu.asu.diging.citesphere.model.bib.ICitation;
import edu.asu.diging.citesphere.model.bib.ICitationGroup;

@Entity(name="Citation_Group")
public class CitationGroup implements ICitationGroup {

    @Id
    private long id;
    private String name;
    private long version;
    private String created;
    private String lastModified;
    private long numItems;
    
    private long owner;
    private String type;
    private String description;
    private String url;
    private String libraryEditing;
    private String libraryReading;
    private String fileEditing;
    
    private OffsetDateTime updatedOn;
    private OffsetDateTime updateRequestedOn;
    private OffsetDateTime lastLocallyModifiedOn;
    
    @DiffIgnore
    @JsonBackReference
    @OneToMany(targetEntity=Citation.class, mappedBy="group")
    private List<ICitation> citations;
    
    @ElementCollection
    private List<String> users = new ArrayList<String>();

    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.IGroup#getId()
     */
    @Override
    public long getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.IGroup#setId(long)
     */
    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.IGroup#getVersion()
     */
    @Override
    public long getVersion() {
        return version;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.IGroup#setVersion(long)
     */
    @Override
    public void setVersion(long version) {
        this.version = version;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.IGroup#getCreated()
     */
    @Override
    public String getCreated() {
        return created;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.IGroup#setCreated(java.lang.String)
     */
    @Override
    public void setCreated(String created) {
        this.created = created;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.IGroup#getLastModified()
     */
    @Override
    public String getLastModified() {
        return lastModified;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.IGroup#setLastModified(java.lang.String)
     */
    @Override
    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.IGroup#getNumItems()
     */
    @Override
    public long getNumItems() {
        return numItems;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.IGroup#setNumItems(long)
     */
    @Override
    public void setNumItems(long numItems) {
        this.numItems = numItems;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.IGroup#getCitations()
     */
    @Override
    public List<ICitation> getCitations() {
        return citations;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.IGroup#setCitations(java.util.List)
     */
    @Override
    public void setCitations(List<ICitation> citations) {
        this.citations = citations;
    }

    @Override
    public long getOwner() {
        return owner;
    }

    @Override
    public void setOwner(long owner) {
        this.owner = owner;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getLibraryEditing() {
        return libraryEditing;
    }

    @Override
    public void setLibraryEditing(String libraryEditing) {
        this.libraryEditing = libraryEditing;
    }

    @Override
    public String getLibraryReading() {
        return libraryReading;
    }

    @Override
    public void setLibraryReading(String libraryReading) {
        this.libraryReading = libraryReading;
    }

    @Override
    public String getFileEditing() {
        return fileEditing;
    }

    @Override
    public void setFileEditing(String fileEditing) {
        this.fileEditing = fileEditing;
    }

    @Override
    public OffsetDateTime getUpdatedOn() {
        return updatedOn;
    }

    @Override
    public void setUpdatedOn(OffsetDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public OffsetDateTime getLastLocallyModifiedOn() {
        return lastLocallyModifiedOn;
    }

    @Override
    public void setLastLocallyModifiedOn(OffsetDateTime lastLocallyModifiedOn) {
        this.lastLocallyModifiedOn = lastLocallyModifiedOn;
    }

    @Override
    public List<String> getUsers() {
        return users;
    }

    @Override
    public void setUsers(List<String> users) {
        this.users = users;
    }

    @Override
    public String getKey() {
        return id + "";
    }

    /**
     * Do not use this method. It is only a workaround.
     */
    @Override
    public void setKey(String key) {
        // do nothing
    }
    
    @Override
    public OffsetDateTime getUpdateRequestedOn() {
        return updateRequestedOn;
    }
    
    @Override
    public void setUpdateRequestedOn(OffsetDateTime updateRequestedOn) {
        this.updateRequestedOn = updateRequestedOn;
    }
}
