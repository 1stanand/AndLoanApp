package com.loandesk.web;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.loandesk.repo.UserRepository;

@Controller
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        return userRepository.findByUsernameAndActiveTrue(username)
                .filter(u -> u.getPassword().equals(password))
                .map(u -> {
                    session.setAttribute("authUser", new AuthUser(u.getId(), u.getUsername(), u.getRole(), u.getName()));
                    if ("CHECKER".equalsIgnoreCase(u.getRole())) {
                        return "redirect:/review-queue";
                    }
                    return "redirect:/applications/mine";
                })
                .orElseGet(() -> {
                    model.addAttribute("error", "Invalid credentials");
                    return "login";
                });
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login?logout";
    }
}
