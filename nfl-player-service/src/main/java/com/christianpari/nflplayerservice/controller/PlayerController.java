package com.christianpari.nflplayerservice.controller;

import com.christianpari.nflplayerservice.VO.MultiPlayerTeamVO;
import com.christianpari.nflplayerservice.VO.PlayerTeamVO;
import com.christianpari.nflplayerservice.entity.Player;
import com.christianpari.nflplayerservice.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nfl/players")
@Slf4j
public class PlayerController {
  @Autowired
  private PlayerService service;

  @GetMapping("/all")
  public List<Player> getAllPlayers() {
    log.info("Inside getAllPlayers of PlayerController");
    return service.getAllPlayers();
  }

  @GetMapping("/team/{abr}")
  public MultiPlayerTeamVO getPlayersByTeam(@PathVariable String abr) {
    log.info("Inside getPlayersByTeam of PlayerController");
    return service.getPlayersByTeam(abr);
  }

  @GetMapping("/pos/{pos}")
  public List<Player> getPlayersByPosition(@PathVariable String pos) {
    log.info("Inside getPlayersByPosition of PlayerController");
    return service.getPlayersByPosition(pos);
  }

  @GetMapping("/jersey/{jersey}")
  public List<Player> getPlayersByJersey(@PathVariable String jersey) {
    log.info("Inside getPlayersByJersey of PlayerController");
    return service.getPlayersByJersey(jersey);
  }

  @GetMapping("/player/{id}")
  public Player getPlayerById(@PathVariable Integer id) {
    log.info("Inside getPlayerById of PlayerController");
    return service.getPlayerById(id);
  }

  @GetMapping("/name/{name}")
  public List<Player> getPlayersByName(@PathVariable String name) {
    log.info("Inside getPlayersByName of PlayerController");
    return service.getPlayersByName(name);
  }

  @GetMapping("/player-with-team/{id}")
  public PlayerTeamVO getPlayerByIdWithTeam(@PathVariable Integer id) {
    log.info("Inside getPlayerByIdWithTeam of PlayerController");
    return service.getPlayerByIdWithTeam(id);
  }
}
