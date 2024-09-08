package com.todo.api.common.exception;

import com.todo.api.common.error.ErrorCodeIfs;

public interface ApiExceptionIfs {
    ErrorCodeIfs getErrorCodeIfs();
    String getErrorDescription();
}
