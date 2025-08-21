package com.loandesk.controller;

import com.loandesk.domain.LoanProduct;
import com.loandesk.repository.LoanProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Products")
public class ProductController {

    private final LoanProductRepository repository;

    public ProductController(LoanProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @Operation(summary = "List products")
    public List<LoanProduct> list() {
        return repository.findAll();
    }

    @PostMapping
    @Operation(summary = "Create product")
    public ResponseEntity<LoanProduct> create(@RequestBody LoanProduct product) {
        return new ResponseEntity<>(repository.save(product), HttpStatus.CREATED);
    }
}
