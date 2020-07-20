package com.app.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "post_attachment")
public class PostAttachment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_attachment_id")
    private int attachmentId;

    @Column(name="post_id")
    private int postId;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private byte[] file;

    public PostAttachment() {
    }

    public PostAttachment(int postId, String name, String type, byte[] file) {
        this.postId = postId;
        this.name = name;
        this.type = type;
        this.file = file;
    }

    public int getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(int attachmentId) {
        this.attachmentId = attachmentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
