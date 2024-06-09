package com.user_management_systems.controller;

import com.user_management_systems.dto.User;
import com.user_management_systems.model.SignInRequest;
import com.user_management_systems.model.UserResponse;
import com.user_management_systems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Boolean> createUser(@RequestBody User user){
//        User createdUser = userService.saveUser(user);
//        UserResponse userResponse = new UserResponse();
//        userResponse.setId(createdUser.getId());
//        userResponse.setName(createdUser.getName());
//        userResponse.setEmail(createdUser.getEmail());
//
//        return ResponseEntity.ok(userResponse);
        try {
            userService.saveUser(user);
            return ResponseEntity.ok(true); // Return true if user is saved successfully
        } catch (Exception e) {
            return ResponseEntity.ok(false); // Return false if there is an error
        }
    }

    @PostMapping("api/user/signin")
    public ResponseEntity signIn(@RequestBody SignInRequest signInRequest) {
        Boolean response = userService.verifyUserCredentials(signInRequest.getEmail(), signInRequest.getPassword());
            return ResponseEntity.ok(response);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("users/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name) {
        Optional<User> user = userService.getUserByName(name);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
