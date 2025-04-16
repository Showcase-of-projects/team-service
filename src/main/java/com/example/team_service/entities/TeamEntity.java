package com.example.team_service.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "teams")
public class TeamEntity extends BaseEntity {
    @ManyToOne()
    private UserEntity lead;
    private boolean isActive = true;
    private Long topicId;
    @ManyToMany(mappedBy = "teams", fetch = FetchType.EAGER)
    private List<UserEntity> userEntities;

    protected TeamEntity() {
    }

    public TeamEntity(UserEntity lead) {
        this.lead = lead;
        this.userEntities = new ArrayList<>(Arrays.asList(lead));
    }

    public UserEntity getLead() {
        return lead;
    }

    public void setLead(UserEntity lead) {
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

    public List<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }
}
