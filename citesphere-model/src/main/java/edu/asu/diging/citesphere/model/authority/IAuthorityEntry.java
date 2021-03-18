package edu.asu.diging.citesphere.model.authority;

import java.time.OffsetDateTime;
import java.util.List;

import edu.asu.diging.citesphere.model.bib.ICitationGroup;
import edu.asu.diging.citesphere.model.bib.impl.CitationGroup;

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
    
    List<Long> getGroups();
    
    void setGroups(List<Long> groups);
}