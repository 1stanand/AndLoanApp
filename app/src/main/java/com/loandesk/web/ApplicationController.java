package com.loandesk.web;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.loandesk.repo.ApplicationRepository;

@Controller
public class ApplicationController {

    private final ApplicationRepository applicationRepository;

    public ApplicationController(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @GetMapping("/applications/mine")
    public String myApplications(HttpSession session, Model model) {
        AuthUser auth = (AuthUser) session.getAttribute("authUser");
        if (auth == null) {
            return "redirect:/login";
        }
        model.addAttribute("apps", applicationRepository.findByCreatedById(auth.getId()));
        return "applications";
    }
}
