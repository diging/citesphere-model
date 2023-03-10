package edu.asu.diging.citesphere.data.bib;

import java.util.List;

import org.springframework.data.util.CloseableIterator;

import edu.asu.diging.citesphere.model.bib.ICitation;
import edu.asu.diging.citesphere.model.bib.impl.Person;
import edu.asu.diging.citesphere.model.transfer.impl.Citations;
import edu.asu.diging.citesphere.model.transfer.impl.Persons;

public interface ICitationDao {

    List<? extends ICitation> findCitations(String groupId, long start, int pageSize, boolean isDeleted, List<String> conceptIds, String itemType);

    List<? extends ICitation> findCitationsInCollection(String groupId, String collectionId, long start, int pageSize, List<String> conceptIds, String itemType);

    /**
     * This method returns an iterator over all citations in a group and if provided
     * in a collection. This iterator should return the most memory efficient way
     * to iterate over many citations.
     * @param groupId Group id for the group returned citations should be in.
     * @param collectionId Collection id for the collection the returned citations
     *      should be in. If null, all citations in provided group will be returned.
     * @return An iterator over all citations in the specific group and collection
     *      that should be closed.
     */
    CloseableIterator<? extends ICitation> getCitationIterator(String groupId, String collectionId);

    Persons findAllPeople(String groupId, long start, int pageSize);

    Citations findCitationsByPersonUri(String uri);
    
    Citations findCitationsByPersonCitationKey(String citationKey);
}