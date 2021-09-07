package com.christianpari.nflteamservice.controller;

import com.christianpari.nflteamservice.entity.Team;
import com.christianpari.nflteamservice.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nfl/teams")
@Slf4j
public class TeamController {
  @Autowired
  private TeamService service;

  @GetMapping("/all")
  public List<Team> getAllTeams() {
    log.info("Inside getAllTeams of TeamController");
    return service.getAllTeams();
  }

  @GetMapping("/abr/{abr}")
  public List<Team> getTeamByAbr(@PathVariable String abr) {
    log.info("Inside getTeamsByAbr of TeamController");
    return service.getTeamByAbr(abr);
  }

  @GetMapping("/name/{name}")
  public List<Team> getTeamsByName(@PathVariable String name) {
    log.info("Inside getTeamsByName of TeamController");
    return service.getTeamsByName(name);
  }

  @GetMapping("/id/{id}")
  public Team getTeamById(@PathVariable Integer id) {
    log.info("Inside getTeamById of TeamController");
    return service.getTeamById(id);
  }
}
