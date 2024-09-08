package com.todo.api.common.error;

public interface ErrorCodeIfs {
    Integer getHttpStatusCode();
    Integer getErrorCode();
    String getDescription();
}
