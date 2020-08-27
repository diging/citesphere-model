package edu.asu.diging.citesphere.data.bib;

import java.util.List;

import edu.asu.diging.citesphere.model.bib.ICitationCollection;

public interface ICollectionMongoDao {

    List<? extends ICitationCollection> findByGroupIdAndParentKey(String groupId, String parentKey);

}