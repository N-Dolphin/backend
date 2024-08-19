package org.example.backend.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "swipe")


@Getter
@Setter
@ToString
public class SwipeEntity extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long swipeId;

	@ManyToOne
	@JoinColumn(name = "swiper_id")
	private ProfileEntity swiper;

	@ManyToOne
	@JoinColumn(name = "swipee_id")
	private ProfileEntity swipee;

	@Column(nullable = false)
	private boolean isLiking;

}
