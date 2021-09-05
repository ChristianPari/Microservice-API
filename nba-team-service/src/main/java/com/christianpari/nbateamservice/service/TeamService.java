package com.christianpari.nbateamservice.service;

import com.christianpari.nbateamservice.entity.Team;
import com.christianpari.nbateamservice.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
@Slf4j
public class TeamService {
  @Autowired
  private TeamRepository repository;

  //GET
  public List<Team> getAllTeams() {
    log.info("Inside getAllTeams in TeamService");
    return repository.findAll();
  }
  public List<Team> getTeamsByName(String name) {
    List<Team> teams = getAllTeams();
    for (int idx = 0; idx < teams.size(); idx++) {
      Team team = teams.get(idx);
      if (!Pattern.matches(name, team.getTeam_name())) {
        teams.remove(idx--);
      }
    }
    log.info("Inside getTeamsByName in TeamService");
    return teams;
  }
  public Team getTeamByAbr(String abr) {
    List<Team> teams = getAllTeams();
    for (Team t : teams) {
      if (t.getTeam_abr().equals(abr))
        return t;
    }
    log.info("Inside getTeamsByAbr in TeamService");
    return null;
  }
  public Team getTeamById(Integer id) {
    log.info("Inside getTeamById in TeamService");
    return repository.findById(id).isPresent() ? repository.getById(id) : null;
  }
}
