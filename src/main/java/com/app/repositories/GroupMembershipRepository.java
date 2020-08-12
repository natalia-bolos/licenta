package com.app.repositories;

import com.app.entities.GroupMembership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupMembershipRepository extends JpaRepository<GroupMembership,Integer> {
    List<GroupMembership> findAllByUserId(int id);
}
