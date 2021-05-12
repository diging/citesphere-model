package edu.asu.diging.citesphere.model.bib.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GilesFile implements IGilesFile {
    
    private String id;
    private String filename;
    private String url;
    private String contentType;
    private long size;
    private String processor;
    
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesFile#getId()
     */
    @Override
    public String getId() {
        return id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesFile#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesFile#getFilename()
     */
    @Override
    public String getFilename() {
        return filename;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesFile#setFilename(java.lang.String)
     */
    @Override
    public void setFilename(String filename) {
        this.filename = filename;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesFile#getUrl()
     */
    @Override
    public String getUrl() {
        return url;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesFile#setUrl(java.lang.String)
     */
    @Override
    public void setUrl(String url) {
        this.url = url;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesFile#getContentType()
     */
    @Override
    public String getContentType() {
        return contentType;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesFile#setContentType(java.lang.String)
     */
    @Override
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesFile#getSize()
     */
    @Override
    public long getSize() {
        return size;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesFile#setSize(long)
     */
    @Override
    public void setSize(long size) {
        this.size = size;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesFile#getProcessor()
     */
    @Override
    public String getProcessor() {
        return processor;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesFile#setProcessor(java.lang.String)
     */
    @Override
    public void setProcessor(String processor) {
        this.processor = processor;
    }
    
    
}
