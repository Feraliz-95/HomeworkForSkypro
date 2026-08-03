package org.example.exam_questions.exception;

import org.springframework.http.HttpStatus;

public class ExamException extends RuntimeException{
    private final HttpStatus status;

    public ExamException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}