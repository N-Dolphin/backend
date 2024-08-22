package org.example.backend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.backend.model.dto.request.auth.EmailCertificationRequestDto;
import org.example.backend.model.dto.request.auth.CheckCertificationRequestDto;
import org.example.backend.model.dto.request.auth.IdCheckRequestDto;
import org.example.backend.model.dto.request.auth.SignInRequestDto;
import org.example.backend.model.dto.request.auth.SignUpRequestDto;
import org.example.backend.model.dto.response.auth.EmailCertificationResponseDto;
import org.example.backend.model.dto.response.auth.CheckCertificationResponseDto;
import org.example.backend.model.dto.response.auth.IdCheckResponseDto;
import org.example.backend.model.dto.response.auth.SignInResponseDto;
import org.example.backend.model.dto.response.auth.SignUpResponseDto;
import org.example.backend.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/id-check")
    public ResponseEntity<? super IdCheckResponseDto> idCheck(
            @RequestBody @Valid IdCheckRequestDto requestBody
    )
    {
        ResponseEntity<? super IdCheckResponseDto> response= authService.idCheck(requestBody);

        return response;
    }


    @PostMapping("/email-certification")
    public ResponseEntity<? super EmailCertificationResponseDto> emailCertification(
            @RequestBody @Valid EmailCertificationRequestDto requestBody
    )
    {
        ResponseEntity<? super EmailCertificationResponseDto> response= authService.emailCertification(requestBody);

        return response;
    }


    @PostMapping("/check-certification")
    public ResponseEntity<? super CheckCertificationResponseDto> checkCertification(
            @RequestBody @Valid CheckCertificationRequestDto requestBody
    )
    {
        ResponseEntity<? super CheckCertificationResponseDto> response= authService.checkCertification(requestBody);

        return response;
    }


    @PostMapping("/sign-up")
    public ResponseEntity<? super SignUpResponseDto> signUp(
            @RequestBody @Valid SignUpRequestDto requestBody
    ){
        ResponseEntity<? super SignUpResponseDto> response= authService.signUp(requestBody);
        return response;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<? super SignInResponseDto> signIn(
            @RequestBody @Valid SignInRequestDto requestBody
    ){
        ResponseEntity<? super SignInResponseDto> response= authService.signIn(requestBody);
        return response;
    }
}
