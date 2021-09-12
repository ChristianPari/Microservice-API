package com.christianpari.nbaplayerservice.repository;

import com.christianpari.nbaplayerservice.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
  @Query(value = "FROM #{#entityName} WHERE team = :abr")
  List<Player> getPlayersByTeam(@Param("abr") String abr);

  @Query(value = "FROM #{#entityName} WHERE position = :pos")
  List<Player> getPlayersByPosition(@Param("pos") String pos);

  @Query(value = "FROM #{#entityName} WHERE name LIKE %:name%")
  List<Player> getPlayersByName(@Param("name") String name);

  @Query(value = "FROM #{#entityName} WHERE jersey_number = :jersey")
  List<Player> getPlayersByJersey(@Param("jersey") String jersey);
}
