package edu.asu.diging.citesphere.factory;

public interface ExtraData {

    public final static String CITESPHERE_PREFIX = "Citesphere:";
    
    public final static String CITESPHERE_PATTERN = "(?m)(?s)^" + CITESPHERE_PREFIX + " ?(\\{.*\\}).*?$";
}
