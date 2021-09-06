package com.christianpari.nbaplayerservice.service;

import com.christianpari.nbaplayerservice.VO.ResponseTemplateVO;
import com.christianpari.nbaplayerservice.VO.Team;
import com.christianpari.nbaplayerservice.entity.Player;
import com.christianpari.nbaplayerservice.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.regex.Pattern;

@Service
@Slf4j
public class PlayerService {
  @Autowired
  private PlayerRepository repository;

  @Autowired
  private RestTemplate template;

  //GET
  public List<Player> getAllPlayers() {
    log.info("Inside getAllPlayers of PlayerService");
    return repository.findAll();
  }
  public List<Player> getPlayersByTeam(String abr) {
    List<Player> players = getAllPlayers();
    for (int idx = 0; idx < players.size(); idx++) {
      Player curPlayer = players.get(idx);
      if (curPlayer.getTeam().equals(abr)) {
        players.remove(idx--);
      }
    }
    log.info("Inside getPlayersByTeam of PlayerService");
    return players;
  }
  public List<Player> getPlayersByPosition(String pos) {
    List<Player> players = getAllPlayers();
    for (int idx = 0; idx < players.size(); idx++) {
      Player curPlayer = players.get(idx);
      if (!curPlayer.getPosition().equals(pos)) {
        players.remove(idx--);
      }
    }
    log.info("Inside getPlayersByPosition of PlayerService");
    return players;
  }
  public List<Player> getPlayersByJersey(String jersey) {
    List<Player> players = getAllPlayers();
    for (int idx = 0; idx < players.size(); idx++) {
      Player curPlayer = players.get(idx);
      if (!curPlayer.getJersey_number().equals(jersey)) {
        players.remove(idx--);
      }
    }
    log.info("Inside getPlayersByJersey of PlayerService");
    return players;
  }
  public List<Player> getPlayersByName(String name) {
    List<Player> players = getAllPlayers();
    for (int idx = 0; idx < players.size(); idx++) {
      Player curPlayer = players.get(idx);
      if (!Pattern.matches(name, curPlayer.getName())) {
        players.remove(idx--);
      }
    }
    log.info("Inside getPlayersByName of PlayerService");
    return players;
  }
  public Player getPlayerById(Integer id) {
    log.info("Inside getPlayerById of PlayerService");
    return repository.findById(id).isPresent() ? repository.getById(id) : null;
  }
  public ResponseTemplateVO getPlayerWithTeam(Integer id) {
    log.info("Inside getPlayerWithTeam of PlayerService");
    ResponseTemplateVO vo = new ResponseTemplateVO();
    Player player = getPlayerById(id);
    Team team = template.getForObject("http://NBA-TEAM-SERVICE/teams/" + player.getTeam(), Team.class);
    vo.setPlayer(player);
    vo.setTeam(team);
    return vo;
  }
}
