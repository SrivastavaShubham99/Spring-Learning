package guru.springframework.springlearning.repositories;

import guru.springframework.springlearning.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublishRepository extends CrudRepository<Publisher,Long> {
}
