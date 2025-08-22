package com.loandesk.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.loandesk.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByCreatedById(Long userId);
}
