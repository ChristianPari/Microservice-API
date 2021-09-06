package com.christianpari.mlbplayerservice.VO;

import com.christianpari.mlbplayerservice.entity.Player;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PlayerTeamVO {
  private Player player;
  private Team team;
}
