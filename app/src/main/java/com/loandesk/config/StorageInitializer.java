package com.loandesk.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class StorageInitializer implements ApplicationRunner {

    @Value("${loandesk.storage-root:./data/kyc}")
    private String storageRoot;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Path root = Path.of(storageRoot);
        Files.createDirectories(root);
    }
}
