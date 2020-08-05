package com.app.repositories;

import com.app.entities.PlatformMembership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  PlatformMembershipRepository extends JpaRepository<PlatformMembership,Integer> {
}
