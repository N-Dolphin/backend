package org.example.backend.service.implement;


import lombok.RequiredArgsConstructor;
import org.example.backend.model.dto.request.auth.EmailCertificationRequestDto;
import org.example.backend.model.dto.request.auth.CheckCertificationRequestDto;
import org.example.backend.model.dto.request.auth.IdCheckRequestDto;
import org.example.backend.model.dto.request.auth.SignInRequestDto;
import org.example.backend.model.dto.request.auth.SignUpRequestDto;
import org.example.backend.model.dto.response.auth.EmailCertificationResponseDto;
import org.example.backend.model.dto.response.ResponseDto;
import org.example.backend.model.dto.response.auth.CheckCertificationResponseDto;
import org.example.backend.model.dto.response.auth.IdCheckResponseDto;
import org.example.backend.model.dto.response.auth.SignInResponseDto;
import org.example.backend.model.dto.response.auth.SignUpResponseDto;
import org.example.backend.model.entity.CertificationEntity;
import org.example.backend.model.entity.UserEntity;
import org.example.backend.provider.EmailProvider;
import org.example.backend.provider.JwtProvider;
import org.example.backend.repository.CertificationRepository;
import org.example.backend.repository.UserRepository;
import org.example.backend.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {


    private final UserRepository userRepository;
    private final EmailProvider emailProvider;
    private final CertificationRepository certificationRepository;
    private final JwtProvider jwtProvider;

    private  PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super IdCheckResponseDto> idCheck(IdCheckRequestDto dto) {

        try{
            String username= dto.getId();
            boolean isExistId= userRepository.existsByUsername(username);
            if (isExistId) return IdCheckResponseDto.duplicateId();

        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return IdCheckResponseDto.success();
    }

    @Override
    public ResponseEntity<? super EmailCertificationResponseDto> emailCertification(EmailCertificationRequestDto dto) {

            try{
                String username=dto.getId();
                String email=dto.getEmail();

                boolean isExistId= userRepository.existsByUsername(username);
                if (isExistId) return EmailCertificationResponseDto.duplicateId();

                String certificationNumber= CertificationNumber.getCertificationNumber();

                boolean isSuccessed=emailProvider.sendCertification(email,certificationNumber);

                if (!isSuccessed)
                    return EmailCertificationResponseDto.mailSendFail();

                 CertificationEntity certificationEntity= new CertificationEntity(username,email,certificationNumber);
                 certificationRepository.save(certificationEntity);

            } catch (Exception e){
                e.printStackTrace();
                return ResponseDto.databaseError();
            }

            return EmailCertificationResponseDto.success();
    }

    @Override
    public ResponseEntity<? super CheckCertificationResponseDto> checkCertification(CheckCertificationRequestDto dto) {
        try{

            String email=dto.getEmail();
            String certificationNumber= dto.getCertificationNumber();

            CertificationEntity certificationEntity= certificationRepository.findByEmail(email);

            if (certificationEntity==null){

                return CheckCertificationResponseDto.certificationFail();

            }
            boolean isMatched= certificationEntity.getEmail().equals(email)&& certificationEntity.getCertificationNumber().equals(certificationNumber);

            if (!isMatched){
                return CheckCertificationResponseDto.certificationFail();
            }


        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return CheckCertificationResponseDto.success();
    }

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {

        try{
            String username=dto.getUsername();

            boolean isExistId= userRepository.existsByUsername(username);
            if (isExistId) return EmailCertificationResponseDto.duplicateId();

            String email= dto.getEmail();
            String certificationNumber= dto.getCertificationNumber();

            CertificationEntity certificationEntity= certificationRepository.findByEmail(email);

            boolean isMatched= certificationEntity.getEmail().equals(email) &&
                    certificationEntity.getCertificationNumber().equals(certificationNumber);

            if (!isMatched){
                return SignUpResponseDto.certificationFail();
            }
            String password= dto.getPassword();
            String encodedPassword= passwordEncoder.encode(password);

            dto.setPassword(encodedPassword);

            UserEntity userEntity= UserEntity.of("Base",email,encodedPassword,username,"USER");
            userRepository.save(userEntity);

         //   certificationRepository.deleteByUsername(username);

        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignUpResponseDto.success();
    }

    @Override
    public    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto){
    String token= null;

        try{

            String userId= dto.getId();

            UserEntity userEntity= userRepository.findByUsername(userId);

            if(userEntity==null){
                return SignInResponseDto.signInFail();

            }

            String password= dto.getPassword();
            String encodedPassword= userEntity.getPassword();

            boolean isMatched= passwordEncoder.matches(password,encodedPassword);
            if (!isMatched){

                return SignInResponseDto.signInFail();

            }
            token= jwtProvider.create(userId);

        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignInResponseDto.success(token);
    }


    private static class CertificationNumber {

        public static String getCertificationNumber(){
            String certificationNumber= "";

            for (int count=0; count<4;count++)
                certificationNumber += (int)(Math.random()*10);

            return certificationNumber;
        }
    }

}
