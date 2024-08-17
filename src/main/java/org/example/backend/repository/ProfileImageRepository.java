package org.example.backend.repository;

import org.example.backend.model.entity.AlarmEntity;
import org.example.backend.model.entity.ProfileImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileImageRepository extends JpaRepository<ProfileImageEntity, Long> {
}
