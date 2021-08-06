package edu.asu.diging.citesphere.data.bib;

import java.util.List;

import edu.asu.diging.citesphere.model.bib.ICitation;
import edu.asu.diging.citesphere.model.bib.impl.CitationVersion;

public interface ICitationVersionsDao {
    
    List<CitationVersion> getVersions(String groupId, String key);
    
    ICitation getVersion(String key, long version);

}
