package com.app.controllers;

import com.app.dto.CreateGroupObject;
import com.app.services.GroupService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/group/new")
    public ResponseEntity createGroup(@RequestBody CreateGroupObject createGroupObject){
        return ResponseEntity.ok().body(groupService.createGroup(createGroupObject));
    }

    @GetMapping("/group/{id}")
    public ResponseEntity getGroupsByUserId(@PathVariable int id){
        return ResponseEntity.ok().body(groupService.getGroupsByUserId(id));
    }

}
