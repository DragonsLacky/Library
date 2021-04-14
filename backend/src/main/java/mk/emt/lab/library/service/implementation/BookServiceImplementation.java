package mk.emt.lab.library.service.implementation;

import mk.emt.lab.library.model.Author;
import mk.emt.lab.library.model.Book;
import mk.emt.lab.library.model.dto.BookDto;
import mk.emt.lab.library.model.enumeration.Category;
import mk.emt.lab.library.model.exception.AuthorNotFoundException;
import mk.emt.lab.library.model.exception.BookDoesNotHaveAvailableCopiesException;
import mk.emt.lab.library.model.exception.BookNotFoundException;
import mk.emt.lab.library.model.exception.CategoryNotFoundException;
import mk.emt.lab.library.repository.AuthorRepository;
import mk.emt.lab.library.repository.BookRepository;
import mk.emt.lab.library.service.BookService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImplementation implements BookService {
    
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    
    public BookServiceImplementation(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }
    
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    
    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }
    
    @Override
    @Transactional
    public Optional<Book> save(BookDto bookDto) throws AuthorNotFoundException, CategoryNotFoundException {
        Author author = authorRepository.findById(bookDto.getAuthor()).orElseThrow( () -> new AuthorNotFoundException(bookDto.getAuthor()));
        Category category = Category.valueOf(bookDto.getCategory());
//        if(category == null) throw new CategoryNotFoundException(bookDto.getCategory());
        Book book = new Book(bookDto.getName(), category, author, bookDto.getAvailableCopies());
        
        return  Optional.of(bookRepository.save(book));
    }
    
    @Override
    @Transactional
    public Optional<Book> edit(Long id, BookDto bookDto) throws BookNotFoundException, AuthorNotFoundException {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        book.setName(bookDto.getName());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        book.setCategory(Category.valueOf(bookDto.getCategory()));
        book.setAuthor(authorRepository.findById(bookDto.getAuthor()).orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor())));
        return Optional.of(bookRepository.save(book));
    }
    
    @Override
    public Optional<Book> markTaken(Long id) throws BookNotFoundException, BookDoesNotHaveAvailableCopiesException {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        if(book.getAvailableCopies() - 1 < 0) throw new BookDoesNotHaveAvailableCopiesException(id);
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        return Optional.of(bookRepository.save(book));
    }
    
    
    @Override
    public Optional<Boolean> delete(Long id) throws BookNotFoundException {
        bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        bookRepository.deleteById(id);
        return Optional.of(bookRepository.findById(id).isEmpty());
    }
    
    @Override
    public void refreshMaterializedView() {
    
    }
}
