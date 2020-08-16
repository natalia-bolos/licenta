package com.app.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="group_post")
public class GroupPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="group_post_id")
    private int groupPostId;

    @Column
    private int groupId;

    @Column
    private int userId;

    @Column
    private String text;

    @Column
    private Timestamp timestamp;

    public GroupPost() {
    }

    public int getGroupPostId() {
        return groupPostId;
    }

    public void setGroupPostId(int groupPostId) {
        this.groupPostId = groupPostId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
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
}
