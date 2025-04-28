package com.example.labemt.service.application;

import com.example.labemt.model.dto.CreateUserDto;
import com.example.labemt.model.dto.DisplayUserDto;
import com.example.labemt.model.dto.LoginResponseDto;
import com.example.labemt.model.dto.LoginUserDto;

import java.util.Optional;

public interface UserApplicationService {
    Optional<DisplayUserDto> register(CreateUserDto createUserDto);

    Optional<LoginResponseDto> login(LoginUserDto loginUserDto);

    Optional<DisplayUserDto> findByUsername(String username);

}
