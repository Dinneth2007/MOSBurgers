package edu.icet.ecom.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Data
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private Double subtotal;
    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference //Serialization, Reccurence Issue (Could have been solved using DTOs)

    private OrderEntity order;
    @ManyToOne
    private MenuItemEntity menuItem;
}
