package com.example.labemt.service.domain;

import com.example.labemt.model.domain.User;
import com.example.labemt.model.enumerations.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> listAll();

    User register(String username, String password, String repeatPassword, String name, String surname, Role role);

    User login(String username, String password);

    User findByUsername(String username);
}
