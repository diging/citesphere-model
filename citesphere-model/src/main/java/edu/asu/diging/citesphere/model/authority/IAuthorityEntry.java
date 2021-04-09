package edu.asu.diging.citesphere.model.authority;

import java.time.OffsetDateTime;
import java.util.Set;

public interface IAuthorityEntry {

    String getId();

    void setId(String id);

    String getName();

    void setName(String name);

    String getUri();

    void setUri(String uri);

    void setImporterId(String importerId);

    String getImporterId();

    void setUsername(String username);

    String getUsername();

    void setCreatedOn(OffsetDateTime createdOn);

    OffsetDateTime getCreatedOn();

    void setDescription(String description);

    String getDescription();
    
    Set<Long> getGroups();
    
    void setGroups(Set<Long> groups);
}