package edu.icet.ecom.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "menu_items")
@Data
public class MenuItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    @ManyToOne
    private CatergoryEntity category;
    private Integer stockQuantity;
    private LocalDate expirationDate;
    private boolean isActive;
}

