package edu.asu.diging.citesphere.model.bib.impl;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GilesPage implements IGilesPage {

    private int page;
    private IGilesFile image;
    private IGilesFile text;
    private IGilesFile ocr;
    private List<GilesFile> additionalFiles;
    
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesPage#getPage()
     */
    @Override
    public int getPage() {
        return page;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesPage#setPage(int)
     */
    @Override
    public void setPage(int page) {
        this.page = page;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesPage#getImage()
     */
    @Override
    public IGilesFile getImage() {
        return image;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesPage#setImage(edu.asu.diging.citesphere.model.bib.impl.GilesFile)
     */
    @Override
    public void setImage(IGilesFile image) {
        this.image = image;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesPage#getText()
     */
    @Override
    public IGilesFile getText() {
        return text;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesPage#setText(edu.asu.diging.citesphere.model.bib.impl.GilesFile)
     */
    @Override
    public void setText(IGilesFile text) {
        this.text = text;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesPage#getOcr()
     */
    @Override
    public IGilesFile getOcr() {
        return ocr;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesPage#setOcr(edu.asu.diging.citesphere.model.bib.impl.GilesFile)
     */
    @Override
    public void setOcr(IGilesFile ocr) {
        this.ocr = ocr;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesPage#getAdditionalFiles()
     */
    @Override
    public List<GilesFile> getAdditionalFiles() {
        return additionalFiles;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesPage#setAdditionalFiles(java.util.List)
     */
    @Override
    public void setAdditionalFiles(List<GilesFile> additionalFiles) {
        this.additionalFiles = additionalFiles;
    }
    
}
