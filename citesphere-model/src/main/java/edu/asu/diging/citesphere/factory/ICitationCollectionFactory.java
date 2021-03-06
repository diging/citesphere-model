package edu.asu.diging.citesphere.factory;

import org.springframework.social.zotero.api.Collection;

import edu.asu.diging.citesphere.model.bib.ICitationCollection;

public interface ICitationCollectionFactory {

    ICitationCollection createCitationCollection(Collection collection);

}