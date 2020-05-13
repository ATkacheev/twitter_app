package com.example.letscode.demoletscode.service;

import com.example.letscode.demoletscode.domain.User;
import com.example.letscode.demoletscode.domain.dto.MessageDTO;
import com.example.letscode.demoletscode.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessageRepo messageRepo;

    @Autowired
    public MessageService(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    public Page<MessageDTO> messageList(Pageable pageable, String filter, User user){
        Page<MessageDTO> page;
        if(filter != null && !filter.isEmpty()) {
            page = messageRepo.findByTag(filter, pageable, user);
            if(messageRepo.findByTag(filter, pageable).isEmpty())
                page = messageRepo.findAll(pageable, user);
        } else {
            page = messageRepo.findAll(pageable, user);
        }

        return page;
    }

    public Page<MessageDTO> messageListForUser(Pageable pageable, User currentUser, User author) {
        return messageRepo.findByUser(pageable, author, currentUser);
    }
}
