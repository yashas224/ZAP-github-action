package com.example.zaptrial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }


    @PostMapping
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@RequestBody Book book, @PathVariable(name = "id") int id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        Book updated = null;
        if (!bookOptional.isEmpty()) {
            updated = bookRepository.save(bookOptional.get());
            return ResponseEntity.ok(updated);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(name = "id") int id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        Book updated = null;
        if (!bookOptional.isEmpty()) {
            bookRepository.delete(bookOptional.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}
