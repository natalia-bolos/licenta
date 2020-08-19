package com.app.dto;

import com.app.entities.Comment;

import java.util.Date;
import java.util.List;

public class PostWithComments {

    private int postId;

    private int userId;

    private String username;

    private String text;

    private Date timestamp;

    private List<Comment> comments;

    public PostWithComments() {
    }

    public PostWithComments(int postId, int userId, String text, Date timestamp, List<Comment> comments) {
        this.postId = postId;
        this.userId = userId;
        this.text = text;
        this.timestamp = timestamp;
        this.comments = comments;
    }

    public PostWithComments(int postId, int userId, String username, String text, Date timestamp, List<Comment> comments) {
        this.postId = postId;
        this.userId = userId;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
