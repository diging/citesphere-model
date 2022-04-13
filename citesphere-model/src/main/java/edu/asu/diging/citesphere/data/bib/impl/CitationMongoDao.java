package edu.asu.diging.citesphere.data.bib.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.util.CloseableIterator;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;

import edu.asu.diging.citesphere.data.bib.ICitationDao;
import edu.asu.diging.citesphere.model.bib.ICitation;
import edu.asu.diging.citesphere.model.bib.ItemType;
import edu.asu.diging.citesphere.model.bib.impl.Citation;
import edu.asu.diging.citesphere.model.transfer.impl.Persons;

@Repository
public class CitationMongoDao implements ICitationDao {

    @Autowired
    private MongoTemplate mongoTemplate;
    
    @Override
    public List<? extends ICitation> findCitations(String groupId, long start, int pageSize, boolean isDeleted, List<String> conceptIds) {
        Query query = new Query();
        query.addCriteria(Criteria.where("group").is(groupId));
        query.addCriteria(Criteria.where("itemType").ne(ItemType.NOTE.name()).andOperator(Criteria.where("itemType").ne(ItemType.ATTACHMENT.name())));
        if (!isDeleted) {
            query.addCriteria(new Criteria().orOperator(Criteria.where("deleted").exists(false), Criteria.where("deleted").is(0)));
        } else {
            query.addCriteria(Criteria.where("deleted").is(1));
        }
        if (conceptIds != null && !conceptIds.isEmpty()) {
            query.addCriteria(Criteria.where("conceptTags.localConceptId").in(conceptIds));
        }
        query.skip(start);
        query.limit(pageSize);
        return mongoTemplate.find(query, Citation.class);
    }
    
    /**
     * This method returns an iterator based on a MongoDB cursor.
     * 
     * @param groupId Group id for the group returned citations should be in.
     * @param collectionId Collection id for the collection the returned citations
     *      should be in. If null, all citations in provided group will be returned.
     * @return An iterator over all citations in the specific group and collection that
     *      should be closed.
     */
    @Override
    public CloseableIterator<? extends ICitation> getCitationIterator(String groupId, String collectionId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("group").is(groupId));
        if (collectionId != null) {
            query.addCriteria(Criteria.where("collections").is(collectionId));
        }
        return mongoTemplate.stream(query, Citation.class);
    }
    
    @Override
    public List<? extends ICitation> findCitationsInCollection(String groupId, String collectionId, long start, int pageSize, List<String> conceptIds) {
        Query query = new Query();
        query.addCriteria(Criteria.where("group").is(groupId));
        query.addCriteria(Criteria.where("collections").is(collectionId));
        query.addCriteria(Criteria.where("itemType").ne(ItemType.NOTE.name())
                .andOperator(Criteria.where("itemType").ne(ItemType.ATTACHMENT.name())));
        if (conceptIds != null && !conceptIds.isEmpty()) {
            query.addCriteria(Criteria.where("conceptTags.localConceptId").in(conceptIds));
        }
        query.skip(start);
        query.limit(pageSize);
        return mongoTemplate.find(query, Citation.class);
    }
    
    public List<Citation> findCitatationByName(String name){
    	name=" "+name;
    	ProjectionOperation project = Aggregation.project().and("authors")
                .unionArrays("editors", "otherCreators.person").as("persons").andInclude("group");
    	UnwindOperation unwind = Aggregation.unwind("persons");

        SortOperation sort = Aggregation.sort(Direction.ASC, "persons.name");

        GroupOperation group = Aggregation.group("group")
                .push(new BasicDBObject("name", "$persons.name").append("uri", "$persons.uri")
                        .append("firstName", "$persons.firstName").append("lastName", "$persons.lastName")
                        .append("localAuthorityId", "$persons.localAuthorityId"))
                .as("persons");
        MatchOperation match = Aggregation.match(Criteria.where("authors.name").is(name).orOperator(Criteria.where("editors.name").is(name)).orOperator(Criteria.where("otherCreators.person.name").is(name)));
        AggregationResults<Citation> result = mongoTemplate.aggregate(Aggregation.newAggregation(match,project,unwind,sort,group),Citation.class, Citation.class);
        return  (List<Citation>) result.getUniqueMappedResult();   	
    }
}
