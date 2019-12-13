package edu.asu.diging.citesphere.data.bib;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.asu.diging.citesphere.model.bib.impl.CitationGroup;

@JaversSpringDataAuditable
public interface CitationGroupRepository extends PagingAndSortingRepository<CitationGroup, Long> {

    
}
