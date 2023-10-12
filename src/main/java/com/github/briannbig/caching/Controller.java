package com.github.briannbig.caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class Controller {

    private final BookService service;

    @Autowired
    public Controller(BookService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.of(Optional.ofNullable(service.getAllBooks()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id) {
        return ResponseEntity.of(service.getBookById(id));
    }

    @GetMapping("author/{author}")
    public ResponseEntity<List<Book>> getBooksByAuthor(String author) {
        return ResponseEntity.ofNullable(service.getBooksByAuthor(author));
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.of(service.addBook(book));
    }


}
