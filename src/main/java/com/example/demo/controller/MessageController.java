package com.example.demo.controller;

import com.example.demo.entity.Message;
import com.example.demo.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable String id) {
        messageService.deleteMessageById(id);
    }

    @PostMapping("/topic/{id}/message")
    public void saveMessage(@PathVariable String id, @RequestBody Message message) {
        messageService.saveMessageInTopic(id, message);
    }

    @PutMapping("/topic/{id}/message")
    public void updateMessage(@PathVariable String id, @RequestBody Message message) {
        messageService.updateMessage(id, message);
    }

}
