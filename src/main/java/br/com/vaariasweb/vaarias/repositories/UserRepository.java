package br.com.vaariasweb.vaarias.repositories;

import br.com.vaariasweb.vaarias.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
