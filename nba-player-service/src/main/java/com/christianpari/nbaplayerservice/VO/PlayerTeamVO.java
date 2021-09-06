package com.christianpari.nbaplayerservice.VO;

import com.christianpari.nbaplayerservice.entity.Player;
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
