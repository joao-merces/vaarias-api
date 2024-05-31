package br.com.vaariasweb.vaarias.resources;

import br.com.vaariasweb.vaarias.entities.OrderItem;
import br.com.vaariasweb.vaarias.repositories.OrderItemRepository;
import br.com.vaariasweb.vaarias.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/orders_itens")
public class OrderItemResources {
    @Autowired
    private OrderItemRepository repository;

    @GetMapping
    public ResponseEntity<List<OrderItem>> getAll() {
        List<OrderItem> orderItems = repository.findAll();
        return ResponseEntity.ok().body(orderItems);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<OrderItem>> getById(@PathVariable Long id) {
        Optional<OrderItem> order = repository.findById(id);
        return ResponseEntity.ok().body(order);
    }
}
