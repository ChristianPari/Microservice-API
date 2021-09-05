package com.christianpari.nflteamservice.repository;

import com.christianpari.nflteamservice.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
