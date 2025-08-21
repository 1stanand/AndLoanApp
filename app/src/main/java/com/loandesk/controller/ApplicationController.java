package com.loandesk.controller;

import com.loandesk.domain.LoanApplication;
import com.loandesk.repository.LoanApplicationRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/applications")
@Tag(name = "Applications")
public class ApplicationController {

    private final LoanApplicationRepository repository;

    public ApplicationController(LoanApplicationRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Operation(summary = "Create application in DRAFT")
    public ResponseEntity<LoanApplication> create(@RequestBody LoanApplication app) {
        app.setStatus("DRAFT");
        return new ResponseEntity<>(repository.save(app), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get application by id")
    public ResponseEntity<LoanApplication> get(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "List applications")
    public List<LoanApplication> list() {
        return repository.findAll();
    }

    @PatchMapping("/{id}/status")
    @Operation(summary = "Update application status")
    public ResponseEntity<LoanApplication> updateStatus(@PathVariable Long id, @RequestBody LoanApplication payload) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setStatus(payload.getStatus());
                    return ResponseEntity.ok(repository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
