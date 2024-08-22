package org.example.backend.service;


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
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<? super IdCheckResponseDto> idCheck(IdCheckRequestDto dto);
    ResponseEntity<? super EmailCertificationResponseDto> emailCertification(EmailCertificationRequestDto dto);
    ResponseEntity<? super CheckCertificationResponseDto> checkCertification(CheckCertificationRequestDto dto);
    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}
