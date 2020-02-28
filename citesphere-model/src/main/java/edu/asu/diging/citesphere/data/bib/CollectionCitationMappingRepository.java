package edu.asu.diging.citesphere.data.bib;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.asu.diging.citesphere.model.bib.impl.CitationCollection;
import edu.asu.diging.citesphere.model.bib.impl.CollectionCitationMapping;

public interface CollectionCitationMappingRepository
        extends PagingAndSortingRepository<CollectionCitationMapping, String> {

    List<CollectionCitationMapping> findByCollection(CitationCollection collection, Pageable pageable);

    long countByCollection(CitationCollection collection);
    
    void deleteByCollection(CitationCollection collection);
}
