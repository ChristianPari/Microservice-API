package com.christianpari.nflplayerservice.repository;

import com.christianpari.nflplayerservice.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

// HOW TO ADD A NEW PLAYER TO DB WITH USE OF A QUERY
//  @Transactional
//  @Modifying
//  @Query(value = "INSERT INTO player (jersey_number, name, position, team) " +
//      "VALUES (:jersey, :name, :pos, :team)",
//    nativeQuery = true)
//  void addNewPlayer(
//    @Param("name") String name,
//    @Param("pos") String pos,
//    @Param("jersey") String jersey,
//    @Param("team") String team
//  );
}
