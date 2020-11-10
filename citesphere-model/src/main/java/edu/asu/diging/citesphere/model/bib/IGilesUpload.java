package edu.asu.diging.citesphere.model.bib;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import edu.asu.diging.citesphere.model.bib.impl.GilesFile;
import edu.asu.diging.citesphere.model.bib.impl.GilesPage;
import edu.asu.diging.citesphere.model.bib.impl.GilesUpload;
import edu.asu.diging.citesphere.model.bib.impl.IGilesFile;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = GilesUpload.class)
public interface IGilesUpload {

    String getProgressId();

    void setProgressId(String progressId);

    String getDocumentId();

    void setDocumentId(String documentId);

    String getUploadId();

    void setUploadId(String uploadId);

    String getUploadDate();

    void setUploadDate(String uploadDate);

    IGilesFile getUploadedFile();

    void setUploadedFile(IGilesFile uploadedFile);

    IGilesFile getExtractedText();

    void setExtractedText(IGilesFile extractedText);

    List<GilesFile> getAdditionaFiles();

    void setAdditionaFiles(List<GilesFile> additionaFiles);

    List<GilesPage> getPages();

    void setPages(List<GilesPage> pages);

}