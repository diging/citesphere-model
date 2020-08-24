//package edu.asu.diging.citesphere.data.bib;
//
//import java.util.List;
//
//import org.bson.types.ObjectId;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.mongodb.repository.MongoRepository;
//
//import edu.asu.diging.citesphere.model.bib.ICitationCollection;
//import edu.asu.diging.citesphere.model.bib.impl.CollectionCitationMapping;
//
//public interface CollectionCitationMappingRepository
//        extends MongoRepository<CollectionCitationMapping, ObjectId> {
//
//    List<CollectionCitationMapping> findByCollection(ICitationCollection collection, Pageable pageable);
//
//    long countByCollection(ICitationCollection collection);
//    
//    void deleteByCollection(ICitationCollection collection);
//}
