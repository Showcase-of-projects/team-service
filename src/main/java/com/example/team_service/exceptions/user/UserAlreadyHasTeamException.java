package com.example.team_service.exceptions.user;

public class UserAlreadyHasTeamException extends UserException {
    public UserAlreadyHasTeamException(String message) {
        super(message);
    }
}
