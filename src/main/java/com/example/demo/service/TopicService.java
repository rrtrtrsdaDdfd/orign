package com.example.demo.service;




import com.example.demo.dto.AllTopicResponseDTO;
import com.example.demo.dto.TopicByIdDTO;
import com.example.demo.entity.Topic;

import java.util.List;

public interface TopicService {
    void saveTopic(Topic topic);

    List<AllTopicResponseDTO> getAllTopic();
    TopicByIdDTO findTopicById(String id);
    void updateTopic(Topic topic);
}

