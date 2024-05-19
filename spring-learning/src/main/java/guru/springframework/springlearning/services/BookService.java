package guru.springframework.springlearning.services;

import guru.springframework.springlearning.domain.Book;

public interface BookService {

    public Iterable<Book> findAll();
}
