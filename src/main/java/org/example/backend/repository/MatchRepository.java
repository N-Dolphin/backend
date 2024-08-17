package org.example.backend.repository;

import org.example.backend.model.entity.AlarmEntity;
import org.example.backend.model.entity.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<MatchEntity, Long> {
}
