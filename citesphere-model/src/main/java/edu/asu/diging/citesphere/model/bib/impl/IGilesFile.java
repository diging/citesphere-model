package edu.asu.diging.citesphere.model.bib.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = GilesFile.class)
public interface IGilesFile {

    String getId();

    void setId(String id);

    String getFilename();

    void setFilename(String filename);

    String getUrl();

    void setUrl(String url);

    String getContentType();

    void setContentType(String contentType);

    long getSize();

    void setSize(long size);

    String getProcessor();

    void setProcessor(String processor);

}