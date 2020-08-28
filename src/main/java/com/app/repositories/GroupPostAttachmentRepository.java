package com.app.repositories;

import com.app.entities.GroupPostAttachment;
import com.app.entities.PostAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupPostAttachmentRepository extends JpaRepository<GroupPostAttachment,Integer> {
    List<GroupPostAttachment> findByPostId(Integer postId);
}
