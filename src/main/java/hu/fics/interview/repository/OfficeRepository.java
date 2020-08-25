package hu.fics.interview.repository;

import hu.fics.interview.model.Office;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "offices", path = "office")
public interface OfficeRepository extends PagingAndSortingRepository<Office, Long> {
}
