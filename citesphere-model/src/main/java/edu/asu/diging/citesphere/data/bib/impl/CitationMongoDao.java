package edu.asu.diging.citesphere.data.bib.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ConditionalOperators;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SkipOperation;
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
import edu.asu.diging.citesphere.model.bib.impl.Person;
import edu.asu.diging.citesphere.model.transfer.impl.Citations;
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

    @Override
    public List<? extends ICitation> findCitationsByUri(List<String> groupIds, long start, int pageSize, String uri) {
        Query query = new Query();
        query.addCriteria(Criteria.where("group").in(groupIds));
        query.addCriteria(new Criteria().orOperator(Criteria.where("deleted").exists(false), Criteria.where("deleted").is(0)));
        query.addCriteria(new Criteria().orOperator(Criteria.where("authors.uri").is(uri), Criteria.where("editors.uri").is(uri), Criteria.where("otherCreators.person.uri").is(uri)));
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
    
    /**
     * <ul>
     * <li>JSON format of the pipeline used:</li>
     * <pre>
     * [{
     *     $match: {
     *       group: '4622578'
     *      }
     *   }, {
     *       $project: {
     *       _id: '$group',
     *       persons: {
     *           $setUnion: [
     *               '$authors',
     *               '$editors',
     *               '$otherCreators.person'
     *           ]
     *       },
     *       citationKey: '$key'
     *       }
     *   }, {
     *       $unwind: {
     *           path: '$persons'
     *       }
     *   }, {
     *       $group: {
     *           _id: '$_id',
     *           persons: {
     *               $addToSet: {
     *                   name: '$persons.name',
     *                   firstName: '$persons.firstName',
     *                   lastName: '$persons.lastName',
     *                   uri: '$persons.uri',
     *                   citationKey: '$citationKey'
     *               }
     *           }
     *       }
     *   }, {
     *       $project: {
     *           _id: '$_id',
     *           persons: '$persons',
     *           totalResults: {
     *               $size: '$persons'
     *           }
     *       }
     *   }, {
     *       $unwind: {
     *           path: '$persons'
     *       }
     *   }, {
     *       $sort: {
     *           'persons.name': 1
     *       }
     *   }, {
     *       $group: {
     *           _id: '$_id',
     *           persons: {
     *               $push: '$persons'
     *           },
     *           totalResults: {
     *               $first: '$totalResults'
     *           }
     *       }
     *   }]</pre>
     *   
     *   <li>Other proposed pipeline:</li>
     *   
     *   <pre>[{$match: {
     *         "group": "2601560"
     *       }}, {$addFields: {
     *         "persons": {$setUnion: ["$authors", "$editors", "$otherCreators"]}
     *       }}, {$unwind: {
     *         path: "$persons"
     *       }}, {$addFields: {
     *         "ident": { 
     *           $cond: {
     *             if: {$ne: ["$persons.uri", ""]}, 
     *             then: "$persons.uri", 
     *             else: {$concat: ["$key","$persons.name"]}
     *           }
     *         }
     *       }
     *       }, {$group: {
     *         _id: "$ident",
     *         persons: {
     *           $push: "$persons"
     *         }
     *      }}]</pre>
     *</ul>
     * 
     * @author Pratik Giri
     *
     */
    @Override
    public Persons findAllPeople(String groupId, long start, int pageSize) {
        MatchOperation match = Aggregation.match(Criteria.where("group").is(groupId));

        ProjectionOperation project = Aggregation.project().and("group").as("_id").and("authors")
                .unionArrays("editors", "otherCreators.person").as("persons").and("key").as("citationKey");

        UnwindOperation unwind = Aggregation.unwind("persons");

        GroupOperation group = Aggregation.group("_id").addToSet(new BasicDBObject() {
            {
                put("name", "$persons.name");
                put("firstName", "$persons.firstName");
                put("lastName", "$persons.lastName");
                put("uri", "$persons.uri");
                put("citationKey", "$citationKey");
            }
        }).as("persons");

        ProjectionOperation projectResultCount = Aggregation.project().and("_id").as("_id").and("persons")
                .as("persons").and("persons").size().as("totalResults");
        
        UnwindOperation unwind1 = Aggregation.unwind("persons");

        SortOperation sort = Aggregation.sort(Direction.ASC, "persons.name");
        
        SkipOperation skip = Aggregation.skip(start);
        
        LimitOperation limit = Aggregation.limit(pageSize);

        GroupOperation groupAfterSort = Aggregation.group("_id").push("persons").as("persons")
                .first("totalResults").as("totalResults");

        AggregationResults<Persons> result = mongoTemplate.aggregate(
                Aggregation.newAggregation(match, project, unwind, group, projectResultCount, unwind1, sort, skip, limit, groupAfterSort),
                Citation.class, Persons.class);

        return result.getUniqueMappedResult();
    }

    @Override
    public Citations findCitationsByPersonUri(String uri) {

        ProjectionOperation project = Aggregation.project().and("authors")
                .unionArrays("editors", "otherCreators.person").as("persons").and(Aggregation.ROOT).as("citation");

        UnwindOperation unwind = Aggregation.unwind("persons");

        MatchOperation match = Aggregation.match(Criteria.where("persons.uri").is(uri));

        GroupOperation group = Aggregation.group("persons.uri").addToSet("citation").as("citations");

        AggregationResults<Citations> result = mongoTemplate
                .aggregate(Aggregation.newAggregation(project, unwind, match, group), Citation.class, Citations.class);

        return result.getUniqueMappedResult();
    }
    
    @Override
    public Citations findCitationsByPersonCitationKey(String citationKey) {

        MatchOperation match = Aggregation.match(Criteria.where("key").is(citationKey));

        GroupOperation group = Aggregation.group("id").addToSet(Aggregation.ROOT).as("citations");

        AggregationResults<Citations> result = mongoTemplate
                .aggregate(Aggregation.newAggregation(match, group), Citation.class, Citations.class);

        return result.getUniqueMappedResult();
    }
    
}
