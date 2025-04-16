package com.example.team_service.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamDTO {
    private Long id;
    private UserDTO lead;
    private boolean isActive = true;
    private Long topicId;
    private List<UserDTO> userDTOS;

    public TeamDTO() {
    }

    public TeamDTO(Long id, UserDTO lead, boolean isActive, Long topicId, List<UserDTO> userDTOS) {
        this.id = id;
        this.lead = lead;
        this.isActive = isActive;
        this.topicId = topicId;
        this.userDTOS = userDTOS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getLead() {
        return lead;
    }

    public void setLead(UserDTO lead) {
        this.lead = lead;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public List<UserDTO> getUserDTOS() {
        return userDTOS;
    }

    public void setUserDTOS(List<UserDTO> userDTOS) {
        this.userDTOS = userDTOS;
    }
}
