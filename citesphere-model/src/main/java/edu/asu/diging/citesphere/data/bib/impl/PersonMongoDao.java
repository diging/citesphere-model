package edu.asu.diging.citesphere.data.bib.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;

import edu.asu.diging.citesphere.data.bib.IPersonMongoDao;
import edu.asu.diging.citesphere.model.bib.impl.Citation;
import edu.asu.diging.citesphere.model.transfer.impl.Persons;

@Repository
public class PersonMongoDao implements IPersonMongoDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /*
     * (non-Javadoc)
     * 
     * @see edu.asu.diging.citesphere.data.bib.impl.IAuthorsMongoDao#
     * findPersonsByGroupAndUri(java.lang.String, java.lang.String)
     */
    @Override
    public Persons findPersonsByGroupAndUri(String groupId, String uri) {
        UnwindOperation unwind = Aggregation.unwind("authors");
        MatchOperation match = Aggregation.match(Criteria.where("group").is(groupId).and("authors.uri").is(uri));
        GroupOperation group = Aggregation.group("authors.uri")
                .push(new BasicDBObject("name", "$authors.name").append("uri", "$authors.uri")
                        .append("firstName", "$authors.firstName").append("lastName", "$authors.lastName")
                        .append("localAuthorityId", "$authors.localAuthorityId"))
                .as("persons");

        AggregationResults<Persons> result = mongoTemplate.aggregate(Aggregation.newAggregation(unwind, match, group),
                Citation.class, Persons.class);
        return result.getUniqueMappedResult();
    }
}
