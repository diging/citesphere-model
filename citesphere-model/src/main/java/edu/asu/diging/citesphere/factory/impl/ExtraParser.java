package edu.asu.diging.citesphere.factory.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.zotero.api.Data;
import org.springframework.social.zotero.api.Item;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.asu.diging.citesphere.factory.ExtraData;
import edu.asu.diging.citesphere.model.bib.ICitation;
import edu.asu.diging.citesphere.model.bib.ICitationConceptTag;
import edu.asu.diging.citesphere.model.bib.ICreator;
import edu.asu.diging.citesphere.model.bib.IPerson;
import edu.asu.diging.citesphere.model.bib.IReference;
import edu.asu.diging.citesphere.model.bib.impl.Affiliation;
import edu.asu.diging.citesphere.model.bib.impl.CitationConceptTag;
import edu.asu.diging.citesphere.model.bib.impl.GilesUpload;
import edu.asu.diging.citesphere.model.bib.impl.Person;
import edu.asu.diging.citesphere.model.bib.impl.Reference;

public class ExtraParser {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    private List<BiConsumer<JsonObject, ICitation>> processFunctions;
    
    public void init() {
        processFunctions = new ArrayList<BiConsumer<JsonObject, ICitation>>();
        processFunctions.add(this::processAuthors);
        processFunctions.add(this::processEditors);
        processFunctions.add(this::processConceptTags);
        processFunctions.add(this::processOtherCreators);
        processFunctions.add(this::processReferences);
        processFunctions.add(this::processGilesUploads);
        processFunctions.add(this::processHiddenItems);
    }
    
    public void parseMetaDataNote(ICitation citation, Item metaData) {
        Data data = metaData.getData();
        if (data.getNote() == null || data.getNote().trim().isEmpty()) {
            return;
        }
        
        citation.setMetaDataItemKey(metaData.getKey());
        citation.setMetaDataItemVersion(metaData.getVersion());
        
        String note = data.getNote().trim();
        // Zotero adds <p> tags for notes by default and hence the json element could be enclosed within this tags
        if (note.startsWith("<p>")) {
            note = note.replaceFirst("<p>", "");
        }
        if (note.endsWith("</p>")) {
            note = note.substring(0, note.length() - 4);
        }
        JsonParser parser = new JsonParser();
        JsonObject jObj = parser.parse(note).getAsJsonObject();

        for (BiConsumer<JsonObject, ICitation> processFunction : processFunctions) {
            processFunction.accept(jObj, citation);
        }
    }
    
    public void parseExtra(Data data, ICitation citation) {
        if (data.getExtra() == null) {
            return;
        }

        String extra = data.getExtra();
        String citespherePattern = ExtraData.CITESPHERE_PATTERN;
        Pattern pattern = Pattern.compile(citespherePattern);
        Matcher match = pattern.matcher(extra);
        if (match.find()) {
            String extraMatch = match.group(1);
            JsonParser parser = new JsonParser();
            JsonObject jObj = parser.parse(extraMatch).getAsJsonObject();

            for (BiConsumer<JsonObject, ICitation> processFunction : processFunctions) {
                processFunction.accept(jObj, citation);
            }
        }
    }

    private void processAuthors(JsonObject jObj, ICitation citation) {
        if (jObj.has("authors") && !jObj.get("authors").isJsonNull()) {
            JsonArray authors = jObj.get("authors").getAsJsonArray();
            mapPersonFields(authors, citation.getAuthors());
        }
    }

    private void processEditors(JsonObject jObj, ICitation citation) {
        if (jObj.has("editors") && !jObj.get("editors").isJsonNull()) {
            JsonArray editors = jObj.get("editors").getAsJsonArray();
            mapPersonFields(editors, citation.getEditors());
        }
    }

    private void processOtherCreators(JsonObject jObj, ICitation citation) {
        if (jObj.has("otherCreators") && !jObj.get("otherCreators").isJsonNull()) {
            JsonArray creators = jObj.get("otherCreators").getAsJsonArray();
            mapCreatorFields(creators, citation.getOtherCreators());
        }
    }

    private void processConceptTags(JsonObject jObj, ICitation citation) {
        citation.setConceptTags(new HashSet<>());
        if (jObj.has("conceptTags") && !jObj.get("conceptTags").isJsonNull()) {
            JsonArray conceptTags = jObj.get("conceptTags").getAsJsonArray();
            mapConceptTags(conceptTags, citation.getConceptTags());
        }
    }

    private void processReferences(JsonObject jObj, ICitation citation) {
        citation.setReferences(new HashSet<>());
        if (jObj.has("references") && !jObj.get("references").isJsonNull()) {
            JsonArray references = jObj.get("references").getAsJsonArray();
            references.forEach(ref -> createReference(citation, ref));
        }
    }
    
    private void processGilesUploads(JsonObject jObj, ICitation citation) {
        citation.setGilesUploads(new HashSet<>());
        if (jObj.has("gilesUploads") && !jObj.get("gilesUploads").isJsonNull()) {
            
            JsonArray uploads = jObj.get("gilesUploads").getAsJsonArray();
            
            ObjectMapper mapper = new ObjectMapper();
            Gson gson = new GsonBuilder().create();
            uploads.forEach(upload -> {
                try {
                GilesUpload u = mapper.readValue(gson.toJson(upload), GilesUpload.class);
                citation.getGilesUploads().add(u);
                } catch (IOException e) {
                    logger.error("Couldn't unmarshall upload.", e);
                }
            });
            
        }
    }
    
    private void processHiddenItems(JsonObject jObj, ICitation citation) {
        if(jObj.has("hidden") && !jObj.get("hidden").isJsonNull()) {
            citation.setHidden(jObj.get("hidden").getAsInt());
        }
    }

    private void createReference(ICitation citation, JsonElement ref) {
        IReference reference = new Reference();
        citation.getReferences().add(reference);
        
        reference.setAuthorString((ref.getAsJsonObject().get("authorString") != null
                && !ref.getAsJsonObject().get("authorString").isJsonNull())
                        ? ref.getAsJsonObject().get("authorString").getAsString()
                        : "");
        if (ref.getAsJsonObject().get("contributors") != null && !ref.getAsJsonObject().get("contributors").isJsonNull() && ref.getAsJsonObject().get("contributors").isJsonArray()) {
            JsonArray contributors = ref.getAsJsonObject().get("contributors").getAsJsonArray();
            Set<ICreator> refCreators = new HashSet<>();
            reference.setContributors(refCreators);
            contributors.forEach(c -> mapCreatorFields(contributors, refCreators));
        }
        reference.setTitle(getProperty(ref, "title"));
        reference.setEndPage(getProperty(ref, "endPage"));
        reference.setFirstPage(getProperty(ref, "firstPage"));
        reference.setIdentifier(getProperty(ref, "identifier"));
        reference.setIdentifierType(getProperty(ref, "identifierType"));
        reference.setReferenceString(getProperty(ref, "referenceString"));
        reference.setReferenceStringRaw(getProperty(ref, "referenceStringRaw"));
        reference.setSource(getProperty(ref, "source"));
        reference.setVolume(getProperty(ref, "volume"));
        reference.setYear(getProperty(ref, "year"));
        reference.setPublicationType(getProperty(ref, "publicationType"));
        reference.setCitationId(getProperty(ref, "citationId"));
        reference.setReferenceId(getProperty(ref, "referenceId"));
        reference.setReferenceLabel(getProperty(ref, "referenceLabel"));
    }
    
    private String getProperty(JsonElement ref, String propertyName) {
        return (ref.getAsJsonObject().get(propertyName) != null
                && !ref.getAsJsonObject().get(propertyName).isJsonNull())
                        ? ref.getAsJsonObject().get(propertyName).getAsString()
                        : "";
    }

    private void mapCreatorFields(JsonArray creatorList, Set<ICreator> citationCreatorList) {
        List<edu.asu.diging.citesphere.model.bib.impl.Creator> extraCreatorList = new ArrayList<>();
        List<String> personNames = new ArrayList<>();
        creatorList.forEach(a -> {
            ICreator creator = (ICreator) new edu.asu.diging.citesphere.model.bib.impl.Creator();
            creator.setRole((a.getAsJsonObject().get("role") != null && !a.getAsJsonObject().get("role").isJsonNull())
                    ? a.getAsJsonObject().get("role").getAsString()
                    : "");
            creator.setPerson(new Person());
            if (a.getAsJsonObject().get("person") != null && !a.getAsJsonObject().get("person").isJsonNull()) {
                mapPerson(a.getAsJsonObject().get("person"), creator.getPerson());
            }
            personNames.add(creator.getPerson().getFirstName() + creator.getPerson().getLastName());
            extraCreatorList.add((edu.asu.diging.citesphere.model.bib.impl.Creator) creator);
        });
        for (Iterator<ICreator> iterator = citationCreatorList.iterator(); iterator.hasNext();) {
            ICreator creator = iterator.next();
            if (personNames.contains(creator.getPerson().getFirstName() + creator.getPerson().getLastName())) {
                iterator.remove();
            }
        }
        extraCreatorList.forEach(a -> citationCreatorList.add(a));
    }

    private void mapPersonFields(JsonArray personList, Set<IPerson> citationPersonList) {
        List<Person> extraPersonList = new ArrayList<>();
        List<String> personNames = new ArrayList<>();
        personList.forEach(a -> {
            IPerson person = new Person();
            mapPerson(a, person);
            personNames.add(person.getFirstName() + person.getLastName());
            extraPersonList.add((Person) person);
        });

        for (Iterator<IPerson> iterator = citationPersonList.iterator(); iterator.hasNext();) {
            IPerson person = iterator.next();
            if (personNames.contains(person.getFirstName() + person.getLastName())) {
                iterator.remove();
            }
        }
        extraPersonList.forEach(a -> citationPersonList.add(a));
    }

    private void mapPerson(JsonElement a, IPerson person) {
        person.setName(getProperty(a, "name"));
        person.setFirstName(getProperty(a, "firstName"));
        person.setLastName(getProperty(a, "lastName"));
        person.setUri(getProperty(a, "uri"));
        person.setLocalAuthorityId(getProperty(a, "localAuthorityId"));
        person.setAffiliations(new HashSet<>());
        JsonElement affiliations = a.getAsJsonObject().get("affiliations");
        if (affiliations instanceof JsonArray) {
            affiliations.getAsJsonArray().forEach(af -> {
                Affiliation affiliation = new Affiliation();
                affiliation.setName(
                        af.getAsJsonObject().get("name") != null && !af.getAsJsonObject().get("name").isJsonNull()
                                ? af.getAsJsonObject().get("name").getAsString()
                                : "");
                affiliation
                        .setUri(af.getAsJsonObject().get("uri") != null && !af.getAsJsonObject().get("uri").isJsonNull()
                                ? af.getAsJsonObject().get("uri").getAsString()
                                : "");
                person.getAffiliations().add(affiliation);
            });
        }
    }

    private void mapConceptTags(JsonArray conceptArray, Set<ICitationConceptTag> conceptTags) {
        conceptArray.forEach(c -> {
            ICitationConceptTag tag = new CitationConceptTag();
            JsonObject conceptJsonObject = c.getAsJsonObject();
            tag.setConceptName(
                    conceptJsonObject.get("conceptName") != null && !conceptJsonObject.get("conceptName").isJsonNull()
                            ? conceptJsonObject.get("conceptName").getAsString()
                            : "");
            tag.setTypeName(conceptJsonObject.get("typeName") != null && !conceptJsonObject.get("typeName").isJsonNull()
                    ? conceptJsonObject.get("typeName").getAsString()
                    : "");

            tag.setConceptUri(
                    conceptJsonObject.get("conceptUri") != null && !conceptJsonObject.get("conceptUri").isJsonNull()
                            ? conceptJsonObject.get("conceptUri").getAsString()
                            : null);
            tag.setLocalConceptId(conceptJsonObject.get("localConceptId") != null
                    && !conceptJsonObject.get("localConceptId").isJsonNull()
                            ? conceptJsonObject.get("localConceptId").getAsString()
                            : null);

            tag.setTypeUri(conceptJsonObject.get("typeUri") != null && !conceptJsonObject.get("typeUri").isJsonNull()
                    ? conceptJsonObject.get("typeUri").getAsString()
                    : null);
            tag.setLocalConceptTypeId(conceptJsonObject.get("localConceptTypeId") != null
                    && !conceptJsonObject.get("localConceptTypeId").isJsonNull()
                            ? conceptJsonObject.get("localConceptTypeId").getAsString()
                            : null);

            conceptTags.add(tag);
        });

    }

}
