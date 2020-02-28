package edu.asu.diging.citesphere.factory;

import org.springframework.social.zotero.api.Group;

import edu.asu.diging.citesphere.model.bib.ICitationGroup;

public interface IGroupFactory {

    ICitationGroup createGroup(Group group);

}