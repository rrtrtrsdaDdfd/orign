package com.example.demo.repository;

import com.example.demo.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, String> {
    Optional<Topic> findById(String id);
}
