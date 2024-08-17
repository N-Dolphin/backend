package org.example.backend.repository;

import org.example.backend.model.entity.AreaConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaConfigRepository extends JpaRepository<AreaConfigEntity, Long> {
}
