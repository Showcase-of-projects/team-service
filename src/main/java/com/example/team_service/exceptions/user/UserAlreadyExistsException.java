package com.example.team_service.exceptions.user;

public class UserAlreadyExistsException extends UserException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
