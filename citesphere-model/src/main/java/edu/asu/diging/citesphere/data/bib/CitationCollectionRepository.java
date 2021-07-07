package edu.asu.diging.citesphere.data.bib;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.mongodb.repository.MongoRepository;

import edu.asu.diging.citesphere.model.bib.ICitationCollection;
import edu.asu.diging.citesphere.model.bib.impl.CitationCollection;

@JaversSpringDataAuditable
public interface CitationCollectionRepository extends MongoRepository<CitationCollection, ObjectId> {

    public Optional<ICitationCollection> findByKey(String key);
    
    public ICitationCollection findByKeyAndGroupId(String id, String groupId);
    
    public List<ICitationCollection> findByGroupId(String groupId);
    
    void deleteByGroupId(String groupId);

}
