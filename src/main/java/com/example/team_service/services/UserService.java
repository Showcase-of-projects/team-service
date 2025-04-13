package com.example.team_service.services;

import com.example.team_service.dtos.UserDTO;
import com.example.team_service.entities.UserEntity;
import com.example.team_service.exceptions.user.UserAlreadyExistsException;
import com.example.team_service.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserDTO create(UserDTO userDTO) {
        if (userRepository.findById(userDTO.getId()).isPresent()) {
            throw new UserAlreadyExistsException(String.format("User with id %d already exists", userDTO.getId()));
        } else {
            UserEntity userEntity = new UserEntity(
                    userDTO.getId(),
                    userDTO.getName(),
                    userDTO.getSurname(),
                    userDTO.getPatronymic(),
                    userDTO.getGroup(),
                    userDTO.getRole()
            );
            UserDTO savedUserDTO = modelMapper.map(userRepository.save(userEntity), UserDTO.class);
            return savedUserDTO;
        }
    }
}
