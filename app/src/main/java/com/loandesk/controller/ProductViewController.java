package com.loandesk.controller;

import com.loandesk.domain.LoanProduct;
import com.loandesk.repository.LoanProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductViewController {

    private final LoanProductRepository repository;

    public ProductViewController(LoanProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", repository.findAll());
        model.addAttribute("product", new LoanProduct());
        return "products";
    }

    @PostMapping
    public String create(@ModelAttribute LoanProduct product) {
        repository.save(product);
        return "redirect:/products";
    }
}

