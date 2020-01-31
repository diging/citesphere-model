package edu.asu.diging.citesphere.model.bib.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.citesphere.model.bib.ICitation;
import edu.asu.diging.citesphere.model.bib.ICitationGroup;

@Entity
public class GroupCitationMapping {

    @Id
    @GeneratedValue(generator = "groupcitmap_id_generator")
    @GenericGenerator(name = "groupcitmap_id_generator", parameters = @Parameter(name = "prefix", value = "GCM"), strategy = "edu.asu.diging.citesphere.data.bib.IdGenerator")
    private String id;
    
    @OneToOne(targetEntity=Citation.class)
    @JoinColumn(name="citation_id")
    private ICitation citation;
    
    @OneToOne(targetEntity=CitationGroup.class)
    @JoinColumn(name="group_id")
    private ICitationGroup group;

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

    public ICitationGroup getGroup() {
        return group;
    }

    public void setGroup(ICitationGroup group) {
        this.group = group;
    }
    
}
