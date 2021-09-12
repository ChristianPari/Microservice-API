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
    log.info("Inside getPlayersByTeam of PlayerService");
    MultiPlayerTeamVO vo = new MultiPlayerTeamVO();
    List<Player> players = repository.getPlayersByTeam(abr);
    String teamAbr = players.get(0).getTeam();
    Team team = template.getForObject("http://NFL-TEAM-SERVICE/nfl/teams/abr/" + teamAbr, Team.class);
    vo.setPlayers(players);
    vo.setTeam(team);
    return vo;
  }

  public List<Player> getPlayersByPosition(String pos) {
    log.info("Inside getPlayersByPosition of PlayerService");
    return repository.getPlayersByPosition(pos);
  }

  public List<Player> getPlayersByJersey(String jersey) {
    log.info("Inside getPlayersByJersey of PlayerService");
    return repository.getPlayersByJersey(jersey);
  }

  public List<Player> getPlayersByName(String name) {
    log.info("Inside getPlayersByName of PlayerService");
    return repository.getPlayersByName(name);
  }

  public Player getPlayerById(Integer id) {
    log.info("Inside getPlayerById of PlayerService");
    return repository.findById(id).isPresent() ? repository.getById(id) : null;
  }

  public PlayerTeamVO getPlayerByIdWithTeam(Integer id) {
    log.info("Inside getPlayerByIdWithTeam of PlayerService");
    PlayerTeamVO vo = new PlayerTeamVO();
    Player player = getPlayerById(id);
    String teamAbr = player.getTeam();
    Team team = template.getForObject("http://NFL-TEAM-SERVICE/nfl/teams/abr/" + teamAbr, Team.class);
    vo.setPlayer(player);
    vo.setTeam(team);
    return vo;
  }
}
