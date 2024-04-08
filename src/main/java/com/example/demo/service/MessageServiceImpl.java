package com.example.demo.service;

import com.example.demo.entity.Message;
import com.example.demo.entity.Topic;
import com.example.demo.exception.MessageNotFoundException;
import com.example.demo.exception.TopicNotFoundException;
import com.example.demo.repository.MessageRepository;
import com.example.demo.repository.TopicRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final TopicRepository topicRepository;

    @Override
    public void saveMessageInTopic(String topicId, Message message) {
        Optional<Topic> topicOptional = topicRepository.findById(topicId);
        if (topicOptional.isPresent()) {
            Topic topic = topicOptional.get();
            topic.getMessages().add(message);
            topicRepository.save(topic);
        } else {
            throw new TopicNotFoundException();
        }
    }

    @Override
    public void deleteMessageById(String messageId) {
        Optional<Message> messageOptional = messageRepository.findById(messageId);
        if (messageOptional.isPresent()) {
            messageRepository.deleteById(messageId);
        } else {
            throw new MessageNotFoundException();
        }
    }

    @Override
    public void updateMessage(String topicId, Message message) {
        Optional<Topic> topicOptional = topicRepository.findById(topicId);
        if (topicOptional.isPresent()) {
            Topic topic = topicOptional.get();
            topic.getMessages().add(message);
            topicRepository.save(topic);
        } else {
            throw new TopicNotFoundException();
        }
    }

}
