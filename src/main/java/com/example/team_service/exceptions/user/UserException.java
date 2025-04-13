package com.example.team_service.exceptions.user;

public abstract class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
    }
}
