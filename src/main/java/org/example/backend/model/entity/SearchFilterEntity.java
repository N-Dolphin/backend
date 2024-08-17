package org.example.backend.model.entity;


import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "search_filter")

@Getter
@Setter
@ToString
public class SearchFilterEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long searchFilterId;

	@Column
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column
	private Long minAge;

	@Column
	private Long maxAge;

	@Column
	private Long searchDist;

	@ManyToOne
	@JoinColumn(name = "profile_id")
	private ProfileEntity profile;

	@Column
	private LocalDateTime createdAt;

	@Column
	private LocalDateTime updatedAt;

}
