package com.christianpari.nflplayerservice.VO;

import com.christianpari.nflplayerservice.entity.Player;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MultiPlayerTeamVO {
  private List<Player> players;
  private Team team;
}