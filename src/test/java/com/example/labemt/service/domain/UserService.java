package com.example.labemt.service.domain;

import org.apache.catalina.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, String name, String surname);

    User login(String username, String password);

    User findByUsername(String username);
}
