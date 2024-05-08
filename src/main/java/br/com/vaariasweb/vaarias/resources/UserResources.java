package br.com.vaariasweb.vaarias.resources;

import br.com.vaariasweb.vaarias.entities.User;
import br.com.vaariasweb.vaarias.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserResources {
    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = repository.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<User>> getById(@PathVariable Long id) {
        Optional<User> user = repository.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
