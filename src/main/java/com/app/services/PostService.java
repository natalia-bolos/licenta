package com.app.services;

import com.app.dto.PostWithComments;
import com.app.entities.Post;
import com.app.repositories.CommentRepository;
import com.app.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    private final CommentRepository commentRepository;

    public PostService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> getAllPostsByUserId(Integer id) {
        return postRepository.findByUserId(id);
    }

    public List<PostWithComments> getAllPostsWithCommentsByUserId(Integer id) {
        List<Post> postsByUserId = postRepository.findByUserId(id);
        List<PostWithComments> postsWithComments = new ArrayList<>();
        for (Post post : postsByUserId) {
            postsWithComments.add(new PostWithComments(post.getPostId(), post.getUserId(), post.getText(), post.getTimestamp(), commentRepository.findAllByPostId(post.getPostId())));
        }
        return postsWithComments;
    }

    public Post savePost(Post post){
        return postRepository.save(post);
    }
}
