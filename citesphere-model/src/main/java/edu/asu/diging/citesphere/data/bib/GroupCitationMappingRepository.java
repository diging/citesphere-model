//package edu.asu.diging.citesphere.data.bib;
//
//import java.util.List;
//
//import org.bson.types.ObjectId;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.mongodb.repository.MongoRepository;
//
//import edu.asu.diging.citesphere.model.bib.ICitationGroup;
//import edu.asu.diging.citesphere.model.bib.impl.GroupCitationMapping;
//
//public interface GroupCitationMappingRepository
//        extends MongoRepository<GroupCitationMapping, ObjectId> {
//
//    List<GroupCitationMapping> findByGroup(ICitationGroup group, Pageable pageable);
//    
//    long countByGroupId(String groupId);
//    
//    void deleteByGroupId(String groupId);
//}
