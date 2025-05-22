package com.example.team_service.dtos;

public class TopicCheckRequest {
    private int id;

    public TopicCheckRequest() {
    }

    public TopicCheckRequest(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
