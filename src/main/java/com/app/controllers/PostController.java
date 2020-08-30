package com.app.controllers;

import com.app.dto.ConversationRequest;
import com.app.entities.GroupPost;
import com.app.entities.Post;
import com.app.services.MessageService;
import com.app.services.PostAttachmentService;
import com.app.services.PostService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {

    private final PostService postService;
    private final PostAttachmentService postAttachmentService;
    private final MessageService messageService;

    public PostController(PostService postService, PostAttachmentService postAttachmentService, MessageService messageService) {
        this.postService = postService;
        this.postAttachmentService = postAttachmentService;
        this.messageService = messageService;
    }

    @GetMapping("/posts")
    public ResponseEntity getAllPosts(){
        return ResponseEntity.ok().body(postService.getAllPosts());
    }



    @GetMapping("/posts/user/{id}")
    public ResponseEntity getAllPostsWithComments(@PathVariable Integer id){
        return ResponseEntity.ok().body(postService.getAllPostsWithCommentsByUserId(id));
    }

    @GetMapping("/posts/group/{id}")
    public ResponseEntity getAllPostsByGroupId(@PathVariable Integer id){
        return  ResponseEntity.ok().body(postService.getAllPostWithCommentsByGroupId(id));
    }

    @PostMapping("/conversation")
    public ResponseEntity getConversation(@RequestBody ConversationRequest conversationRequest) {
        return  ResponseEntity.ok().body(messageService.getConversation(conversationRequest));
    }

    @PostMapping("/posts/group")
    public ResponseEntity addPostsToGroupId(@RequestBody GroupPost post){
        return  ResponseEntity.ok().body(postService.addPostsToGroupId(post));
    }

    @PostMapping("/posts")
    public ResponseEntity addPostWithoutAttachment(@RequestBody Post post){
        post=postService.savePost(post);
        return ResponseEntity.ok().body(post);
    }
}
