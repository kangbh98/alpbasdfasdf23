package alpb.domain;

import alpb.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "diaries", path = "diaries")
public interface DiaryRepository
    extends PagingAndSortingRepository<Diary, Long> {}
