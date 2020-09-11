package edu.asu.diging.citesphere.model.bib;

import org.bson.types.ObjectId;

public interface ICitationCollection extends IGrouping {

    long getVersion();

    void setVersion(long version);

    long getNumberOfCollections();

    void setNumberOfCollections(long numberOfCollections);

    long getNumberOfItems();

    void setNumberOfItems(long numberOfItems);

    String getGroupId();

    void setGroupId(String group);

    void setParentCollectionKey(String parentCollectionKey);

    String getParentCollectionKey();

    void setLastModified(String lastModified);

    String getLastModified();

    void setId(ObjectId id);

    ObjectId getId();

    void setContentVersion(long contentVersion);

    long getContentVersion();

}