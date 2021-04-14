package mk.emt.lab.library.service;

import mk.emt.lab.library.model.Book;
import mk.emt.lab.library.model.dto.BookDto;
import mk.emt.lab.library.model.exception.AuthorNotFoundException;
import mk.emt.lab.library.model.exception.BookDoesNotHaveAvailableCopiesException;
import mk.emt.lab.library.model.exception.BookNotFoundException;
import mk.emt.lab.library.model.exception.CategoryNotFoundException;

import java.util.List;
import java.util.Optional;


public interface BookService {
    
    List<Book> findAll();
    
    Optional<Book> findById(Long id);
    
    Optional<Book> save(BookDto bookDto) throws AuthorNotFoundException, CategoryNotFoundException;
    
    Optional<Book> edit(Long id, BookDto bookDto) throws BookNotFoundException, AuthorNotFoundException;
    
    Optional<Book> markTaken(Long id) throws BookNotFoundException, BookDoesNotHaveAvailableCopiesException;
    
    Optional<Boolean> delete(Long id) throws BookNotFoundException;
    
    void refreshMaterializedView();
}
