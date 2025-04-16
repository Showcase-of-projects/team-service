package com.example.team_service.config;

import com.example.team_service.dtos.TeamDTO;
import com.example.team_service.entities.TeamEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(TeamEntity.class, TeamDTO.class)
                .addMappings(mapper -> mapper.map(TeamEntity::getUserEntities, TeamDTO::setUserDTOS));
        return modelMapper;
    }
}
