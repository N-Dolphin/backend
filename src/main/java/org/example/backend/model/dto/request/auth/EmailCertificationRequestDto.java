package org.example.backend.model.dto.request.auth;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class EmailCertificationRequestDto {
    @NotBlank String id;
    @NotBlank @Email String email;
}



