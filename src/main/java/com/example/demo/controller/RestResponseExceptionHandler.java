package com.example.demo.controller;

import com.example.demo.dto.ErrorDTO;
import com.example.demo.exception.MessageNotFoundException;
import com.example.demo.exception.TopicNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class RestResponseExceptionHandler {
    @ExceptionHandler(value = {TopicNotFoundException.class})
    protected ResponseEntity<ErrorDTO> handleTopicNotFoundException() {
        return ResponseEntity
                .status(404)
                .body(new ErrorDTO(400, "Данного топика не существует"));
    }
    @ExceptionHandler(value = {MessageNotFoundException.class})
    protected ResponseEntity<ErrorDTO> handleMassageNotFoundException() {
        return ResponseEntity
                .status(404)
                .body(new ErrorDTO(400, "Данного сообщения не существует"));
    }
}
