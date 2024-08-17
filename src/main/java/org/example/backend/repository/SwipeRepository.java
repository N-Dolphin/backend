package org.example.backend.repository;

import org.example.backend.model.entity.AlarmEntity;
import org.example.backend.model.entity.SwipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SwipeRepository extends JpaRepository<SwipeEntity, Long> {
}
