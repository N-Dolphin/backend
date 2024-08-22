package org.example.backend.model.dto.request.auth;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor@Getter@Setter
public class SignInRequestDto {

    @NotBlank
    private String id;

    @NotBlank
    private String password;
}
