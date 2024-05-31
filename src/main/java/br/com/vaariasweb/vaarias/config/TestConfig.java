package br.com.vaariasweb.vaarias.config;

import br.com.vaariasweb.vaarias.entities.Book;
import br.com.vaariasweb.vaarias.entities.Order;
import br.com.vaariasweb.vaarias.entities.OrderItem;
import br.com.vaariasweb.vaarias.entities.enums.PaymentMethod;
import br.com.vaariasweb.vaarias.entities.User;
import br.com.vaariasweb.vaarias.repositories.BookRepository;
import br.com.vaariasweb.vaarias.repositories.OrderItemRepository;
import br.com.vaariasweb.vaarias.repositories.OrderRepository;
import br.com.vaariasweb.vaarias.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria", "Brown", "maria@gmail.com", "123456", "962587413");
        User u2 = new User(null, "Alex", "Green", "alex@gmail.com", "123456","962587414");
        User u3 = new User(null, "Benio", "Beniar", "benio@gmail.com", "benio","962587414");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Book b1 = new Book(null, "Psicose", "Robert Bloch", 59.00, "http://localhost:8080/psicose.jpg");
        Book b2 = new Book(null, "O Iluminado", "Stephen King", 59.00, "http://localhost:8080/o_iluminado.jpg");
        Book b3 = new Book(null, "It - A Coisa", "Stephen King", 59.00, "http://localhost:8080/it_a_coisa.jpg");
        Book b4 = new Book(null, "O Exorcista", "William Peter Blatty", 59.00, "http://localhost:8080/o_exorcista.jpg");
        Book b5 = new Book(null, "Psicose", "Robert Bloch", 59.00, "http://localhost:8080/psicose.jpg");
        Book b6 = new Book(null, "O Iluminado", "Stephen King", 59.00, "http://localhost:8080/o_iluminado.jpg");
        Book b7 = new Book(null, "It - A Coisa", "Stephen King", 59.00, "http://localhost:8080/it_a_coisa.jpg");
        Book b8 = new Book(null, "O Exorcista", "William Peter Blatty", 59.00, "http://localhost:8080/o_exorcista.jpg");
        Book b9 = new Book(null, "Psicose", "Robert Bloch", 59.00, "http://localhost:8080/psicose.jpg");
        Book b10 = new Book(null, "O Iluminado", "Stephen King", 59.00, "http://localhost:8080/o_iluminado.jpg");
        Book b11 = new Book(null, "It - A Coisa", "Stephen King", 59.00, "http://localhost:8080/it_a_coisa.jpg");
        Book b12 = new Book(null, "O Exorcista", "William Peter Blatty", 59.00, "http://localhost:8080/o_exorcista.jpg");
        Book b13 = new Book(null, "Psicose", "Robert Bloch", 59.00, "http://localhost:8080/psicose.jpg");
        Book b14 = new Book(null, "O Iluminado", "Stephen King", 59.00, "http://localhost:8080/o_iluminado.jpg");
        Book b15 = new Book(null, "It - A Coisa", "Stephen King", 59.00, "http://localhost:8080/it_a_coisa.jpg");
        Book b16 = new Book(null, "O Exorcista", "William Peter Blatty", 59.00, "http://localhost:8080/o_exorcista.jpg");
        Book b17 = new Book(null, "Psicose", "Robert Bloch", 59.00, "http://localhost:8080/psicose.jpg");
        Book b18 = new Book(null, "O Iluminado", "Stephen King", 59.00, "http://localhost:8080/o_iluminado.jpg");
        Book b19 = new Book(null, "It - A Coisa", "Stephen King", 59.00, "http://localhost:8080/it_a_coisa.jpg");
        Book b20 = new Book(null, "O Exorcista", "William Peter Blatty", 59.00, "http://localhost:8080/o_exorcista.jpg");

        bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b15, b16, b17, b18, b19, b20));

        OrderItem oi1 = new OrderItem(null, new HashSet<>(Arrays.asList(b1,b3,b2)), b1.getPrice());
        OrderItem oi2 = new OrderItem(null, new HashSet<>(Arrays.asList(b2)), b2.getPrice());
        OrderItem oi3 = new OrderItem(null, new HashSet<>(Arrays.asList(b2,b1)), b2.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, PaymentMethod.CREDIT_CARD, new HashSet<>(Arrays.asList(oi1)));
        Order o2 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, PaymentMethod.PIX, new HashSet<>(Arrays.asList(oi2)));
        Order o3 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u2, PaymentMethod.CREDIT_CARD, new HashSet<>(Arrays.asList(oi3)));


        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

    }
}
