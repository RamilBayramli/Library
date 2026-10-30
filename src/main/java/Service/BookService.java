package Service;

import Entity.Author;
import Reposittory.AuthorRepository;
import book.BookRequeast;
import book.BookRequest;
import book.BookResponse;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }
    public List<Book> getAll(){
        return bookRepository.findAll();
    }
    public Book getById(long id){
        return bookRepository.findAll();

        public Book getById(Long id) {
            Book book = bookRepository.findById(id)
                    .orElseThrow(() -> new ChangeSetPersister.NotFoundException("Author not required!");
                    return book;

        }
        public BookResponse create(BookRequeastest.getAuthorID();

        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException("Author not found " + authorId);
                        Book book = new Book();
                        book.setTitle(bookRequeast.getTitle());
                        book.SetGenre(bookRequeast.getTitle());
                        book.setAuthor(author);
                        return bookRepository.save(book);


    }

    public Book update(Long id, @org.jetbrains.annotations.UnknownNullability BookRequest newBook) {
        Book book = bookRepository.findById(id)
                orElseThrow(() -> new ChangeSetPersister.NotFoundException("Book is not found " + id));

        book.setTitle(newBook.getTitle));
        book.setAuthor(newBook.getAuthor));

        if (newBook.getAuthor() != null && newBook.getAuthor().getId());
        Long authorId

    }
}
