package com.github.briannbig.caching;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Optional<Book> getBookById(long id) {
        System.out.println("......getBookById, " + id);
        var book = repository.findById(id);
        System.out.println(".......Book: " + book);
        return book;
    }

    public List<Book> getAllBooks() {
        System.out.println("........getAllBooks");
        return repository.findAll();
    }

    public List<Book> getBooksByAuthor(String author) {
        System.out.println(".........getBooksByAuthor, " + author);
        return repository.findByAuthor(author);
    }

    public Optional<Book> addBook(Book book) {
        System.out.println("..........addBook, "+ book);
        return Optional.of(repository.save(book));
    }

}
