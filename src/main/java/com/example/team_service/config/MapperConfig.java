package com.example.team_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.typeMap(TopicEntity.class, TopicDTO.class)
//                .addMappings(mapper -> mapper.map(TopicEntity::getTypeEntity, TopicDTO::setTypeDTO))
//                .addMappings(mapper -> mapper.map(TopicEntity::getDepartmentEntity, TopicDTO::setDepartmentDTO));
        return modelMapper;
    }
}
