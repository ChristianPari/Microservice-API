package com.christianpari.nbateamservice.controller;

import com.christianpari.nbateamservice.entity.Team;
import com.christianpari.nbateamservice.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/nba/teams")
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
  public Team getTeamByAbr(@PathVariable String abr) {
    log.info("Inside getTeamByAbr of TeamController");
    return service.getTeamByAbr(abr);
  }

  @GetMapping("/abr/{abr}")
  public List<Team> getTeamsByAbr(@PathVariable String abr) {
    log.info("Inside getTeamsByAbr of TeamController");
    return service.getTeamsByAbr(abr);
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

  @GetMapping("/conference/{con}")
  public List<Team> getTeamsByConference(@PathVariable String con) {
    log.info("Inside getTeamsByConference of TeamController");
    return service.getTeamsByConference(con);
  }

  @GetMapping("/division/{div}")
  public List<Team> getTeamsByDivision(@PathVariable String div) {
    log.info("Inside getTeamsByDivision of TeamController");
    return service.getTeamsByDivision(div);
  }

  @GetMapping("/conference/{con}/division/{div}")
  public List<Team> getTeamsByConAndDiv(@PathVariable("con") String con, @PathVariable("div") String div) {
    log.info("Inside getTeamsByConAndDiv of TeamController");
    return service.getTeamsByConAndDiv(con, div);
  }

  // POST
  @PostMapping("/newTeam")
  public Team addNewTeam(@RequestBody Team t) {
    log.info("Inside addNewTeam of TeamController");
    return service.addNewTeam(t);
  }

  // PATCH
  @PatchMapping("/updateTeam")
  public Team updateTeam(@RequestBody Map<String, String> data) {
    log.info("Inside updateTeam of TeamController");
    return service.updateTeam(data);
  }

  // DELETE
  @DeleteMapping("/deleteTeam/{id}")
  public Team deleteTeam(@PathVariable Integer id) {
    log.info("Inside deleteTeam of TeamController");
    return service.deleteTeam(id);
  }
}
