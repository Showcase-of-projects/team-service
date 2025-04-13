package com.example.team_service.controllers;

import com.example.team_service.dtos.UserDTO;
import com.example.team_service.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("create")
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
        UserDTO savedUserDTO = userService.create(userDTO);
        return ResponseEntity.ok(savedUserDTO);
    }
}
