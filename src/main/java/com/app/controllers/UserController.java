package com.app.controllers;

import com.app.entities.User;
import com.app.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getUserById(@PathVariable Integer id){
       return ResponseEntity.ok().body(userService.getUserById(id).get());
    }

    @PostMapping("/users/register")
    public ResponseEntity registerUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.save(user));
    }

    @PostMapping("/users/login")
    public ResponseEntity logInUser(@RequestBody User user){
            return ResponseEntity.ok().body(userService.logIn(user.getUsername(),user.getPassword(),user.getMail()));

    }


}
