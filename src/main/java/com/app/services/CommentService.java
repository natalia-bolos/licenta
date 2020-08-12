package com.app.services;

import com.app.entities.Comment;
import com.app.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment addComment(Comment comment){
       return commentRepository.save(comment);
    }
}
