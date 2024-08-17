package org.example.backend.exception.user;

import org.example.backend.exception.ClientErrorException;
import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends ClientErrorException {

    //Client 에러 메서지 상속
    public UserAlreadyExistsException(){
        super(HttpStatus.CONFLICT,"User already exists");
    }

    public UserAlreadyExistsException(String username){
        super(HttpStatus.CONFLICT,"User with username"+ username + "already exists");
    }


}
