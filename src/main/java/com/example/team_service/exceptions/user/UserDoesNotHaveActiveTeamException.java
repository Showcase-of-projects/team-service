package com.example.team_service.exceptions.user;

public class UserDoesNotHaveActiveTeamException extends UserException {
    public UserDoesNotHaveActiveTeamException(String message) {
        super(message);
    }
}
