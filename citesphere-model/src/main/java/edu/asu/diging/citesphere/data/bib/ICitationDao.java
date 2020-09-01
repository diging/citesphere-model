package edu.asu.diging.citesphere.data.bib;

import java.util.List;

import edu.asu.diging.citesphere.model.bib.ICitation;

public interface ICitationDao {

    List<? extends ICitation> findCitations(String groupId, long start, int pageSize);

    List<? extends ICitation> findCitationsInCollection(String groupId, String collectionId, long start, int pageSize);

}