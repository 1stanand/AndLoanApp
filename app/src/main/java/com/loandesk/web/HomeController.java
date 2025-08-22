package com.loandesk.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/applications/mine", "/review-queue"})
    public String dashboard() {
        return "dashboard";
    }
}
