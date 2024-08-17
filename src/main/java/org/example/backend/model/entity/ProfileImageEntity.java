package org.example.backend.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "profile_image")

@Getter
@Setter
@ToString
public class ProfileImageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long profileImageId;

	@Column
	private String imageUrl;

	@Column
	private Long imageSize;

	@ManyToOne
	@JoinColumn(name = "profile_id")
	private ProfileEntity profile;

	@Column
	private LocalDateTime createdAt;

	@Column
	private LocalDateTime updatedAt;

}
