package edu.asu.diging.citesphere.data.bib;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import edu.asu.diging.citesphere.model.bib.ICitationGroup;
import edu.asu.diging.citesphere.model.bib.impl.CitationGroup;

public interface CitationGroupRepository extends MongoRepository<CitationGroup, ObjectId> {

    Optional<ICitationGroup> findFirstByGroupId(long groupId);
    
    void deleteByGroupId(int groupId);

    List<ICitationGroup> findByGroupId(long groupId);
}
