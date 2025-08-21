package com.loandesk.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LoanApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String applicationNo;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private LoanProduct product;

    private double amount;
    private int termMonths;
    private String status;
    private LocalDateTime createdAt = LocalDateTime.now();
}
