package com.example.team_service.controllers;

import com.example.team_service.dtos.TeamDTO;
import com.example.team_service.services.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/create")
    public ResponseEntity<TeamDTO> create(Principal principal) {
        TeamDTO teamDTO = teamService.create(Long.parseLong(principal.getName()));
        return ResponseEntity.ok(teamDTO);
    }

    @GetMapping("/user-active-team/get")
    public ResponseEntity<TeamDTO> getActiveTeam(Principal principal) {
        TeamDTO teamDTO = teamService.getActive(Long.parseLong(principal.getName()));
        return ResponseEntity.ok(teamDTO);
    }

    @PatchMapping("/set-topic")
    public ResponseEntity<TeamDTO> setTopic(@RequestParam("id") Long topicId, Principal principal) {
        TeamDTO teamDTO = teamService.setTopic(Long.parseLong(principal.getName()), topicId);
        return ResponseEntity.ok(teamDTO);
    }

}
