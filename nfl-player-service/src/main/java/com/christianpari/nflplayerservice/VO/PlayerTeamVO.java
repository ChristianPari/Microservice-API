package com.christianpari.nflplayerservice.VO;

import com.christianpari.nflplayerservice.entity.Player;
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
