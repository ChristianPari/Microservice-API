package com.christianpari.mlbteamservice.controller;

import com.christianpari.mlbteamservice.entity.Team;
import com.christianpari.mlbteamservice.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mlb/teams")
@Slf4j
public class TeamController {
  @Autowired
  private TeamService service;

  @GetMapping("/all")
  public List<Team> getAllTeams() {
    log.info("Inside getAllTeams of TeamController");
    return service.getAllTeams();
  }

  @GetMapping("/{abr}")
  public Team getTeamByAbr(@PathVariable String abr) {
    log.info("Inside getAllTeams of TeamController");
    return service.getTeamByAbr(abr);
  }
}
