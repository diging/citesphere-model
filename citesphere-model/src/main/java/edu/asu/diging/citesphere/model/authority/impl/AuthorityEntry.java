package edu.asu.diging.citesphere.model.authority.impl;

import java.time.OffsetDateTime;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import edu.asu.diging.citesphere.model.authority.IAuthorityEntry;

@Entity
public class AuthorityEntry implements IAuthorityEntry {

    @Id
    @GeneratedValue(generator = "authority_id_generator")
    @GenericGenerator(name = "authority_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "AU"), 
                    strategy = "edu.asu.diging.citesphere.data.bib.IdGenerator"
            )
    private String id;
    @Lob
    private String name;
    @Lob
    private String description;
    private String uri;
    private String importerId;
    private String username;
    private String source;
    private OffsetDateTime createdOn;
    
    @ElementCollection
    private Set<Long> groups;
    
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.authority.impl.IAuthorityEntry#getId()
     */
    @Override
    public String getId() {
        return id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.authority.impl.IAuthorityEntry#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.authority.impl.IAuthorityEntry#getName()
     */
    @Override
    public String getName() {
        return name;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.authority.impl.IAuthorityEntry#setName(java.lang.String)
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.authority.impl.IAuthorityEntry#getUri()
     */
    @Override
    public String getUri() {
        return uri;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.authority.impl.IAuthorityEntry#setUri(java.lang.String)
     */
    @Override
    public void setUri(String uri) {
        this.uri = uri;
    }
    @Override
    public String getImporterId() {
        return importerId;
    }
    @Override
    public void setImporterId(String importerId) {
        this.importerId = importerId;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public void setUsername(String username) {
        this.username = username;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.authority.impl.IAuthorityEntry#getSource()
     */
    @Override
    public String getSource() {
        return source;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.authority.impl.IAuthorityEntry#setSource(java.lang.String)
     */
    @Override
    public void setSource(String source) {
        this.source = source;
    }
    @Override
    public OffsetDateTime getCreatedOn() {
        return createdOn;
    }
    @Override
    public void setCreatedOn(OffsetDateTime createdOn) {
        this.createdOn = createdOn;
    }
    @Override
    public Set<Long> getGroups() {
        return groups;
    }
    @Override
    public void setGroups(Set<Long> groups) {
        this.groups = groups;
    }
}
