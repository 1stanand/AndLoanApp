package com.loandesk.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentScheduleEntry {
    private int installment;
    private double payment;
    private double principal;
    private double interest;
    private double balance;
}
