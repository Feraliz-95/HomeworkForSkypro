package org.example.exam_questions.controller;

import org.example.exam_questions.exception.ExamException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExamControllerAdvice {
    @ExceptionHandler(ExamException.class)
    public ResponseEntity<String> handleExamException(ExamException ex) {
        return new ResponseEntity<>(ex.getMessage(), ex.getStatus());
    }
}