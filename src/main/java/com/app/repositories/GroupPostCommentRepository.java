package com.app.repositories;

import com.app.entities.GroupPostComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupPostCommentRepository extends JpaRepository<GroupPostComment,Integer> {
    List<GroupPostComment> findAllByGroupPostId(Integer id);
}
