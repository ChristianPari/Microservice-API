package com.christianpari.mlbteamservice.repository;

import com.christianpari.mlbteamservice.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
