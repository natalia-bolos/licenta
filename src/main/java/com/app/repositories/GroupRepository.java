package com.app.repositories;

import com.app.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group,Integer> {
    List<Group> findAllByType(String type);
    List<Group> findByNameLike(String name);
}
