package com.loandesk.controller;

import com.loandesk.domain.Customer;
import com.loandesk.repository.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerViewController {

    private final CustomerRepository repository;

    public CustomerViewController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("customers", repository.findAll());
        model.addAttribute("customer", new Customer());
        return "customers";
    }

    @PostMapping
    public String create(@ModelAttribute Customer customer) {
        repository.save(customer);
        return "redirect:/customers";
    }
}

