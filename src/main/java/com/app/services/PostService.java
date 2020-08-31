package com.app.services;

import com.app.dto.GroupPostWithAttachments;
import com.app.entities.*;
import com.app.repositories.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {


    private final GroupPostRepository groupPostRepository;

    private final UserRepository userRepository;

    private final GroupPostAttachmentRepository groupPostAttachmentRepository;

    public PostService(GroupPostRepository groupPostRepository, UserRepository userRepository, GroupPostAttachmentRepository groupPostAttachmentRepository) {
        this.groupPostRepository = groupPostRepository;
        this.userRepository = userRepository;
        this.groupPostAttachmentRepository = groupPostAttachmentRepository;
    }



    public List<GroupPostWithAttachments> getAllPostWithCommentsByGroupId(Integer id) {
        List<GroupPost> postsByGroupId = groupPostRepository.findAllByGroupId(id);
        List<GroupPostWithAttachments> postsWithComments = new ArrayList<>();
        for (GroupPost post : postsByGroupId) {

            User user = userRepository.findById(post.getUserId()).orElse(null);
            List<GroupPostAttachment> attachments=groupPostAttachmentRepository.findByPostId(post.getGroupPostId());
            if (user != null) {
                postsWithComments.add(new GroupPostWithAttachments(post.getGroupPostId(), post.getUserId(), user.getUsername(), post.getText(), post.getTimestamp(),attachments));
            }
        }
        return postsWithComments;
    }


    public GroupPost addPostsToGroupId(GroupPost post){
        post.setTimestamp( new Timestamp(System.currentTimeMillis()));
       return groupPostRepository.save(post);
    }

}
