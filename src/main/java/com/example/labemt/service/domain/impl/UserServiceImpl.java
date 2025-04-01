//package com.example.labemt.service.domain.impl;
//
//import com.example.labemt.model.domain.User;
//import com.example.labemt.repository.UserRepository;
//import com.example.labemt.service.domain.UserService;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServiceImpl implements UserService {
//    private final UserRepository userRepository;
//
//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public User register(String username, String password, String repeatPassword, String name, String surname) {
//        if (username == null || username.isEmpty() || password == null || password.isEmpty())
//            return null;
//        if (!password.equals(repeatPassword))
//            return null;
////        if (userRepository.findByUsername(username).isPresent())
////            throw new UsernameAlreadyExistsException(username);
//        User user = new User(username, password, name, surname);
//        return userRepository.save(user);
//
//    }
//
//    @Override
//    public User login(String username, String password) {
//        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
//            return null;
//        }
//        return userRepository.findByUsernameAndPassword(username, password).orElse(null);
//    }
//
//    @Override
//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
//                username));
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
//                username));
//    }
//}
