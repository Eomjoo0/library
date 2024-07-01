package library.infra;

import java.util.List;
import library.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "mypages", path = "mypages")
public interface MypageRepository
    extends PagingAndSortingRepository<Mypage, Long> {
    void deleteByBookId(Integer bookId);
}
