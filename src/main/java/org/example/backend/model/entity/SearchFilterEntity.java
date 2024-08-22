package org.example.backend.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.backend.model.entity.enums.Gender;

@Entity
@Table(name = "search_filter")

@Getter
@Setter
@ToString
public class SearchFilterEntity extends BaseTimeEntity {
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



}
