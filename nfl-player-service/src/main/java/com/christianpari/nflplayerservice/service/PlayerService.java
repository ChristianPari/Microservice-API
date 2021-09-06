package com.christianpari.nflplayerservice.service;

import com.christianpari.nflplayerservice.VO.MultiPlayerTeamVO;
import com.christianpari.nflplayerservice.VO.PlayerTeamVO;
import com.christianpari.nflplayerservice.VO.Team;
import com.christianpari.nflplayerservice.entity.Player;
import com.christianpari.nflplayerservice.repository.PlayerRepository;
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
  public MultiPlayerTeamVO getPlayersByTeam(String abr) {
    MultiPlayerTeamVO vo = new MultiPlayerTeamVO();
    List<Player> players = getAllPlayers();
    for (int idx = 0; idx < players.size(); idx++) {
      Player curPlayer = players.get(idx);
      if (!curPlayer.getTeam().equals(abr)) {
        players.remove(idx--);
      }
    }
    log.info("Inside getPlayersByTeam of PlayerService");
    Team team = template.getForObject("http://NFL-TEAM-SERVICE/nfl/teams/" + abr, Team.class);
    vo.setPlayers(players);
    vo.setTeam(team);
    return vo;
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
  public PlayerTeamVO getPlayerByIdWithTeam(Integer id) {
    log.info("Inside getPlayerByIdWithTeam of PlayerService");
    PlayerTeamVO vo = new PlayerTeamVO();
    Player player = getPlayerById(id);
    Team team = template.getForObject("http://NFL-TEAM-SERVICE/nfl/teams/" + player.getTeam(), Team.class);
    vo.setPlayer(player);
    vo.setTeam(team);
    return vo;
  }
}
