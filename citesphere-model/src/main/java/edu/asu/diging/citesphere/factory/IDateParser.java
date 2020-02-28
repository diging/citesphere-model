package edu.asu.diging.citesphere.factory;

import java.time.OffsetDateTime;

public interface IDateParser {

    OffsetDateTime parse(String dateString);

}