package edu.asu.diging.citesphere.data.bib.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import edu.asu.diging.citesphere.data.bib.CustomCitationRepository;
import edu.asu.diging.citesphere.model.bib.ICitation;

@Repository
public class CustomCitationRepositoryImpl implements CustomCitationRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void detachCitation(ICitation citation) {
        entityManager.detach(citation);
    }
    
    @Override
    public ICitation mergeCitation(ICitation citation) {
        return entityManager.merge(citation);
    }

}
