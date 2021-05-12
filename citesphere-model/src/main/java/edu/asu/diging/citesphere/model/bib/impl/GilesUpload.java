package edu.asu.diging.citesphere.model.bib.impl;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import edu.asu.diging.citesphere.model.bib.GilesStatus;
import edu.asu.diging.citesphere.model.bib.IGilesUpload;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GilesUpload implements IGilesUpload {

    private String progressId;
    private String documentId;
    private String uploadId;
    private String uploadedDate;
    private IGilesFile uploadedFile;
    private IGilesFile extractedText;
    private List<GilesFile> additionaFiles;
    private List<GilesPage> pages;
    private GilesStatus documentStatus;
    private String uploadingUser;
    
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
    public String getUploadedDate() {
        return uploadedDate;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.citesphere.model.bib.impl.IGilesUpload#setUploadDate(java.lang.String)
     */
    @Override
    public void setUploadedDate(String uploadDate) {
        this.uploadedDate = uploadDate;
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
    @Override
    public GilesStatus getDocumentStatus() {
        return documentStatus;
    }
    @Override
    public void setDocumentStatus(GilesStatus status) {
        this.documentStatus = status;
    }
    @Override
    public String getUploadingUser() {
        return uploadingUser;
    }
    @Override
    public void setUploadingUser(String uploadingUser) {
        this.uploadingUser = uploadingUser;
    }
}
