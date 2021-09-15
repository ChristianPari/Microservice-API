package com.christianpari.mlbteamservice.service;

import com.christianpari.mlbteamservice.entity.Team;
import com.christianpari.mlbteamservice.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    log.info("Inside getTeamsByName in TeamService");
    return repository.getTeamsByName(name);
  }

  public Team getTeamByAbr(String abr) {
    log.info("Inside getTeamByAbr in TeamService");
    return repository.getTeamByAbr(abr);
  }

  public List<Team> getTeamsByAbr(String abr) {
    log.info("Inside getTeamsByAbr in TeamService");
    return repository.getTeamsByAbr(abr);
  }

  public Team getTeamById(Integer id) {
    log.info("Inside getTeamById in TeamService");
    return repository.findById(id).isPresent() ? repository.getById(id) : null;
  }

  public List<Team> getTeamsByConference(String con) {
    log.info("Inside getTeamsByConference in TeamService");
    return repository.getTeamsByConference(con);
  }

  public List<Team> getTeamsByDivision(String div) {
    log.info("Inside getTeamsByDivision in TeamService");
    return repository.getTeamsByDivision(div);
  }

  public List<Team> getTeamsByConAndDiv(String con, String div) {
    log.info("Inside getTeamsByConAndDiv in TeamService");
    return repository.getTeamsByConAndDiv(con, div);
  }

  // POST
  public Team addNewTeam(Team t) {
    log.info("Inside addNewTeam of TeamService");
    return repository.save(t);
  }

  // PATCH
  public Team updateTeam(Map<String, String> data) {
    log.info("Inside updateTeam of TeamService");
    Integer teamId = Integer.parseInt(data.get("id"));
    Team t = repository.getById(teamId);
    for (String field : data.keySet()) {
      switch (field) {
        case "name":
          t.setTeam_name(data.get("name"));
          break;

        case "abr":
          t.setTeam_abr(data.get("abr"));
          break;

        case "conference":
          t.setConference(data.get("conference"));
          break;

        case "division":
          t.setDivision(data.get("division"));
          break;
      }
    }
    return repository.save(t);
  }

  // DELETE
  public Team deleteTeam(Integer id) {
    log.info("Inside deleteTeam of TeamService");
    Team t = repository.getById(id);
    repository.delete(t);
    return t;
  }
}
