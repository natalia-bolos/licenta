package com.app.repositories;

import com.app.entities.PostAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostAttachmentRepository extends JpaRepository<PostAttachment,Integer> {
    List<PostAttachment> findByPostId(Integer postId);
}
