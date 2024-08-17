package org.example.backend.repository;

import org.example.backend.model.entity.AlarmEntity;
import org.example.backend.model.entity.SearchFilterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchFilterRepository extends JpaRepository<SearchFilterEntity, Long> {
}
