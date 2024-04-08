package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "message")
@Getter
@Setter
public class Message {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "text")
    private String text;
    @Column(name = "author")
    private String author;
    @Column(name = "created")
    private Instant created = Instant.now();


    public Message() {
    }

}

