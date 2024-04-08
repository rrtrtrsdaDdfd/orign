package com.example.demo.controller;

import com.example.demo.dto.AllTopicResponseDTO;
import com.example.demo.dto.TopicByIdDTO;
import com.example.demo.entity.Topic;
import com.example.demo.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/topic")
@RequiredArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @PostMapping
    public void saveGroup(@RequestBody Topic topic) {
        topic.setCreated(Instant.now());
        topicService.saveTopic(topic);
    }

    @GetMapping
    public List<AllTopicResponseDTO> getAllGroup() {
        return topicService.getAllTopic();
    }

    @GetMapping("{id}")
    public TopicByIdDTO getTopicById(@PathVariable String id) {
        return topicService.findTopicById(id);
    }

    @PutMapping
    public void updateTopic(@RequestBody Topic topic) {
        topicService.updateTopic(topic);
    }

}
