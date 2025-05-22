package com.example.team_service.repositories;

import com.example.team_service.entities.TeamEntity;
import com.example.team_service.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TeamRepository extends GeneralRepository<TeamEntity, Long> {
    @Query(value = "select t from TeamEntity t join t.userEntities u where u = :user and t.isActive = true")
    Optional<TeamEntity> getActiveTeam(@Param(value = "user") UserEntity userEntity);

    @Query(value = "select count(t) from TeamEntity t where t.isActive = true and t.topicId = :topicId")
    Integer countAllByTopicId(@Param("topicId") Long topicId);
}
