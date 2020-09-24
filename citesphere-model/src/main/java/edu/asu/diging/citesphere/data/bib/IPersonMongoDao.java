package edu.asu.diging.citesphere.data.bib;

import edu.asu.diging.citesphere.model.transfer.impl.Persons;

public interface IPersonMongoDao {

    Persons findPersonsByGroupAndUri(String groupId, String uri);

}