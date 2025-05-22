package com.example.team_service.exceptions.topic;

public abstract class TopicException extends RuntimeException {
    public TopicException(String message) {
        super(message);
    }
}
