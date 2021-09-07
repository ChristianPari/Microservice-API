package com.christianpari.nflteamservice.service;

import com.christianpari.nflteamservice.entity.Team;
import com.christianpari.nflteamservice.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
      String teamName = team.getTeam_name().toLowerCase();
      if (!teamName.contains(name))
        teams.remove(idx--);
    }
    log.info("Inside getTeamsByName in TeamService");
    return teams;
  }
  public List<Team> getTeamByAbr(String abr) {
    List<Team> teams = getAllTeams();
    for (int idx = 0; idx < teams.size(); idx++) {
      Team team = teams.get(idx);
      String teamAbr = team.getTeam_abr().toLowerCase();
      abr = abr.toLowerCase();
      if (!teamAbr.contains(abr))
        teams.remove(idx--);
    }
    log.info("Inside getTeamsByAbr in TeamService");
    return teams;
  }
  public Team getTeamById(Integer id) {
    log.info("Inside getTeamById in TeamService");
    return repository.findById(id).isPresent() ? repository.getById(id) : null;
  }
}
