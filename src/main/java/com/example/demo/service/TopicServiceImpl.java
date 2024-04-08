package com.example.demo.service;


import com.example.demo.dto.AllTopicResponseDTO;
import com.example.demo.dto.TopicByIdDTO;
import com.example.demo.entity.Topic;
import com.example.demo.exception.TopicNotFoundException;
import com.example.demo.mapper.AllTopicMapper;
import com.example.demo.mapper.TopicMapper;
import com.example.demo.repository.TopicRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;

    @Override
    public void saveTopic(Topic topic) {
        topicRepository.save(topic);
    }

    @Override
    public List<AllTopicResponseDTO> getAllTopic() {
        return topicRepository.findAll()
                .stream()
                .map(AllTopicMapper.INSTANCE::TopicToAllDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TopicByIdDTO findTopicById(String id) {
        Optional<Topic> topicOptional = topicRepository.findById(id);
        if (topicOptional.isPresent()) {
            return TopicMapper.INSTANCE.TopicToDTO(topicOptional.get());
        } else {
            throw new TopicNotFoundException();
        }
    }

    @Override
    public void updateTopic(Topic topic) {
        String topicID = topic.getId();
        Optional<Topic> topicOptional = topicRepository.findById(topicID);
        if (topicOptional.isPresent()) {
            topic.setMessages(topicOptional.get().getMessages());
            topicRepository.save(topic);
        } else {
            throw new TopicNotFoundException();
        }
    }
}
