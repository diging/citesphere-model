package edu.asu.diging.citesphere.model.bib.impl;

import javax.persistence.Column;
import javax.persistence.Id;

import org.bson.types.ObjectId;

import edu.asu.diging.citesphere.model.bib.ICitationCollection;

public class CitationCollection implements ICitationCollection {

    
    @Id
    private ObjectId id;
    @Column(name="collectionKey")
    private String key;
    private long version;
    private long numberOfCollections;
    private long numberOfItems;
    private String name;
    private String parentCollectionKey;
    private String lastModified;
    private String groupId;
    
    @Override
    public ObjectId getId() {
        return id;
    }
    @Override
    public void setId(ObjectId id) {
        this.id = id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.ICitationCollection#getKey()
     */
    @Override
    public String getKey() {
        return key;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.ICitationCollection#setKey(java.lang.String)
     */
    @Override
    public void setKey(String key) {
        this.key = key;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.ICitationCollection#getVersion()
     */
    @Override
    public long getVersion() {
        return version;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.ICitationCollection#setVersion(long)
     */
    @Override
    public void setVersion(long version) {
        this.version = version;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.ICitationCollection#getNumberOfCollections()
     */
    @Override
    public long getNumberOfCollections() {
        return numberOfCollections;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.ICitationCollection#setNumberOfCollections(long)
     */
    @Override
    public void setNumberOfCollections(long numberOfCollections) {
        this.numberOfCollections = numberOfCollections;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.ICitationCollection#getNumberOfItems()
     */
    @Override
    public long getNumberOfItems() {
        return numberOfItems;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.ICitationCollection#setNumberOfItems(long)
     */
    @Override
    public void setNumberOfItems(long numberOfItems) {
        this.numberOfItems = numberOfItems;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.ICitationCollection#getName()
     */
    @Override
    public String getName() {
        return name;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.ICitationCollection#setName(java.lang.String)
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getParentCollectionKey() {
        return parentCollectionKey;
    }
    @Override
    public void setParentCollectionKey(String parentCollectionKey) {
        this.parentCollectionKey = parentCollectionKey;
    }
    @Override
    public String getLastModified() {
        return lastModified;
    }
    @Override
    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }
    public String getGroupId() {
        return groupId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    
}
