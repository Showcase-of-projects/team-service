package com.example.team_service.services;

import com.example.team_service.dtos.ExistenceResponse;
import com.example.team_service.dtos.TeamDTO;
import com.example.team_service.entities.TeamEntity;
import com.example.team_service.entities.UserEntity;
import com.example.team_service.exceptions.team.ThemeChangeNotAllowedException;
import com.example.team_service.exceptions.topic.TopicNotAvailableException;
import com.example.team_service.exceptions.topic.TopicNotFoundException;
import com.example.team_service.exceptions.user.UserAlreadyHasTeamException;
import com.example.team_service.exceptions.user.UserDoesNotHaveActiveTeamException;
import com.example.team_service.exceptions.user.UserNotFoundException;
import com.example.team_service.feign.TopicServiceClient;
import com.example.team_service.repositories.TeamRepository;
import com.example.team_service.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final TopicServiceClient topicServiceClient;

    public TeamService(TeamRepository teamRepository, UserRepository userRepository, ModelMapper modelMapper, TopicServiceClient topicServiceClient) {
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.topicServiceClient = topicServiceClient;
    }

    public TeamDTO create(Long userId) {
        UserEntity userEntity = getUserOrTrow(userId);
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

    public TeamDTO getActive(Long userId) {
        UserEntity userEntity = getUserOrTrow(userId);
        Optional<TeamEntity> teamEntity = teamRepository.getActiveTeam(userEntity);
        return teamEntity.map(entity -> modelMapper.map(entity, TeamDTO.class)).orElse(null);
    }

    public TeamDTO setTopic(Long userId, Long topicId) {
        UserEntity userEntity = getUserOrTrow(userId);
        TeamEntity teamEntity = teamRepository.getActiveTeam(userEntity)
                .orElseThrow(() -> new UserDoesNotHaveActiveTeamException("User must be in the active team"));
        if (!teamEntity.getLead().equals(userEntity)) {
            throw new ThemeChangeNotAllowedException("Insufficient rights: user must be a team lead");
        }
        ResponseEntity<ExistenceResponse> responseEntity = topicServiceClient.checkExistence(topicId);
        if (responseEntity.getStatusCode().equals(HttpStatusCode.valueOf(404))) {
            throw new TopicNotFoundException("topic with id " + topicId + " not found");
        }
        if (teamRepository.countAllByTopicId(topicId) > 3) {
            throw new TopicNotAvailableException("Topic is not available. Only 3 teams can reserve a project topic.");
        }
        teamEntity.setTopicId(topicId);
        teamRepository.save(teamEntity);
        return modelMapper.map(teamEntity, TeamDTO.class);
    }

    private UserEntity getUserOrTrow(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id %d does not exists", userId)));
    }
}
