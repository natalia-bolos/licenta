package com.app.services;

import com.app.dto.CreateGroupObject;
import com.app.dto.GroupMember;
import com.app.entities.*;
import com.app.exceptions.AppException;
import com.app.repositories.GroupMembershipRepository;
import com.app.repositories.GroupRepository;
import com.app.repositories.RoleRepository;
import com.app.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
    RoleRepository roleRepository;
    GroupMembershipRepository groupMembershipRepository;
    GroupRepository groupRepository;
    UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(GroupService.class);


    public GroupService(RoleRepository roleRepository, GroupMembershipRepository groupMembershipRepository, GroupRepository groupRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.groupMembershipRepository = groupMembershipRepository;
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    public Group createGroup(CreateGroupObject toCreateData) {
        Group toSave = new Group();
        toSave.setDescription(toCreateData.getDescription());
        toSave.setName(toCreateData.getName());
        toSave.setType(toCreateData.getType());
        Group newGroup = groupRepository.save(toSave);
        Role userRole = roleRepository.findByName(RoleName.ROLE_CREATOR)
                .orElseThrow(() -> new AppException("User Role not set."));
        GroupMembership groupMembership = new GroupMembership();
        groupMembership.setGroupId(newGroup.getGroupId());
        groupMembership.setRoleId(userRole.getRoleId());
        groupMembership.setUserId(toCreateData.getCreatorId());
        groupMembership.setTimestamp(new Timestamp(System.currentTimeMillis()));
        groupMembershipRepository.save(groupMembership);
        return newGroup;
    }

    public List<Group> getGroupsByUserId(int id){
        List<GroupMembership> memberships= groupMembershipRepository.findAllByUserId(id);
        List<Group> groups= new ArrayList<>();
        for(GroupMembership membership:memberships){
            Group toAdd=groupRepository.findById(membership.getGroupId()).orElse(null);
            if(toAdd!=null) {
                groups.add(toAdd);
            }
        }
        return groups;
    }

    public List<GroupMember> getMembersOfGroupByGroupId(Integer id){
        List<GroupMembership> memberships= groupMembershipRepository.findAllByGroupId(id);
        List<GroupMember> members=new ArrayList<>();
        for(GroupMembership membership:memberships){
            User toAdd=userRepository.findById(membership.getUserId()).orElse(null);
            Role role=roleRepository.findById(membership.getRoleId()).orElse(null);
            if(toAdd!=null&&role!=null) {
                members.add(new GroupMember(toAdd.getUserId(),toAdd.getName(),toAdd.getMail(),toAdd.getUsername(),role));
            }
        }
        return members;
    }

}
