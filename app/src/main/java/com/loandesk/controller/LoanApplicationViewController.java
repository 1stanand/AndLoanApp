package com.loandesk.controller;

import com.loandesk.domain.LoanApplication;
import com.loandesk.domain.Customer;
import com.loandesk.domain.LoanProduct;
import com.loandesk.repository.CustomerRepository;
import com.loandesk.repository.LoanApplicationRepository;
import com.loandesk.repository.LoanProductRepository;
import com.loandesk.service.LoanCalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/applications")
public class LoanApplicationViewController {

    private final LoanApplicationRepository applicationRepository;
    private final CustomerRepository customerRepository;
    private final LoanProductRepository productRepository;
    private final LoanCalculatorService calculator;

    public LoanApplicationViewController(LoanApplicationRepository applicationRepository,
                                         CustomerRepository customerRepository,
                                         LoanProductRepository productRepository,
                                         LoanCalculatorService calculator) {
        this.applicationRepository = applicationRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.calculator = calculator;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("applications", applicationRepository.findAll());
        model.addAttribute("customers", customerRepository.findAll());
        model.addAttribute("products", productRepository.findAll());
        return "applications";
    }

    @PostMapping
    public String create(@RequestParam Long customerId,
                         @RequestParam Long productId,
                         @RequestParam double amount,
                         @RequestParam int termMonths) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        LoanProduct product = productRepository.findById(productId).orElseThrow();
        LoanApplication app = new LoanApplication();
        app.setCustomer(customer);
        app.setProduct(product);
        app.setAmount(amount);
        app.setTermMonths(termMonths);
        app.setStatus("DRAFT");
        applicationRepository.save(app);
        return "redirect:/applications";
    }

    @GetMapping("/{id}/schedule")
    public String schedule(@PathVariable Long id, Model model) {
        LoanApplication app = applicationRepository.findById(id).orElseThrow();
        model.addAttribute("app", app);
        model.addAttribute("schedule", calculator.generateSchedule(
                app.getAmount(),
                app.getProduct().getInterestRateAnnual(),
                app.getTermMonths()));
        return "schedule";
    }

    @PostMapping("/{id}/approve")
    public String approve(@PathVariable Long id) {
        applicationRepository.findById(id).ifPresent(app -> {
            app.setStatus("APPROVED");
            applicationRepository.save(app);
        });
        return "redirect:/applications";
    }

    @PostMapping("/{id}/reject")
    public String reject(@PathVariable Long id) {
        applicationRepository.findById(id).ifPresent(app -> {
            app.setStatus("REJECTED");
            applicationRepository.save(app);
        });
        return "redirect:/applications";
    }
}

