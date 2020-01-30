package edu.asu.diging.citesphere.model.bib.impl;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.citesphere.model.bib.ICitation;
import edu.asu.diging.citesphere.model.bib.ICitationCollection;

@Entity
public class CollectionCitationMapping {

    @Id
    @GeneratedValue(generator = "collcitmap_id_generator")
    @GenericGenerator(name = "collcitmap_id_generator", parameters = @Parameter(name = "prefix", value = "CCM"), strategy = "edu.asu.diging.citesphere.core.repository.IdGenerator")
    private String id;
    
    @OneToOne(targetEntity=Citation.class)
    @JoinColumn(name="citation_id")
    private ICitation citation;
    
    @OneToOne(targetEntity=CitationCollection.class)
    @JoinColumn(name="coll_id")
    private ICitationCollection collection;
    
    private OffsetDateTime mappingDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ICitation getCitation() {
        return citation;
    }

    public void setCitation(ICitation citation) {
        this.citation = citation;
    }

    public ICitationCollection getCollection() {
        return collection;
    }

    public void setCollection(ICitationCollection collection) {
        this.collection = collection;
    }

    public OffsetDateTime getMappingDate() {
        return mappingDate;
    }

    public void setMappingDate(OffsetDateTime mappingDate) {
        this.mappingDate = mappingDate;
    }
    
}
