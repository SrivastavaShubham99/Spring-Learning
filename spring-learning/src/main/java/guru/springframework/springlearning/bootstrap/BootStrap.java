package guru.springframework.springlearning.bootstrap;


import guru.springframework.springlearning.domain.Author;
import guru.springframework.springlearning.domain.Book;
import guru.springframework.springlearning.domain.Publisher;
import guru.springframework.springlearning.repositories.AuthorRepository;
import guru.springframework.springlearning.repositories.BookRepository;
import guru.springframework.springlearning.repositories.PublishRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    private PublishRepository publishRepository;


    public BootStrap(BookRepository bookRepository, AuthorRepository authorRepository,PublishRepository publishRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publishRepository=publishRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        /*
        Created the Author entity
         */
        Author author=new Author();
        author.setFirstName("Shubham");
        author.setLastName("Srivastava");


        // save the author to the H2 database.
        Author savedAuthor1=authorRepository.save(author);

        /*
        Created the Book entity
         */
        Book book1=new Book();
        book1.setTitle("Code with Shubham");
        book1.setIsbn("ISBN242342424");

        // saved the book entity to the H2 database
        Book savedBook1=bookRepository.save(book1);


        // setting up the association
        savedAuthor1.getBooks().add(savedBook1);

        Publisher publisher=new Publisher();
        publisher.setAddress("Noida 42");
        publisher.setCity("Noida");
        publisher.setState("UP");

        publishRepository.save(publisher);



        System.out.println("In Bootstrap we have the following");
        System.out.println("Author's count : " + authorRepository.count());
        System.out.println("Books' count : " + bookRepository.count());
        


    }
}
