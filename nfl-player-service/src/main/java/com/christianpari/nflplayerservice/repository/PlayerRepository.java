package com.christianpari.nflplayerservice.repository;

import com.christianpari.nflplayerservice.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
