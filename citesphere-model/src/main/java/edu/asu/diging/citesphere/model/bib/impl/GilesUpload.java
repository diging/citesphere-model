package edu.asu.diging.citesphere.model.bib.impl;

import java.util.List;

import edu.asu.diging.citesphere.model.bib.IGilesUpload;

public class GilesUpload implements IGilesUpload {

    private String progressId;
    private String documentId;
    private String uploadId;
    private String uploadDate;
    private IGilesFile uploadedFile;
    private IGilesFile extractedText;
    private List<GilesFile> additionaFiles;
    private List<GilesPage> pages;
    
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesUpload#getProgressId()
     */
    @Override
    public String getProgressId() {
        return progressId;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesUpload#setProgressId(java.lang.String)
     */
    @Override
    public void setProgressId(String progressId) {
        this.progressId = progressId;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesUpload#getDocumentId()
     */
    @Override
    public String getDocumentId() {
        return documentId;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesUpload#setDocumentId(java.lang.String)
     */
    @Override
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesUpload#getUploadId()
     */
    @Override
    public String getUploadId() {
        return uploadId;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesUpload#setUploadId(java.lang.String)
     */
    @Override
    public void setUploadId(String uploadId) {
        this.uploadId = uploadId;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesUpload#getUploadDate()
     */
    @Override
    public String getUploadDate() {
        return uploadDate;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesUpload#setUploadDate(java.lang.String)
     */
    @Override
    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesUpload#getUploadedFile()
     */
    @Override
    public IGilesFile getUploadedFile() {
        return uploadedFile;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesUpload#setUploadedFile(edu.asu.diging.citesphere.model.bib.impl.GilesFile)
     */
    @Override
    public void setUploadedFile(IGilesFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesUpload#getExtractedText()
     */
    @Override
    public IGilesFile getExtractedText() {
        return extractedText;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesUpload#setExtractedText(edu.asu.diging.citesphere.model.bib.impl.GilesFile)
     */
    @Override
    public void setExtractedText(IGilesFile extractedText) {
        this.extractedText = extractedText;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesUpload#getAdditionaFiles()
     */
    @Override
    public List<GilesFile> getAdditionaFiles() {
        return additionaFiles;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesUpload#setAdditionaFiles(java.util.List)
     */
    @Override
    public void setAdditionaFiles(List<GilesFile> additionaFiles) {
        this.additionaFiles = additionaFiles;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesUpload#getPages()
     */
    @Override
    public List<GilesPage> getPages() {
        return pages;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesUpload#setPages(java.util.List)
     */
    @Override
    public void setPages(List<GilesPage> pages) {
        this.pages = pages;
    }
}
