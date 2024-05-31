package br.com.vaariasweb.vaarias.repositories;

import br.com.vaariasweb.vaarias.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

public interface BookRepository extends JpaRepository<Book, Long> {
}
