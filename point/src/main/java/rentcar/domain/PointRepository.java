package rentcar.domain;

import rentcar.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel="points", path="points")
public interface PointRepository extends PagingAndSortingRepository<Point, >{
}