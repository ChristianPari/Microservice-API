package com.christianpari.nbaplayerservice.repository;

import com.christianpari.nbaplayerservice.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
