package org.example.backend.model.dto.request.auth;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class SignUpRequestDto {

    @NotBlank
    String username;

    @NotBlank @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{8,13}$")
    String password;

    @NotBlank @Email
    String email;

    @NotBlank String certificationNumber;
}
