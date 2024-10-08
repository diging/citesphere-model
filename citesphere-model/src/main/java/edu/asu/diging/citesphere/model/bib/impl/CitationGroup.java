package edu.asu.diging.citesphere.model.bib.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;

import edu.asu.diging.citesphere.model.bib.ICitationGroup;

public class CitationGroup implements ICitationGroup {

    @Id
    private ObjectId id;
    @Indexed(unique = true)
    private long groupId;
    private String name;
    private long metadataVersion;
    private long contentVersion;
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
    
    private String updatedOn;
    private String lastLocallyModifiedOn;
    
    private List<String> citations;
    
    @ElementCollection
    private List<String> users = new ArrayList<String>();

    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.IGroup#getId()
     */
    @Override
    public ObjectId getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.IGroup#setId(long)
     */
    @Override
    public void setId(ObjectId id) {
        this.id = id;
    }

    @Override
    public long getGroupId() {
        return groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        this.groupId = groupId;
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
    public long getMetadataVersion() {
        return metadataVersion;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.IGroup#setVersion(long)
     */
    @Override
    public void setMetadataVersion(long version) {
        this.metadataVersion = version;
    }

    @Override
    public long getContentVersion() {
        return contentVersion;
    }

    @Override
    public void setContentVersion(long contentVersion) {
        this.contentVersion = contentVersion;
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
    public List<String> getCitations() {
        return citations;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.IGroup#setCitations(java.util.List)
     */
    @Override
    public void setCitations(List<String> citations) {
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
    public String getUpdatedOn() {
        return updatedOn;
    }

    @Override
    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String getLastLocallyModifiedOn() {
        return lastLocallyModifiedOn;
    }

    @Override
    public void setLastLocallyModifiedOn(String lastLocallyModifiedOn) {
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
        return groupId + "";
    }

    /**
     * Do not use this method. It is only a workaround.
     */
    @Override
    public void setKey(String key) {
        // do nothing
    }
}
