package br.com.vaariasweb.vaarias.repositories;

import br.com.vaariasweb.vaarias.entities.Order;
import br.com.vaariasweb.vaarias.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
