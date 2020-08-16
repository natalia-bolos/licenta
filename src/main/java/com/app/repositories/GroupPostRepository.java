package com.app.repositories;

import com.app.entities.GroupPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupPostRepository extends JpaRepository<GroupPost,Integer> {
    List<GroupPost> findAllByGroupId(Integer id);
 }
