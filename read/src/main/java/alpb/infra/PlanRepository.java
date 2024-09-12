package alpb.infra;

import alpb.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "plans", path = "plans")
public interface PlanRepository
    extends PagingAndSortingRepository<Plan, Long> {}
