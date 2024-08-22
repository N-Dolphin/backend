package org.example.backend.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "\"user\"")

@Getter
@Setter
@ToString
public class UserEntity extends BaseTimeEntity implements UserDetails  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column
	private String email;

	@Column
	private String username;

	@Column
	private String loginType;

	@Column
	private String password;

	@Column
	private String role;

	@OneToOne(mappedBy = "userEntity")
	private ProfileEntity profile;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getUsername() {
		return this.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}


	public static UserEntity of(String loginType,String email,String password,String username,String role){
		var userEntity=new UserEntity();
		userEntity.setLoginType(loginType);
		userEntity.setEmail(email);
		userEntity.setPassword(password);
		userEntity.setUsername(username);
		userEntity.setRole(role);
		return userEntity;
	}
}

