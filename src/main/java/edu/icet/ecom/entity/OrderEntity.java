package edu.icet.ecom.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.icet.ecom.util.OrderStatus;
import edu.icet.ecom.util.PaymentMethod;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "orders")
@Data
@DynamicUpdate
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderDate;
    private Double totalAmount;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @ManyToOne
    private CustomerEntity customer;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderItemEntity> orderItems;
}
