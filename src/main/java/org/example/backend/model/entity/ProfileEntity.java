package org.example.backend.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.backend.model.entity.enums.Gender;

import java.util.List;

@Entity
@Table(name = "profile")

@Getter
@Setter
//@ToString

public class ProfileEntity extends BaseTimeEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long profileId;

	@OneToOne
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;

	@Column
	private String nickname;

	@Column
	private String selfIntroduce;

	@Column
	private Long age;

	@Enumerated(EnumType.STRING)
	@Column
	private Gender gender;


	@OneToMany(mappedBy = "profile")
	private List<ProfileImageEntity> profileImages;

	@OneToMany(mappedBy = "swiper")
	private List<SwipeEntity> swipesSent;

	@OneToMany(mappedBy = "swipee")
	private List<SwipeEntity> swipesReceived;

	@OneToMany(mappedBy = "profile")
	private List<AreaConfigEntity> areaConfigs;

	@OneToMany(mappedBy = "user1")
	private List<MatchEntity> matchesAsUser1;

	@OneToMany(mappedBy = "user2")
	private List<MatchEntity> matchesAsUser2;

	@OneToMany(mappedBy = "sender")
	private List<ChatMessageEntity> chatMessages;

	@OneToMany(mappedBy = "profile")
	private List<FavoriteEntity> favorites;

	@OneToMany(mappedBy = "profile")
	private List<AlarmEntity> alarms;

}

