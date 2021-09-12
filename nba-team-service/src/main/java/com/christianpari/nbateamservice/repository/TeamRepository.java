package com.christianpari.nbateamservice.repository;

import com.christianpari.nbateamservice.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {
  @Query(value = "FROM #{#entityName} WHERE name LIKE %:name")
  List<Team> getTeamsByName(@Param("name") String name);

  @Query(value = "FROM #{#entityName} WHERE team_abr = :abr")
  Team getTeamByAbr(@Param("abr") String abr);

  @Query(value = "FROM #{#entityName} WHERE team_abr LIKE %:abr%")
  List<Team> getTeamsByAbr(@Param("abr") String abr);
}
