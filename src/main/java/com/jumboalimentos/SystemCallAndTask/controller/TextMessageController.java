package com.jumboalimentos.SystemCallAndTask.controller;


import com.jumboalimentos.SystemCallAndTask.controller.service.TextMessageService;
import com.jumboalimentos.SystemCallAndTask.entities.CollaboratorsTask;
import com.jumboalimentos.SystemCallAndTask.entities.TextMessage;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/textmessage")
@CrossOrigin("*")
public class TextMessageController {
    @Autowired
    private TextMessageService textMessage;


    @PostMapping("newmessage")
    public ResponseEntity<TextMessage> newTextMessage(@Valid @RequestBody TextMessage newMessages) {
        try{
            TextMessage savedNewMessage = textMessage.newMessage(newMessages);
            return ResponseEntity.ok(savedNewMessage);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }


    @GetMapping("messages")
    public List<TextMessage> getTextMessage() {
        return  textMessage.findAll();
    }

}

