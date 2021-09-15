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
}
