package com.example.team_service.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users_info")
public class UserEntity {
    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    private String patronymic;
    @Column(name = "group_name", nullable = false)
    private String group;
    private boolean hasActiveTeam = false;
    private String role;
    @ManyToOne
    private TeamEntity teamEntity;

    protected UserEntity() {
    }

    public UserEntity(Long id, String name, String surname, String patronymic, String group, String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.group = group;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public boolean isHasActiveTeam() {
        return hasActiveTeam;
    }

    public void setHasActiveTeam(boolean hasActiveTeam) {
        this.hasActiveTeam = hasActiveTeam;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public TeamEntity getTeamEntity() {
        return teamEntity;
    }

    public void setTeamEntity(TeamEntity teamEntity) {
        this.teamEntity = teamEntity;
    }
}
