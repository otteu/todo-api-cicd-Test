package com.todo.api.controller.member.model;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberRegisterRequest {

    @NotBlank
    private String email;
    @NotBlank
    private String pw;
    @NotBlank
    private String nickname;
    @NotBlank
    private boolean social;

}
