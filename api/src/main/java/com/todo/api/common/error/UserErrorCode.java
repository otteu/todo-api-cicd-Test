package com.todo.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserErrorCode implements ErrorCodeIfs{

    USER_ERROR_CODE(400, 1404, "사용자를 찾을 수 없음"),
    ;

    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;

    @Override
    public Integer getHttpStatusCode() {
        return this.httpStatusCode;
    }

    @Override
    public Integer getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
