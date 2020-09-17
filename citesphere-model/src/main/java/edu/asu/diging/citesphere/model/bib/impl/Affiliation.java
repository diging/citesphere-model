package edu.asu.diging.citesphere.model.bib.impl;

import edu.asu.diging.citesphere.model.bib.IAffiliation;

public class Affiliation implements IAffiliation {

    private String name;
    private String uri;
    private String localAuthorityId;
     
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.IAffiliation#getName()
     */
    @Override
    public String getName() {
        return name;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.IAffiliation#setName(java.lang.String)
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.IAffiliation#getUri()
     */
    @Override
    public String getUri() {
        return uri;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.core.model.bib.impl.IAffiliation#setUri(java.lang.String)
     */
    @Override
    public void setUri(String uri) {
        this.uri = uri;
    }
    @Override
    public String getLocalAuthorityId() {
        return localAuthorityId;
    }
    @Override
    public void setLocalAuthorityId(String localAuthorityId) {
        this.localAuthorityId = localAuthorityId;
    }
}
