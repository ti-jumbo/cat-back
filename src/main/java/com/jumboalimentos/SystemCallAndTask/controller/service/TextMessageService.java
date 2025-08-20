package com.jumboalimentos.SystemCallAndTask.controller.service;


import com.jumboalimentos.SystemCallAndTask.TextMessageRepository;
import com.jumboalimentos.SystemCallAndTask.entities.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextMessageService {
    @Autowired
    private TextMessageRepository messageRepository;


    public TextMessage newMessage(TextMessage message) {
        if(messageRepository == null) {
            throw new IllegalArgumentException("message cannot be null");
        }
        return messageRepository.save(message);
    }

    public List<TextMessage> findAll() {
        return messageRepository.findAll();
    }
}
