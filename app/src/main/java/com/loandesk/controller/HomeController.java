package com.loandesk.controller;

import com.loandesk.model.Role;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Authentication auth) {
        if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_" + Role.CHECKER.name()))) {
            return "checker/home";
        }
        return "maker/home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
