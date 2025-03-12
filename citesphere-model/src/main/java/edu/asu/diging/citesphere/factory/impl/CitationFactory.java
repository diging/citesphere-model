package edu.asu.diging.citesphere.factory.impl;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.zotero.api.Creator;
import org.springframework.social.zotero.api.Data;
import org.springframework.social.zotero.api.Item;
import org.springframework.stereotype.Component;

import edu.asu.diging.citesphere.factory.ICitationFactory;
import edu.asu.diging.citesphere.factory.IDateParser;
import edu.asu.diging.citesphere.factory.ZoteroConstants;
import edu.asu.diging.citesphere.model.bib.ICitation;
import edu.asu.diging.citesphere.model.bib.ICreator;
import edu.asu.diging.citesphere.model.bib.IPerson;
import edu.asu.diging.citesphere.model.bib.ItemType;
import edu.asu.diging.citesphere.model.bib.impl.Citation;
import edu.asu.diging.citesphere.model.bib.impl.Person;

@Component
public class CitationFactory implements ICitationFactory {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IDateParser dateParser;
    
    private ParseExtra parseExtra;
    
    @PostConstruct
    public void init() {
        parseExtra = new ParseExtra();
        parseExtra.init();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * edu.asu.diging.citesphere.core.factory.impl.ICitationFactory#createCitation(
     * org.springframework.social.zotero.api.Item)
     */
    @Override
    public ICitation createCitation(Item item, Item metaData) {
        Data data = item.getData();
        ICitation citation = new Citation();
        citation.setGroup(item.getLibrary().getId() + "");
        citation.setIssue(data.getIssue());
        citation.setItemType(ItemType.getByZoteroKey(data.getItemType()));
        citation.setKey(item.getKey());
        citation.setPages(data.getPages());
        citation.setPublicationTitle(data.getPublicationTitle());
        citation.setSeries(data.getSeries());
        citation.setSeriesTitle(data.getSeriesTitle());
        citation.setTitle(data.getTitle());
        citation.setParentItem(data.getParentItem());
        citation.setVolume(data.getVolume());
        citation.setVersion(data.getVersion());
        citation.setDeleted(data.getDeleted());
        citation.setParentItem(data.getParentItem());
        citation.setTags(data.getTags());
        citation.setNote(data.getNote());

        Set<IPerson> authors = new TreeSet<>();
        Set<IPerson> editors = new TreeSet<>();
        Set<ICreator> creators = new TreeSet<>();
        if (data.getCreators() != null) {
            int authorPos = 0;
            int editorPos = 0;
            int creatorPos = 0;
            for (Creator c : data.getCreators()) {
                if (c.getCreatorType().equals(ZoteroConstants.CREATOR_TYPE_AUTHOR)) {
                    authors.add(createPerson(c, authorPos));
                    authorPos++;
                } else if (c.getCreatorType().equals(ZoteroConstants.CREATOR_TYPE_EDITOR)) {
                    editors.add(createPerson(c, editorPos));
                    editorPos++;
                } else {
                    creators.add(createCreator(c, creatorPos));
                    creatorPos++;
                }
            }
        }
        citation.setAuthors(authors);
        citation.setEditors(editors);
        citation.setOtherCreators(creators);
        citation.setDateFreetext(item.getData().getDate());
        if (item.getData().getDate() != null) {
            OffsetDateTime date = dateParser.parse(item.getData().getDate());
            if (date != null) {
                citation.setDate(date.toString());
            }
        }
        citation.setUrl(item.getData().getUrl());

        citation.setAbstractNote(item.getData().getAbstractNote());
        citation.setAccessDate(item.getData().getAccessDate());
        citation.setArchive(item.getData().getArchive());
        citation.setArchiveLocation(item.getData().getArchiveLocation());
        citation.setCallNumber(item.getData().getCallNumber());
        citation.setDoi(item.getData().getDoi());
        citation.setIssn(item.getData().getIssn());
        citation.setJournalAbbreviation(item.getData().getJournalAbbreviation());
        citation.setLanguage(item.getData().getLanguage());
        citation.setLibraryCatalog(item.getData().getLibraryCatalog());
        citation.setRights(item.getData().getRights());
        citation.setSeriesText(item.getData().getSeriesText());
        citation.setShortTitle(item.getData().getShortTitle());
        citation.setCollections(item.getData().getCollections());

        citation.setDateAdded(item.getData().getDateAdded());

        if (metaData != null) {
            parseExtra.parseMetaDataNote(citation, metaData);
        } else {
            parseExtra.parseExtra(data, citation);
        }
        
        return citation;
    }
    
    private IPerson createPerson(Creator creator, int index) {
        IPerson person = new Person();
        person.setFirstName(creator.getFirstName());
        person.setLastName(creator.getLastName());
        person.setName(String.join(" ", creator.getFirstName(), creator.getLastName()));
        person.setPositionInList(index);
        return person;
    }

    private ICreator createCreator(Creator zcreator, int index) {
        ICreator creator = new edu.asu.diging.citesphere.model.bib.impl.Creator();
        creator.setPerson(createPerson(zcreator, index));
        creator.setRole(zcreator.getCreatorType());
        return creator;
    }

    
}