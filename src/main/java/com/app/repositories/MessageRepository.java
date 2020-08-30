package com.app.repositories;

import com.app.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer> {
    List<Message> findAllBySenderIdAndReceiverIdOrderBySentTimestamp(int senderId,int receiverId);
}
