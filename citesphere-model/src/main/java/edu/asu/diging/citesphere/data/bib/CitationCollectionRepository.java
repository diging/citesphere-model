package edu.asu.diging.citesphere.data.bib;

import java.util.List;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.asu.diging.citesphere.model.bib.ICitationCollection;
import edu.asu.diging.citesphere.model.bib.ICitationGroup;
import edu.asu.diging.citesphere.model.bib.impl.CitationCollection;

@JaversSpringDataAuditable
public interface CitationCollectionRepository extends PagingAndSortingRepository<CitationCollection, String> {

    public ICitationCollection findByKeyAndGroup(String id, ICitationGroup group);
    
    public List<ICitationCollection> findByParentCollectionKeyAndGroup(String parentCollectionKey, ICitationGroup group);
}
