package com.app.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "group_post_comment")
public class GroupPostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groupPostCommentId;

    @Column
    private int groupPostId;

    @Column
    private String text;

    @Column
    private Timestamp timestamp;

    public GroupPostComment() {
    }

    public int getGroupPostCommentId() {
        return groupPostCommentId;
    }

    public void setGroupPostCommentId(int groupPostCommentId) {
        this.groupPostCommentId = groupPostCommentId;
    }

    public int getGroupPostId() {
        return groupPostId;
    }

    public void setGroupPostId(int groupPostId) {
        this.groupPostId = groupPostId;
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
}
