package com.example.team_service.entities;

import com.example.team_service.exceptions.user.UserAlreadyHasTeamException;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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
    private String role;
    @ManyToOne
    @JoinColumn(name = "active_team_id")
    private TeamEntity activeTeam;
    @ManyToMany
    @JoinTable(
            name = "user_team_history",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private List<TeamEntity> teams = new ArrayList<>();

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public TeamEntity getActiveTeam() {
        return activeTeam;
    }

    public void setActiveTeam(TeamEntity activeTeam) {
        this.activeTeam = activeTeam;
    }

    public void setTeams(List<TeamEntity> teams) {
        this.teams = teams;
    }

    public List<TeamEntity> getTeams() {
        return teams;
    }
}
