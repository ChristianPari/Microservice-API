package com.christianpari.mlbplayerservice.VO;

import com.christianpari.mlbplayerservice.entity.Player;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
  private Player player;
  private Team team;
}
