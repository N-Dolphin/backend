package org.example.backend.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "match")
@Getter
@Setter
@ToString

public class MatchEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long matchId;

	@ManyToOne
	@JoinColumn(name = "user1_id")
	private ProfileEntity user1;

	@ManyToOne
	@JoinColumn(name = "user2_id")
	private ProfileEntity user2;

	@Column
	private LocalDateTime createdAt;

}
