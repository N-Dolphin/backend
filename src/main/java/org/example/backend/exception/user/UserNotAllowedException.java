package org.example.backend.exception.user;

import org.example.backend.exception.ClientErrorException;
import org.springframework.http.HttpStatus;

public class UserNotAllowedException extends ClientErrorException {

    //Client 에러 메서지 상속
    public UserNotAllowedException(){
        super(HttpStatus.FORBIDDEN,"User not allowed");
    }



}
