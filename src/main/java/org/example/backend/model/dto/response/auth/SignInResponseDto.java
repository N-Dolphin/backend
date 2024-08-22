package org.example.backend.model.dto.response.auth;


import lombok.Getter;
import org.example.backend.model.dto.response.ResponseCode;
import org.example.backend.model.dto.response.ResponseDto;
import org.example.backend.model.dto.response.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class SignInResponseDto extends ResponseDto{

    private String token;
    private int expiredTime;

    private SignInResponseDto(String token){
        super();
        this.token=token;
        this.expiredTime= 3600;
    }

    public static ResponseEntity<SignInResponseDto> success(String token){
        SignInResponseDto responseBody= new SignInResponseDto(token);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    public static ResponseEntity<ResponseDto> signInFail(){
        ResponseDto responseBody= new ResponseDto(ResponseCode.SIGN_IN_FAIL, ResponseMessage.SIGN_IN_FAIL);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
    }

}
