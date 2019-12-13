package edu.asu.diging.citesphere.data.bib;

import edu.asu.diging.citesphere.model.bib.ICitation;

public interface CustomCitationRepository {

    void detachCitation(ICitation citation);

    ICitation mergeCitation(ICitation citation);
}
