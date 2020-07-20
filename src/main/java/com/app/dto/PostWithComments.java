package com.app.dto;

import com.app.entities.Comment;

import java.sql.Timestamp;
import java.util.List;

public class PostWithComments {

    private int postId;

    private int userId;

    private String text;

    private Timestamp timestamp;

    private List<Comment> comments;

    public PostWithComments() {
    }

    public PostWithComments(int postId, int userId, String text, Timestamp timestamp, List<Comment> comments) {
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
