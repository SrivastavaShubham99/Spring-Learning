package guru.springframework.springlearning.services;

import guru.springframework.springlearning.domain.Book;
import guru.springframework.springlearning.repositories.BookRepository;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;


    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
