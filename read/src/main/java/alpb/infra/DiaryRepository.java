package alpb.infra;

import alpb.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "diaries", path = "diaries")
public interface DiaryRepository
    extends PagingAndSortingRepository<Diary, Long> {}
