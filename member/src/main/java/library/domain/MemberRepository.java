package library.domain;

import library.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "members", path = "members")
public interface MemberRepository
    extends PagingAndSortingRepository<Member, Long> {}
