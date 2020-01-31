package edu.asu.diging.citesphere.model.bib;

public interface ICitationCollection extends IGrouping {

    long getVersion();

    void setVersion(long version);

    long getNumberOfCollections();

    void setNumberOfCollections(long numberOfCollections);

    long getNumberOfItems();

    void setNumberOfItems(long numberOfItems);

    ICitationGroup getGroup();

    void setGroup(ICitationGroup group);

    void setParentCollectionKey(String parentCollectionKey);

    String getParentCollectionKey();

    void setLastModified(String lastModified);

    String getLastModified();

}