package com.app.dto;

import com.app.entities.Message;

public class MessageDto {
    Message message;
    String senderUserName;
    String receiverUserName;

    public MessageDto(Message message, String senderUserName, String receiverUserName) {
        this.message = message;
        this.senderUserName = senderUserName;
        this.receiverUserName = receiverUserName;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getSenderUserName() {
        return senderUserName;
    }

    public void setSenderUserName(String senderUserName) {
        this.senderUserName = senderUserName;
    }

    public String getReceiverUserName() {
        return receiverUserName;
    }

    public void setReceiverUserName(String receiverUserName) {
        this.receiverUserName = receiverUserName;
    }
}
