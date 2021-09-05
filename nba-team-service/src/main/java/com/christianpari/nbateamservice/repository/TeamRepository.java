package com.christianpari.nbateamservice.repository;

import com.christianpari.nbateamservice.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
