package com.example.team_service.exceptions.team;

public abstract class TeamException extends RuntimeException {
    public TeamException(String message) {
        super(message);
    }
}
