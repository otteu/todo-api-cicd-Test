package com.todo.api.exceptionhandler;

import com.todo.api.common.api.Api;
import com.todo.api.common.error.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Order(value = Integer.MAX_VALUE)
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Api<Object>> exception(Exception exception){
        log.error("", exception);

        return ResponseEntity
                .status(500)
                .body(
                        Api.ERROR(ErrorCode.SERVER_ERROR)
                );
    }

}
