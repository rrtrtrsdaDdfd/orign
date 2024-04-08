package com.example.demo.service;

import com.example.demo.entity.Message;

public interface MessageService {
    void saveMessageInTopic(String topicId, Message message);

    void deleteMessageById(String messageId);

    void updateMessage(String id, Message message);
}
