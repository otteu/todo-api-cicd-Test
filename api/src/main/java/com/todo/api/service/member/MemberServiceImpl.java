//package com.todo.api.service.member;
//
//import com.todo.api.controller.member.model.MemberRegisterRequest;
//import com.todo.db.domain.member.Member;
//import com.todo.db.domain.member.MemberRole;
//import com.todo.db.repository.member.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//
//@RequiredArgsConstructor
//@Service
//public class MemberServiceImpl implements MemberService{
//
//    private MemberRepository memberRepository;
//
//    private PasswordEncoder passwordEncoder;
//
//    public Member register(MemberRegisterRequest request) {
//
//        Member member = Optional.ofNullable(request)
//                .map(it-> {
//                    return Member.builder()
//                            .email(request.getEmail())
//                            .pw(passwordEncoder.encode(request.getPw()))
//                            .nickname(request.getNickname())
//                            .social(request.isSocial())
//                            .build();
//                })
//                .orElseThrow(() -> new RuntimeException("UserRegisterRequest Null"));
//
//        member.addRole(MemberRole.USER);
//
//        return memberRepository.save(member);
//
//    }
//}
