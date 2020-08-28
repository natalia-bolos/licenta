package com.app.services;

import com.app.dto.GroupPostWithComments;
import com.app.dto.PostWithComments;
import com.app.entities.*;
import com.app.repositories.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    private final CommentRepository commentRepository;

    private final GroupPostRepository groupPostRepository;

    private final GroupPostCommentRepository groupPostCommentRepository;

    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, CommentRepository commentRepository, GroupPostRepository groupPostRepository, GroupPostCommentRepository groupPostCommentRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.groupPostRepository = groupPostRepository;
        this.groupPostCommentRepository = groupPostCommentRepository;
        this.userRepository = userRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }


    public List<GroupPostWithComments> getAllPostWithCommentsByGroupId(Integer id) {
        List<GroupPost> postsByGroupId = groupPostRepository.findAllByGroupId(id);
        List<GroupPostWithComments> postsWithComments = new ArrayList<>();
        for (GroupPost post : postsByGroupId) {
            List<GroupPostComment> comments = groupPostCommentRepository.findAllByGroupPostId(post.getGroupPostId());
            for (GroupPostComment comment : comments) {
                User user = userRepository.findById(comment.getUserId()).orElse(null);
                if (user != null) {
                    comment.setUsername(user.getUsername());
                }
            }
            User user = userRepository.findById(post.getUserId()).orElse(null);
            if (user != null) {
                postsWithComments.add(new GroupPostWithComments(post.getGroupPostId(), post.getUserId(), user.getUsername(), post.getText(), post.getTimestamp(), comments));
            }
        }
        return postsWithComments;
    }

    public List<PostWithComments> getAllPostsWithCommentsByUserId(Integer id) {
        List<Post> postsByUserId = postRepository.findByUserIdOrderByTimestampDesc(id);
        List<PostWithComments> postsWithComments = new ArrayList<>();
        for (Post post : postsByUserId) {
            List<Comment> comments = commentRepository.findAllByPostId(post.getPostId());
            for (Comment comment : comments) {
                User user = userRepository.findById(comment.getUserId()).orElse(null);
                if (user != null) {
                    comment.setUsername(user.getUsername());
                }
            }
            User user = userRepository.findById(post.getUserId()).orElse(null);
            if (user != null) {
                postsWithComments.add(new PostWithComments(post.getPostId(), post.getUserId(), user.getUsername(), post.getText(), post.getTimestamp(), comments));
            }
        }
        return postsWithComments;
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public GroupPost addPostsToGroupId(GroupPost post){
        post.setTimestamp( new Timestamp(System.currentTimeMillis()));
       return groupPostRepository.save(post);
    }

}
