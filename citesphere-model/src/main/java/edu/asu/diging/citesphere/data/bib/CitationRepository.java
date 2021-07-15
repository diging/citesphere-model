package edu.asu.diging.citesphere.data.bib;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.mongodb.repository.MongoRepository;

import edu.asu.diging.citesphere.model.bib.ICitation;
import edu.asu.diging.citesphere.model.bib.ICitationGroup;
import edu.asu.diging.citesphere.model.bib.impl.Citation;

@JaversSpringDataAuditable
public interface CitationRepository extends MongoRepository<Citation, ObjectId> {

    List<ICitation> findByGroupAndAuthorsUri(ICitationGroup group, String uri);
    
    Optional<ICitation> findByKey(String key);
    
    List<ICitation> findByParentItemAndItemTypeAndDeleted(String parentItem, String itemType, int deleted);
    
    void deleteByGroup(String group);

    List<ICitation> findByGilesUploadsDocumentId(String id);
}
