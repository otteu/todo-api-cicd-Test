package com.todo.api.service.member;

import com.todo.api.controller.member.model.MemberRegisterRequest;
import com.todo.db.domain.member.Member;

public interface MemberService {

    public Member register(MemberRegisterRequest request);

}
