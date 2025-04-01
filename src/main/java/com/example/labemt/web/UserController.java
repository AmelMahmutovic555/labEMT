//package com.example.labemt.web;
//
//import com.example.labemt.model.dto.CreateUserDto;
//import com.example.labemt.model.dto.DisplayUserDto;
//import com.example.labemt.model.dto.LoginUserDto;
//import com.example.labemt.service.application.UserApplicationService;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.management.InvalidApplicationException;
//import javax.management.InvalidAttributeValueException;
//
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//    private final UserApplicationService userApplicationService;
//
//    public UserController(UserApplicationService userApplicationService) {
//        this.userApplicationService = userApplicationService;
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<DisplayUserDto> register(@RequestBody CreateUserDto createUserDto){
//        return userApplicationService.register(createUserDto).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<DisplayUserDto> login(HttpServletRequest request){
//        try{
//            DisplayUserDto displayUserDto = userApplicationService.login(new LoginUserDto(request.getParameter("username"), request.getParameter("password"))).orElse(null);
//            request.getSession().setAttribute("user", displayUserDto.toUser());
//            return ResponseEntity.ok(displayUserDto);
//        } catch (RuntimeException runtimeException) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
