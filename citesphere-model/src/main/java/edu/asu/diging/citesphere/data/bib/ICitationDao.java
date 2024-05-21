package edu.asu.diging.citesphere.data.bib;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.util.CloseableIterator;

import edu.asu.diging.citesphere.model.bib.ICitation;
import edu.asu.diging.citesphere.model.bib.impl.Person;
import edu.asu.diging.citesphere.model.transfer.impl.Citations;
import edu.asu.diging.citesphere.model.transfer.impl.Persons;

public interface ICitationDao {

    List<? extends ICitation> findCitations(String groupId, long start, int pageSize, boolean isDeleted, List<String> conceptIds);

    List<? extends ICitation> findCitationsInCollection(String groupId, String collectionId, long start, int pageSize, List<String> conceptIds);

   
    /**
     * This method returns a query that is built to find all citations
     * belong to the user's groups' and whose authors' uri, editors' uri or
     * other creators' uri matches to that of the argument 'uri'
     * @param Group ids of the groups that should be searched.
     * @param uri the contributor uri of a citation that at least
     * one of returned citations' authors uri, editors uri or
     * other creators uri should be
     * @return a query that can be used or further updated to find 
     * total count of citations or fetch citations in the given groups
     * that have their author's uri or editor's uri or contributor's 
     * uri matched to that of the argument uriauthor's .
     */ 
    Query buildQueryToFindCitationsByContributorUri(List<String> groupIds, String uri);
    
    /**
     * This method returns all citations which belongs to the
     * user's groups' and whose authors' uri, editors' uri or
     * other creators' uri matches to that of the argument 'uri'
     * @param Group ids of the groups that should be searched.
     * @param uri the contributor uri of a citation that at least
     * one of returned citations' authors uri, editors uri or
     * other creators uri should be
     * @return all citations in the given groups that have their author's
     * uri or editor's uri or contributor's uri matched to that of
     * the argument uri
     */
    List<? extends ICitation> findCitationsByContributorUri(List<String> groupIds, long start, int pageSize, String uri);
    
    /**
     * This method returns the total count of the citations which
     * belong to the user's groups and whose authors' uri, editors'
     * uri or other creators' uri matches to that of the argument 'uri'
     * @param groupIds of the groups that should be searched
     * @param uri the contributor uri of a citation that atleast one of
     * returned citations should be
     * @return total count of all citations in the given groups that have
     * their author's uri or editor's uri or contributor's uri matched to
     * that of argument uri
     */
    long countCitationsByContributorUri(List<String> groupIds, String uri);

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