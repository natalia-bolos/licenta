package com.app.services;

import com.app.dto.ConversationRequest;
import com.app.dto.MessageDto;
import com.app.entities.Message;
import com.app.entities.User;
import com.app.repositories.MessageRepository;
import com.app.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public MessageService(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    public List<MessageDto> getConversation(ConversationRequest conversationRequest){
        List<Message> messages=messageRepository.findAllBySenderIdAndReceiverIdOrderBySentTimestamp(conversationRequest.getSenderId(),conversationRequest.getReceiverId());
        messages.addAll(messageRepository.findAllBySenderIdAndReceiverIdOrderBySentTimestamp(conversationRequest.getReceiverId(),conversationRequest.getSenderId()));
        messages.sort(new Comparator<Message>() {
            @Override
            public int compare(Message o1, Message o2) {
                if(o1.getSentTimestamp()!=null&&o2.getSentTimestamp()!=null) {
                    return o1.getSentTimestamp().compareTo(o2.getSentTimestamp());
                } else{
                    return 0;
                }
            }
        });
        List<MessageDto> toReturnMessages= new ArrayList<>();
        for(Message message:messages){
            User sender=userRepository.findById(message.getSenderId()).orElse(null);
            User receiver=userRepository.findById(message.getReceiverId()).orElse(null);
            toReturnMessages.add(new MessageDto(message,sender.getUsername(),receiver.getUsername()));
        }
        return toReturnMessages ;
    }

    public MessageDto saveMessage(Message sentMessage){
        sentMessage.setSentTimestamp(new Timestamp(System.currentTimeMillis()));
        Message saved=messageRepository.save(sentMessage);
        User sender=userRepository.findById(saved.getSenderId()).orElse(null);
        User receiver=userRepository.findById(saved.getReceiverId()).orElse(null);
        return new MessageDto(saved,sender.getUsername(),receiver.getUsername());
    }
}
