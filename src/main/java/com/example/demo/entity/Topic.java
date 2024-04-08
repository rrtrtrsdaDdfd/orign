package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "topic")
@Getter
@Setter
public class Topic {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "topicName")
    private String name;
    @Column(name = "created")
    private Instant created = Instant.now();
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "blog_id")
    private List<Message> messages;

    public Topic() {

    }

}

