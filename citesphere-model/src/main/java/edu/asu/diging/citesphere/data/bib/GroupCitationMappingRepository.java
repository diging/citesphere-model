package edu.asu.diging.citesphere.data.bib;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.asu.diging.citesphere.model.bib.impl.CitationGroup;
import edu.asu.diging.citesphere.model.bib.impl.GroupCitationMapping;

public interface GroupCitationMappingRepository
        extends PagingAndSortingRepository<GroupCitationMapping, String> {

    void deleteByGroup(CitationGroup group);
}
