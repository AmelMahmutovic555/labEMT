package com.example.labemt.web;

import com.example.labemt.model.domain.User;
import com.example.labemt.model.dto.CreateUserDto;
import com.example.labemt.model.dto.DisplayUserDto;
import com.example.labemt.model.dto.LoginResponseDto;
import com.example.labemt.model.dto.LoginUserDto;
import com.example.labemt.model.exceptions.InvalidArgumentsException;
import com.example.labemt.model.exceptions.InvalidUserCredentialsException;
import com.example.labemt.model.exceptions.PasswordsDoNotMatchException;
import com.example.labemt.service.application.UserApplicationService;
import com.example.labemt.service.domain.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserApplicationService userApplicationService;
    private final UserService userService;

    public UserController(UserApplicationService userApplicationService, UserService userService) {
        this.userApplicationService = userApplicationService;
        this.userService = userService;
    }

    @Operation(summary = "List all users", description = "Lists all users")
    @GetMapping
    public List<User> findAll(){
        return userService.listAll();
    }

    @Operation(summary = "Register a new user", description = "Creates a new user account")
    @ApiResponses(
            value = {@ApiResponse(
                    responseCode = "200",
                    description = "User registered successfully"
            ), @ApiResponse(
                    responseCode = "400", description = "Invalid input or passwords do not match"
            )}
    )
    @PostMapping("/register")
    public ResponseEntity<DisplayUserDto> register(@RequestBody CreateUserDto createUserDto) {
        try {
            return userApplicationService.register(createUserDto)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (InvalidArgumentsException | PasswordsDoNotMatchException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "User login", description = "Authenticates a user and generates a JWT")
    @ApiResponses(
            value = {@ApiResponse(
                    responseCode = "200",
                    description = "User authenticated successfully"
            ), @ApiResponse(responseCode = "404", description = "Invalid username or password")}
    )
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginUserDto loginUserDto) {
        try {
            return userApplicationService.login(loginUserDto)
                    .map(ResponseEntity::ok)
                    .orElseThrow(InvalidUserCredentialsException::new);
        } catch (InvalidUserCredentialsException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
