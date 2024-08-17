package org.example.backend.repository;

import org.example.backend.model.entity.AlarmEntity;
import org.example.backend.model.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
}
