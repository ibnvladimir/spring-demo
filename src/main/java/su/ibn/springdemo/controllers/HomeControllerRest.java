package su.ibn.springdemo.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import su.ibn.springdemo.model.Book;
import su.ibn.springdemo.repository.BookRepository;

@RestController
@RequestMapping(value={"/api"}, produces = "application/json")
public class HomeControllerRest {

    private BookRepository bookRepository;

    public HomeControllerRest(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.isPresent() ? new ResponseEntity<>(bookOptional.get(), HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    public Book postBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id")Long id) {
        try {
            bookRepository.deleteById(id);
            return "deleted successfully";
        } catch (Exception e) {
            return "can not delete not existing book";
        }
    }

    @PutMapping("/{id}")
    public Book putBook(@PathVariable("id")Long id, @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PatchMapping(consumes = "application/json")
    public ResponseEntity<Book> patchBook(@RequestBody Book newBookData) {
        Book book;
        try {
            book = bookRepository.findById(newBookData.getId()).get();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        if (newBookData.getAuthor() != null) {book.setAuthor(newBookData.getAuthor());}
        if (newBookData.getName() != null) {book.setName(newBookData.getName());}
        bookRepository.save(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

}
