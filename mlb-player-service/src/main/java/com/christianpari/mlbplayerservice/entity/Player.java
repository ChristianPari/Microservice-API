package com.christianpari.mlbplayerservice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "mlb_player")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Player {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String team;
  private String jersey_number;
  private String name;
  private String position;
}
