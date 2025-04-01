//package com.example.labemt.service.application.impl;
//
//import com.example.labemt.model.domain.User;
//import com.example.labemt.model.dto.CreateUserDto;
//import com.example.labemt.model.dto.DisplayUserDto;
//import com.example.labemt.model.dto.LoginUserDto;
//import com.example.labemt.service.application.UserApplicationService;
//import com.example.labemt.service.domain.UserService;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserApplicationServiceImpl implements UserApplicationService {
//    private final UserService userService;
//
//    public UserApplicationServiceImpl(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public Optional<DisplayUserDto> register(CreateUserDto createUserDto) {
//        User user = userService.register(
//                createUserDto.username(),
//                createUserDto.password(),
//                createUserDto.repeatPassword(),
//                createUserDto.name(),
//                createUserDto.surname()
//        );
//        return Optional.of(DisplayUserDto.from(user));
//    }
//
//
//    @Override
//    public Optional<DisplayUserDto> login(LoginUserDto loginUserDto) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<DisplayUserDto> findByUsername(String username) {
//        return Optional.empty();
//    }
//}
