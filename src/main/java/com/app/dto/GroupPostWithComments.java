package com.app.dto;


import com.app.entities.GroupPostAttachment;
import com.app.entities.GroupPostComment;

import java.util.Date;
import java.util.List;

public class GroupPostWithComments {
    private int postId;

    private int userId;

    private String username;

    private String text;

    private Date timestamp;

    private List<GroupPostComment> comments;

    private List<GroupPostAttachment> attachments;


    public GroupPostWithComments(int postId, int userId, String username, String text, Date timestamp, List<GroupPostComment> comments, List<GroupPostAttachment> attachments) {
        this.postId = postId;
        this.userId = userId;
        this.username = username;
        this.text = text;
        this.timestamp = timestamp;
        this.comments = comments;
        this.attachments = attachments;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<GroupPostComment> getComments() {
        return comments;
    }

    public void setComments(List<GroupPostComment> comments) {
        this.comments = comments;
    }

    public List<GroupPostAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<GroupPostAttachment> attachments) {
        this.attachments = attachments;
    }
}
