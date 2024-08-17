package org.example.backend.model.entity;


import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "chatMessage")

@Getter
@Setter
@ToString
public class ChatMessageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long chatMessageId;

	@ManyToOne
	@JoinColumn(name = "chatroomid")
	private ChatRoomEntity chatRoomEntity;

	@ManyToOne
	@JoinColumn(name = "sender_id")
	private ProfileEntity sender;

	@Column
	private String text;

	@Column
	private LocalDateTime createdAt;

}
