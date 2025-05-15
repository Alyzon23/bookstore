package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        Optional<Book> book = bookService.getBookById(id);
        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book newBook) {
        Book savedBook = bookService.addBook(newBook);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book updatedBook) {
        Optional<Book> updated = bookService.updateBook(id, updatedBook);
        return updated.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Book> partialUpdateBook(@PathVariable("id") Long id, @RequestBody Book partialBook) {
        Optional<Book> existingBookOptional = bookService.getBookById(id);
        if (existingBookOptional.isPresent()) {
            Book existingBook = existingBookOptional.get();
            if (partialBook.getTitle() != null) existingBook.setTitle(partialBook.getTitle());
            if (partialBook.getGenre() != null) existingBook.setGenre(partialBook.getGenre());
            if (partialBook.getDescription() != null) existingBook.setDescription(partialBook.getDescription());
            if (partialBook.getAuthor() != null) existingBook.setAuthor(partialBook.getAuthor());
            if (partialBook.getPublicationYear() != null) existingBook.setPublicationYear(partialBook.getPublicationYear());
            return new ResponseEntity<>(bookService.addBook(existingBook), HttpStatus.OK); // Usamos addBook para guardar los cambios
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}