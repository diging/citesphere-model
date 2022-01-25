package edu.asu.diging.citesphere.factory;

import org.springframework.social.zotero.api.Item;

import edu.asu.diging.citesphere.model.bib.ICitation;

public interface ICitationFactory {

    ICitation createCitation(Item item, Item metaData);

}