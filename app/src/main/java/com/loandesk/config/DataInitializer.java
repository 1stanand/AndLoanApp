package com.loandesk.config;

import com.loandesk.domain.LoanProduct;
import com.loandesk.repository.LoanProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initProducts(LoanProductRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new LoanProduct(null, "EDU", "Education Loan", 50000, 500000, 8.5, 12, 60, true));
                repo.save(new LoanProduct(null, "AUTO", "Auto Loan", 100000, 1000000, 9.5, 12, 84, true));
                repo.save(new LoanProduct(null, "PERSONAL", "Personal Loan", 20000, 200000, 12.0, 6, 36, true));
            }
        };
    }
}
