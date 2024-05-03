package br.com.vaariasweb.vaarias.config;

import br.com.vaariasweb.vaarias.entities.Book;
import br.com.vaariasweb.vaarias.entities.Order;
import br.com.vaariasweb.vaarias.entities.enums.PaymentMethod;
import br.com.vaariasweb.vaarias.entities.User;
import br.com.vaariasweb.vaarias.repositories.BookRepository;
import br.com.vaariasweb.vaarias.repositories.OrderRepository;
import br.com.vaariasweb.vaarias.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria", "Brown", "maria@gmail.com", "123456");
        User u2 = new User(null, "Alex", "Green", "alex@gmail.com", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Book b1 = new Book(null, "Psicose", "Robert Bloch", 59.00, "../../../../vaarias/src/main/resources/Covers/psicose.jpg");
        Book b2 = new Book(null, "O Iluminado", "Stephen King", 59.00, "../../../../vaarias/src/main/resources/Covers/o_iluminado.jpg");
        Book b3 = new Book(null, "It - A Coisa", "Stephen King", 59.00, "../../../../vaarias/src/main/resources/Covers/it_a_coisa.jpg");
        Book b4 = new Book(null, "O Exorcista", "William Peter Blatty", 59.00, "../../../../vaarias/src/main/resources/Covers/o_exorcista.jpg");

        bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4));


        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, PaymentMethod.CREDIT_CARD);
        Order o2 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, PaymentMethod.PIX);
        Order o3 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u2, PaymentMethod.CREDIT_CARD);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

    }
}
