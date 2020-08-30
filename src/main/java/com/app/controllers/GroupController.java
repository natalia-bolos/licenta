package com.app.controllers;

import com.app.dto.CreateGroupObject;
import com.app.entities.GroupMembership;
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

    @PostMapping("/group/join")
    public ResponseEntity createJoin(@RequestBody GroupMembership groupMembership){
        return ResponseEntity.ok().body(groupService.createGroupMembership(groupMembership));
    }

    @PostMapping("group/membership")
    public ResponseEntity updateMembershipRole(@RequestBody GroupMembership groupMembership){
        return  ResponseEntity.ok().body(groupService.updateGroupMembershipRole(groupMembership));
    }

    @GetMapping("/group/{id}")
    public ResponseEntity getGroupsByUserId(@PathVariable int id){
        return ResponseEntity.ok().body(groupService.getGroupsByUserId(id));
    }

    @GetMapping("/group/members/{id}")
    public ResponseEntity getGroupMembers(@PathVariable int id){
        return ResponseEntity.ok().body(groupService.getMembersOfGroupByGroupId(id));
    }

    @GetMapping("/group")
    public ResponseEntity getAllPublicGroups(){
        return ResponseEntity.ok().body(groupService.getAllPublicGroups());
    }

    @GetMapping("/group/name/{name}")
    public ResponseEntity getAllNameLike(@PathVariable String name){
        return ResponseEntity.ok().body(groupService.getAllNameLike(name));
    }

}
