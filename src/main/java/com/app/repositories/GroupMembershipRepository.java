package com.app.repositories;

import com.app.entities.GroupMembership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupMembershipRepository extends JpaRepository<GroupMembership,Integer> {
}
