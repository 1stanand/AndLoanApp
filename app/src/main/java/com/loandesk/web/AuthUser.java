package com.loandesk.web;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthUser implements Serializable {
    private Long id;
    private String username;
    private String role;
    private String name;
}
