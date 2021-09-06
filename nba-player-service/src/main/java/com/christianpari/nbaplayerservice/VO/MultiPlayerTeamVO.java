package com.christianpari.nbaplayerservice.VO;

import com.christianpari.nbaplayerservice.entity.Player;
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