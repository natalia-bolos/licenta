package com.app.dto;


import com.app.entities.GroupPostComment;

import java.util.Date;
import java.util.List;

public class GroupPostWithComments {
    private int postId;

    private int userId;

    private String text;

    private Date timestamp;

    private List<GroupPostComment> comments;

    public GroupPostWithComments(int userId, String text, Date timestamp, List<GroupPostComment> comments) {
        this.userId = userId;
        this.text = text;
        this.timestamp = timestamp;
        this.comments = comments;
    }

    public GroupPostWithComments(int postId, int userId, String text, Date timestamp, List<GroupPostComment> comments) {
        this.postId = postId;
        this.userId = userId;
        this.text = text;
        this.timestamp = timestamp;
        this.comments = comments;
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
}
