package br.com.vaariasweb.vaarias.repositories;

import br.com.vaariasweb.vaarias.entities.Order;
import br.com.vaariasweb.vaarias.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
