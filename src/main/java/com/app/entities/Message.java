package com.app.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageId;

    @Column(name="sender_id")
    private int senderId;

    @Column(name="receiver_id")
    private int receiverId;

    @Column
    private String text;

    @Column(name="sent_timestamp")
    private Timestamp sentTimestamp;

    @Column(name="read_timestamp")
    private Timestamp readTimestamp;

    public Message() {
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getSentTimestamp() {
        return sentTimestamp;
    }

    public void setSentTimestamp(Timestamp sentTimestamp) {
        this.sentTimestamp = sentTimestamp;
    }

    public Timestamp getReadTimestamp() {
        return readTimestamp;
    }

    public void setReadTimestamp(Timestamp readTimestamp) {
        this.readTimestamp = readTimestamp;
    }
}
