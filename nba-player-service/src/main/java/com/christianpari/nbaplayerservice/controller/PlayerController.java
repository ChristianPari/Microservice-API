package com.christianpari.nbaplayerservice.controller;

import com.christianpari.nbaplayerservice.VO.ResponseTemplateVO;
import com.christianpari.nbaplayerservice.entity.Player;
import com.christianpari.nbaplayerservice.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nba/players")
@Slf4j
public class PlayerController {
  @Autowired
  private PlayerService service;

  @GetMapping("/all")
  public List<Player> getAllPlayers() {
    log.info("Inside getAllPlayers of PlayerController");
    return service.getAllPlayers();
  }

  @GetMapping("/{id}")
  public ResponseTemplateVO getPlayerWithTeam(@PathVariable Integer id) {
    log.info("Inside getPlayerWithTeam of PlayerController");
    return service.getPlayerWithTeam(id);
  }
}
