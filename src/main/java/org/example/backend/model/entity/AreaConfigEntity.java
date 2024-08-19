package org.example.backend.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "area_config")


@Getter
@Setter
@ToString
public class AreaConfigEntity extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long areaConfigId;

	@Column
	private String address;

	@Column
	private Double lat;

	@Column
	private Double lon;

	@Column
	private Long searchRange;

	@Column
	private String geometry;

	@ManyToOne
	@JoinColumn(name = "profile_id")
	private ProfileEntity profile;


}
