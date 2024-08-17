package org.example.backend.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public class ClientErrorException extends RuntimeException{
    private final HttpStatus status;

    public ClientErrorException(HttpStatus status, String message){
        super(message);
        this.status=status;
    }

    public HttpStatus getStatus(){
        return status;
    }
}
