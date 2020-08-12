package com.app.controllers;

import com.app.entities.Comment;
import com.app.services.CommentService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/post/comment")
    public ResponseEntity addCommentOnPost(@RequestBody Comment comment){
        return ResponseEntity.ok().body(commentService.addComment(comment));
    }

}
