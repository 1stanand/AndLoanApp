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

    @Transient
    public double getMonthlyPayment() {
        double annualRate = product.getInterestRateAnnual();
        double monthlyRate = annualRate / 12.0 / 100.0;
        if (monthlyRate == 0) {
            return amount / termMonths;
        }
        double factor = Math.pow(1 + monthlyRate, termMonths);
        return amount * (monthlyRate * factor) / (factor - 1);
    }
}
