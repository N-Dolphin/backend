package org.example.backend.repository;

import org.example.backend.model.entity.ChatRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Long> {
}
