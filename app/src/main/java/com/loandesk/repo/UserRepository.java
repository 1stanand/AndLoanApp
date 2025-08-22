package com.loandesk.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loandesk.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndActiveTrue(String username);
}
