package com.christianpari.nbateamservice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "team")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Team {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String team_name;
  private String team_abr;
  private String conference;
  private String division;
}
