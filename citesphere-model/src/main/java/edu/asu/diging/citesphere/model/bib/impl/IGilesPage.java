package edu.asu.diging.citesphere.model.bib.impl;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = GilesPage.class)
public interface IGilesPage {

    int getPage();

    void setPage(int page);

    IGilesFile getImage();

    void setImage(IGilesFile image);

    IGilesFile getText();

    void setText(IGilesFile text);

    IGilesFile getOcr();

    void setOcr(IGilesFile ocr);

    List<GilesFile> getAdditionalFiles();

    void setAdditionalFiles(List<GilesFile> additionalFiles);

}