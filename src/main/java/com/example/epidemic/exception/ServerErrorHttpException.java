package com.example.epidemic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerErrorHttpException extends HttpException {

    public ServerErrorHttpException(String message) {
        super(500, HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
