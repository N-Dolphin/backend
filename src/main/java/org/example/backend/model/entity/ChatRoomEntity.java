package org.example.backend.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "chatRoom")

@Getter
@Setter
@ToString

public class ChatRoomEntity extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long chatRoomId;

	@ManyToOne
	@JoinColumn(name = "match_id")
	private MatchEntity matchEntity;


}
