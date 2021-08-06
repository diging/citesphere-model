package edu.asu.diging.citesphere.data.bib.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.javers.core.Javers;
import org.javers.core.metamodel.object.CdoSnapshot;
import org.javers.core.metamodel.object.SnapshotType;
import org.javers.repository.jql.QueryBuilder;
import org.javers.shadow.Shadow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.asu.diging.citesphere.data.bib.ICitationVersionsDao;
import edu.asu.diging.citesphere.model.bib.ICitation;
import edu.asu.diging.citesphere.model.bib.impl.CitationVersion;
import edu.asu.diging.citesphere.model.bib.impl.Citation;

@Repository
public class CitationVersionDao implements ICitationVersionsDao {

    @Autowired
    private Javers javers;

    @Override
    public List<CitationVersion> getVersions(String groupId, String key) {
        QueryBuilder jqlQuery = QueryBuilder.byInstanceId(key, Citation.class);
        List<CdoSnapshot> versions = javers.findSnapshots(jqlQuery.build());
        List<CitationVersion> itemVersions = versions.stream()
                .filter(snapshot -> snapshot.getType() != SnapshotType.TERMINAL
                        && groupId.equals((String) snapshot.getPropertyValue("group")))
                .map(snapshot -> toBaseCitationVersion(snapshot, key)).collect(Collectors.toList());
        return itemVersions;
    }

    @Override
    public ICitation getVersion(String key, long version) {
        QueryBuilder jqlQuery = QueryBuilder.byInstanceId(key, Citation.class).withVersion(version);
        List<Shadow<ICitation>> shadows = javers.findShadows(jqlQuery.build());
        if (shadows.isEmpty()) {
            return null;
        } else {
            return shadows.get(0).get();
        }
    }

    private CitationVersion toBaseCitationVersion(CdoSnapshot itemSnapshot, String key) {
        CitationVersion version = new CitationVersion();
        version.setVersion(itemSnapshot.getVersion());
        version.setKey(key);
        version.setUpdatedDate(itemSnapshot.getCommitMetadata().getCommitDate().toString());
        return version;
    }

}
