package com.example.team_service.services;

import com.example.team_service.dtos.TeamDTO;
import com.example.team_service.entities.TeamEntity;
import com.example.team_service.entities.UserEntity;
import com.example.team_service.exceptions.user.UserAlreadyHasTeamException;
import com.example.team_service.exceptions.user.UserNotFoundException;
import com.example.team_service.repositories.TeamRepository;
import com.example.team_service.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public TeamService(TeamRepository teamRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public TeamDTO create(Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id %d does not exists", userId)));
        if (userEntity.getActiveTeam() != null) {
            throw new UserAlreadyHasTeamException(String.format("User with id %d already has a team", userEntity.getId()));
        }
        TeamEntity teamEntity = new TeamEntity(userEntity);
        Long savedTeamEntityId = teamRepository.save(teamEntity).getId();
        userEntity.setActiveTeam(teamEntity);
        userEntity.getTeams().add(teamEntity);
        userRepository.save(userEntity);
        TeamEntity savedTeamEntity = teamRepository.findById(savedTeamEntityId).orElseThrow();
        return modelMapper.map(savedTeamEntity, TeamDTO.class);
    }
}
