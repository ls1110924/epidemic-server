package com.example.epidemic.component;

import com.example.epidemic.exception.HttpException;
import com.example.epidemic.exception.ServerErrorHttpException;
import com.example.epidemic.model.ErrorResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 自定义异常处理类
 */
@ControllerAdvice
public class HttpExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> errorResponse(Exception exception) {
        // 如果不是自定义的异常, 则都以服务器异常来处理
        if (!(exception instanceof HttpException)) {
            exception = new ServerErrorHttpException(exception.getMessage());
        }
        HttpException httpException = (HttpException) exception;

        ErrorResponse error = new ErrorResponse(httpException.getCode(),
                    httpException.getMessage());

        return new ResponseEntity<ErrorResponse>(error, httpException.getStatus());
    }
}
