package com.todo.api.exceptionhandler;

import com.todo.api.common.api.Api;
import com.todo.api.common.exception.ApiException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;


@RestControllerAdvice
@Order(value = Integer.MAX_VALUE)
public class ApiExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(BindException.class)
    public ResponseEntity<Object> bindException(BindException e, ApiException apiException) {



        var errorCode = apiException.getErrorCodeIfs();

        return ResponseEntity
                .status(errorCode.getHttpStatusCode())
                // .body(Api.ERROR(errorCode, e.getBindingResult().getAllErrors().get(0)));
                .body(Api.ERROR(errorCode, apiException.getErrorDescription()));
    }

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<Api<Object>> apiException( ApiException apiException ){

        log.error("", apiException);

        var errorCode = apiException.getErrorCodeIfs();

        return ResponseEntity
                .status(errorCode.getHttpStatusCode())
                .body(Api.ERROR(errorCode, apiException.getErrorDescription()));
    }

}
