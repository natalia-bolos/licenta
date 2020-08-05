package com.app.controllers;

import com.app.entities.User;
import com.app.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;


@RestController
@RequestMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity getUserById(@PathVariable Integer id){
       return ResponseEntity.ok().body(userService.getUserById(id).get());
    }
}
