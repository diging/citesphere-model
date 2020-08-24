package edu.asu.diging.citesphere.model.bib;

import java.time.OffsetDateTime;
import java.util.List;

import org.bson.types.ObjectId;

public interface ICitationGroup extends IGrouping {

    ObjectId getId();
    
    void setId(ObjectId id);
    
    long getVersion();

    void setVersion(long version);

    String getCreated();

    void setCreated(String created);

    String getLastModified();

    void setLastModified(String lastModified);

    long getNumItems();

    void setNumItems(long numItems);

    List<String> getCitations();

    void setCitations(List<String> citations);

    void setFileEditing(String fileEditing);

    String getFileEditing();

    void setLibraryReading(String libraryReading);

    String getLibraryReading();

    void setLibraryEditing(String libraryEditing);

    String getLibraryEditing();

    void setUrl(String url);

    String getUrl();

    void setDescription(String description);

    String getDescription();

    void setType(String type);

    String getType();

    void setOwner(long owner);

    long getOwner();

    void setUpdatedOn(String updatedOn);

    String getUpdatedOn();

    void setLastLocallyModifiedOn(String lastLocallyModifiedOn);

    String getLastLocallyModifiedOn();

    void setUsers(List<String> users);

    List<String> getUsers();

    void setGroupId(long groupId);

    long getGroupId();

}