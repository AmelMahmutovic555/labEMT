package com.example.labemt.model.dto;

import com.example.labemt.model.domain.User;
import com.example.labemt.model.enumerations.Role;

public record CreateUserDto(
        String username,
        String password,
        String repeatPassword,
        String name,
        String surname,
        Role role
) {

    public User toUser() {
        return new User(username, password, name, surname, role);
    }
}
