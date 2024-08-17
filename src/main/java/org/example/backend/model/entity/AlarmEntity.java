package org.example.backend.model.entity;


import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "alarm")

@Getter
@Setter
@ToString
public class AlarmEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long alarmId;

	@ManyToOne
	@JoinColumn(name = "profile_id")
	private ProfileEntity profile;

	@Column
	private String alarmText;

	@Column
	private Boolean isRead;

	@Column
	private LocalDateTime createdAt;

}
