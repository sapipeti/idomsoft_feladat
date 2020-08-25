package hu.fics.interview.repository;

import hu.fics.interview.model.OfficialEmployee;
import hu.fics.interview.projection.EmployeeProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "employees", path = "employee", excerptProjection = EmployeeProjection.class)
public interface OfficialEmployeeRepository extends PagingAndSortingRepository<OfficialEmployee, Long> {
}
