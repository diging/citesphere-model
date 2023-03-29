package edu.asu.diging.citesphere.data;

import java.util.List;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.asu.diging.citesphere.model.authority.IAuthorityEntry;
import edu.asu.diging.citesphere.model.authority.impl.AuthorityEntry;

@JaversSpringDataAuditable
public interface AuthorityEntryRepository extends PagingAndSortingRepository<AuthorityEntry, String> {

    public List<IAuthorityEntry> findByUsernameOrderByName(String username);
    
    public List<IAuthorityEntry> findByUsernameOrGroupsInOrderByName(String username, List<Long> groupIds);
    
    public Page<IAuthorityEntry> findByUsernameOrGroupsInOrderByName(String username, List<Long> groupIds, Pageable pageable);
    
    public List<IAuthorityEntry> findByUsernameAndUriOrderByName(String username, String uri);
    
    public Page<IAuthorityEntry> findByUsernameAndUriOrderByName(String username, String uri, Pageable pageable);
    
    public List<IAuthorityEntry> findByGroupsOrderByName(long groupId);
    
    public Page<IAuthorityEntry> findByGroupsOrderByName(long groupId, Pageable pageable);
    
    public List<IAuthorityEntry> findByUsernameAndSourceOrderByName(String username, String source);
    
    public List<IAuthorityEntry> findByUsernameAndGroupsOrderByName(String username, Long groupId);
    
    public Page<IAuthorityEntry> findByUsernameAndGroupsOrderByName(String username, Long groupId, Pageable pageable);
}