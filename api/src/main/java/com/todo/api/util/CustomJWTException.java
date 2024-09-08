package com.todo.api.util;

public class CustomJWTException extends RuntimeException{

    public CustomJWTException(String msg){
        super(msg);
    }
}
