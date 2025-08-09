package com.example.bookapi.controller;

import com.example.bookapi.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private Map<Integer, Book> bookRepo = new HashMap<>();
    private int idCounter = 1;

    @PostMapping
    public String addBook(@RequestBody Book book) {
        book.setId(idCounter++);
        bookRepo.put(book.getId(), book);
        return "Book added with ID: " + book.getId();
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookRepo.values());
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id) {
        return bookRepo.get(id);
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        Book existing = bookRepo.get(id);
        if (existing == null) {
            return "Book not found";
        }
        updatedBook.setId(id);
        bookRepo.put(id, updatedBook);
        return "Book updated";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        if (bookRepo.containsKey(id)) {
            bookRepo.remove(id);
            return "Book deleted";
        }
        return "Book not found";
    }
}

