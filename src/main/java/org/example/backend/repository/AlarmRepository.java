package org.example.backend.repository;

import org.example.backend.model.entity.AlarmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlarmRepository extends JpaRepository<AlarmEntity, Long> {
}
