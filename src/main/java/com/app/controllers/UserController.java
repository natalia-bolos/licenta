package com.app.controllers;

import com.app.dto.CompleteMoreUserInfo;
import com.app.entities.User;
import com.app.services.MoreUserInformationService;
import com.app.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;


@RestController
@RequestMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;
    private final MoreUserInformationService moreUserInformationService;

    public UserController(UserService userService, MoreUserInformationService moreUserInformationService) {
        this.userService = userService;
        this.moreUserInformationService = moreUserInformationService;
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

    @GetMapping("/user/more/{id}")
    public ResponseEntity getMoreInfo(@PathVariable Integer id){
        return ResponseEntity.ok().body(moreUserInformationService.getMoreUserInfoByUserId(id));
    }

    @PostMapping("/user/more/{id}")
    public ResponseEntity saveMoreInfo(@RequestBody CompleteMoreUserInfo completeMoreUserInfo,@PathVariable Integer id){
        return ResponseEntity.ok().body(moreUserInformationService.saveUserInfo(completeMoreUserInfo,id));
    }
}
