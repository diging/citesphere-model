package edu.asu.diging.citesphere.data.bib;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.asu.diging.citesphere.model.bib.impl.CitationGroup;
import edu.asu.diging.citesphere.model.bib.impl.GroupCitationMapping;

public interface GroupCitationMappingRepository
        extends PagingAndSortingRepository<GroupCitationMapping, String> {

    List<GroupCitationMapping> findByGroup(CitationGroup group, Pageable pageable);
    
    long countByGroup(CitationGroup group);
    
    void deleteByGroup(CitationGroup group);
}
