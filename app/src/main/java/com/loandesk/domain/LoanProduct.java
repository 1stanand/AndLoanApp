package com.loandesk.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LoanProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private double minAmount;
    private double maxAmount;
    private double interestRateAnnual;
    private int termMinMonths;
    private int termMaxMonths;
    private boolean active = true;
}
