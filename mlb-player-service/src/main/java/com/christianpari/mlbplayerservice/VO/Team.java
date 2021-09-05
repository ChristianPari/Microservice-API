package com.christianpari.mlbplayerservice.VO;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Team {
  private int id;
  private String team_name;
  private String team_abr;
  private String conference;
  private String division;
}
