package com.loandesk.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String code;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "min_amount", nullable = false)
    private java.math.BigDecimal minAmount;

    @Column(name = "max_amount", nullable = false)
    private java.math.BigDecimal maxAmount;

    @Column(name = "rate_annual", nullable = false)
    private java.math.BigDecimal rateAnnual;

    @Column(name = "term_min", nullable = false)
    private Integer termMin;

    @Column(name = "term_max", nullable = false)
    private Integer termMax;

    private boolean active = true;
}
