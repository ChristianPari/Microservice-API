package com.christianpari.mlbplayerservice.repository;

import com.christianpari.mlbplayerservice.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
