package guru.springframework.springlearning.repositories;

import guru.springframework.springlearning.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
