package edu.asu.diging.citesphere.data.bib.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import edu.asu.diging.citesphere.data.bib.ICitationDao;
import edu.asu.diging.citesphere.model.bib.ICitation;
import edu.asu.diging.citesphere.model.bib.impl.Citation;

@Repository
public class CitationMongoDao implements ICitationDao {

    @Autowired
    private MongoTemplate mongoTemplate;
    
    @Override
    public List<? extends ICitation> findCitations(String groupId, long start, int pageSize) {
        Query query = new Query();
        query.addCriteria(Criteria.where("group").is(groupId));
        query.skip(start);
        query.limit(pageSize);
        return mongoTemplate.find(query, Citation.class);
    }
    
}
