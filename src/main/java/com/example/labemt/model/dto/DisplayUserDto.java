//package com.example.labemt.model.dto;
//
//
//import com.example.labemt.model.domain.User;
//
//public record DisplayUserDto(String username, String name, String surname) {
//
//    public static DisplayUserDto from(User user) {
//        return new DisplayUserDto(
//                user.getUsername(),
//                user.getName(),
//                user.getSurname()
//        );
//    }
//
//    public User toUser() {
//        return new User(name, surname, username);
//    }
//}
