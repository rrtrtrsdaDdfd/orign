package com.example.demo.dto;

import com.example.demo.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class TopicByIdDTO {
    private String id;
    private String name;
    private Instant created;
    private List<Message> messages;
}
