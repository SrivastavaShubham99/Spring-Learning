package guru.springframework.springlearning.repositories;

import guru.springframework.springlearning.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
}
