package mk.emt.lab.library.web.controller;

import mk.emt.lab.library.model.Book;
import mk.emt.lab.library.model.dto.BookDto;
import mk.emt.lab.library.model.exception.AuthorNotFoundException;
import mk.emt.lab.library.model.exception.BookDoesNotHaveAvailableCopiesException;
import mk.emt.lab.library.model.exception.BookNotFoundException;
import mk.emt.lab.library.model.exception.CategoryNotFoundException;
import mk.emt.lab.library.repository.BookRepository;
import mk.emt.lab.library.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value={"","/api/books"})
public class BookController {
    
    private final BookService bookService;
    
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping
    public List<Book> list(){
        return bookService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Book> singleBook(@PathVariable Long id){
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    
    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody BookDto bookDto) throws AuthorNotFoundException, CategoryNotFoundException {
        return this.bookService.save(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    
    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody BookDto bookDto) throws AuthorNotFoundException, BookNotFoundException {
        return this.bookService.edit(id, bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    
    @PutMapping("/mark/{id}")
    public ResponseEntity markBook(@PathVariable Long id) throws BookNotFoundException, BookDoesNotHaveAvailableCopiesException {
        return bookService.markTaken(id)
                .map((book) -> ResponseEntity.ok().build())
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id) throws BookNotFoundException {
        return this.bookService.delete(id).filter(value -> value).map(value -> ResponseEntity.ok().build()).orElseGet(() -> ResponseEntity.badRequest().build());
    }
    
}
