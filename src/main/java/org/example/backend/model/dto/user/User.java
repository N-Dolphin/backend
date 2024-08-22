package org.example.backend.model.dto.user;

import org.example.backend.model.entity.UserEntity;
import org.example.backend.model.entity.enums.Role;

public record User(
        Long userId,
        String username,
        String email
){
    public static User from(UserEntity userEntity){
        return new User(
                userEntity.getUserId(),
                userEntity.getUsername(),
                userEntity.getEmail());
    }
}