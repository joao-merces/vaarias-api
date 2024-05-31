package br.com.vaariasweb.vaarias.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(name = "tb_order_item_book",
            joinColumns = @JoinColumn(name = "order_item_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private Double subTotal;

    public OrderItem() {
    }

    public OrderItem(Long id, Set<Book> books, Double subTotal) {
        this.id = id;
        this.books = books;
        this.subTotal = subTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public Double getSubTotalPrice() {
        Double sum = 0.0;
        for (Book book : books) {
            sum += book.getPrice();
        }
        return sum;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
