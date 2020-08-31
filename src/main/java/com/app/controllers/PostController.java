package com.app.controllers;

import com.app.dto.ConversationRequest;
import com.app.entities.GroupPost;
import com.app.entities.Message;
import com.app.services.MessageService;
import com.app.services.PostService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {

    private final PostService postService;

    private final MessageService messageService;

    public PostController(PostService postService, MessageService messageService) {
        this.postService = postService;
        this.messageService = messageService;
    }

    @GetMapping("/posts/group/{id}")
    public ResponseEntity getAllPostsByGroupId(@PathVariable Integer id){
        return  ResponseEntity.ok().body(postService.getAllPostWithCommentsByGroupId(id));
    }

    @PostMapping("/conversation")
    public ResponseEntity getConversation(@RequestBody ConversationRequest conversationRequest) {
        return  ResponseEntity.ok().body(messageService.getConversation(conversationRequest));
    }

    @PostMapping("/conversation/new")
    public ResponseEntity addConversation(@RequestBody Message message) {
        return  ResponseEntity.ok().body(messageService.saveMessage(message));
    }

    @PostMapping("/posts/group")
    public ResponseEntity addPostsToGroupId(@RequestBody GroupPost post){
        return  ResponseEntity.ok().body(postService.addPostsToGroupId(post));
    }

}
