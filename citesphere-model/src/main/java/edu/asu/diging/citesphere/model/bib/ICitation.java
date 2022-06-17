package edu.asu.diging.citesphere.model.bib;

import java.util.List;
import java.util.Set;

import org.springframework.social.zotero.api.Tag;

public interface ICitation {

    String getKey();

    void setKey(String key);

    String getTitle();

    void setTitle(String title);
    
    String getParentItem();
    
    void setParentItem(String parentItem);

    Set<IPerson> getAuthors();

    void setAuthors(Set<IPerson> authors);

    Set<IPerson> getEditors();

    void setEditors(Set<IPerson> editors);

    ItemType getItemType();

    void setItemType(ItemType itemType);

    String getPublicationTitle();

    void setPublicationTitle(String publicationTitle);

    String getVolume();

    void setVolume(String volume);

    String getIssue();

    void setIssue(String issue);

    String getPages();

    void setPages(String pages);

    String getDate();

    void setDate(String date);

    String getSeries();

    void setSeries(String series);

    String getSeriesTitle();

    void setSeriesTitle(String seriesTitle);

    void setDateFreetext(String dateFreetext);

    String getDateFreetext();

    void setUrl(String url);

    String getUrl();

    void setRights(String rights);

    String getRights();

    void setCallNumber(String callNumber);

    String getCallNumber();

    void setLibraryCatalog(String libraryCatalog);

    String getLibraryCatalog();

    void setArchiveLocation(String archiveLocation);

    String getArchiveLocation();

    void setArchive(String archive);

    String getArchive();

    void setShortTitle(String shortTitle);

    String getShortTitle();

    void setIssn(String issn);

    String getIssn();

    void setDoi(String doi);

    String getDoi();

    void setLanguage(String language);

    String getLanguage();

    void setJournalAbbreviation(String journalAbbreviation);

    String getJournalAbbreviation();

    void setSeriesText(String seriesText);

    String getSeriesText();
    
    void setNote(String note);
    
    String getNote();

    void setAbstractNote(String abstractNote);

    String getAbstractNote();

    void setExtra(String extra);

    String getExtra();

    void setAccessDate(String accessDate);

    String getAccessDate();

    void setDateAdded(String dateAdded);

    String getDateAdded();

    void setDateModified(String dateModified);

    String getDateModified();

    void setVersion(long version);

    long getVersion();

    void setGroup(String group);

    String getGroup();
    
    String getMetaDataItemKey();
    
    void setMetaDataItemKey(String metaDataItemKey);
    
    long getMetaDataItemVersion();
    
    void setMetaDataItemVersion(long metaDataItemVersion);

    void setOtherCreators(Set<ICreator> otherCreators);

    Set<ICreator> getOtherCreators();

    Set<ICreator> getOtherCreators(String role);

    Set<String> getOtherCreatorRoles();

    void setConceptTags(Set<ICitationConceptTag> concepts);

    Set<ICitationConceptTag> getConceptTags();

    void setReferences(Set<IReference> references);

    Set<IReference> getReferences();

    void setConceptTagIds(Set<String> conceptTagIds);

    Set<String> getConceptTagIds();

    void setCollections(List<String> collections);

    List<String> getCollections();

    void setDeleted(int deleted);

    int getDeleted();
    
    void setGilesUploads(Set<IGilesUpload> gilesUploads);

    Set<IGilesUpload> getGilesUploads();

    List<Tag> getTags();

    void setTags(List<Tag> tags);

    boolean isMetaDataNote();
    
    public int isRemoved();
    
    public void setRemoved(int isRemoved);
}