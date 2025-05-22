package com.example.team_service.dtos;

public class ExistenceResponse {
    private boolean isAvailable;

    public ExistenceResponse() {
    }

    public ExistenceResponse(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
