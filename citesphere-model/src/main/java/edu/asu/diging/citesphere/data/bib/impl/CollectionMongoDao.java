package edu.asu.diging.citesphere.data.bib.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import edu.asu.diging.citesphere.data.bib.ICollectionMongoDao;
import edu.asu.diging.citesphere.model.bib.ICitationCollection;
import edu.asu.diging.citesphere.model.bib.impl.CitationCollection;

@Repository
public class CollectionMongoDao implements ICollectionMongoDao {

    @Autowired
    private MongoTemplate mongoTemplate;
    
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.data.bib.impl.ICollectionMongoDao#findByGroupIdAndParentKey(java.lang.String, java.lang.String)
     */
    @Override
    public List<? extends ICitationCollection> findByGroupIdAndParentKey(String groupId, String parentKey) {
        Query query = new Query();
        query = query.addCriteria(Criteria.where("groupId").is(groupId));
        if (parentKey != null) {
            query = query.addCriteria(Criteria.where("parentCollectionKey").is(parentKey));
        } else {
            query = query.addCriteria(Criteria.where("parentCollectionKey").exists(false));
        }
       
        return mongoTemplate.find(query, CitationCollection.class);
    }
}
