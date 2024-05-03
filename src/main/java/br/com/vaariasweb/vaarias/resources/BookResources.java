package br.com.vaariasweb.vaarias.resources;

import br.com.vaariasweb.vaarias.entities.Book;
import br.com.vaariasweb.vaarias.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/books")
@CrossOrigin(origins = "http://localhost:3000")
public class BookResources {
    @Autowired
    private BookRepository repository;

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        List<Book> books = repository.findAll();
        return ResponseEntity.ok().body(books);
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<Optional<Book>> getById(@PathVariable Long id) {
        Optional<Book> book = repository.findById(id);
        return ResponseEntity.ok().body(book);
    }
}
