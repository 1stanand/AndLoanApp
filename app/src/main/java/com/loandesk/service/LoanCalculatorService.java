package com.loandesk.service;

import com.loandesk.service.dto.PaymentScheduleEntry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanCalculatorService {

    public double calculateMonthlyPayment(double principal, double annualRate, int termMonths) {
        double monthlyRate = annualRate / 12.0 / 100.0;
        if (monthlyRate == 0) {
            return principal / termMonths;
        }
        double factor = Math.pow(1 + monthlyRate, termMonths);
        return principal * (monthlyRate * factor) / (factor - 1);
    }

    public List<PaymentScheduleEntry> generateSchedule(double principal, double annualRate, int termMonths) {
        double monthlyPayment = calculateMonthlyPayment(principal, annualRate, termMonths);
        double monthlyRate = annualRate / 12.0 / 100.0;
        double balance = principal;
        List<PaymentScheduleEntry> schedule = new ArrayList<>();
        for (int i = 1; i <= termMonths; i++) {
            double interest = balance * monthlyRate;
            double principalPaid = monthlyPayment - interest;
            balance -= principalPaid;
            schedule.add(new PaymentScheduleEntry(i,
                    round(monthlyPayment),
                    round(principalPaid),
                    round(interest),
                    round(Math.max(balance, 0))));
        }
        return schedule;
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}

