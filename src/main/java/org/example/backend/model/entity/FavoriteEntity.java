package org.example.backend.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "favorite")

@Getter
@Setter
@ToString
public class FavoriteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long favoriteId;

	@ManyToOne
	@JoinColumn(name = "profile_id")
	private ProfileEntity profile;

	@Column
	private String field;

}
