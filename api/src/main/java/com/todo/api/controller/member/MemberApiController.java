//package com.todo.api.controller.member;
//
//
//import com.todo.api.controller.member.model.MemberRegisterRequest;
//import com.todo.api.dto.member.MemberDTO;
//import com.todo.api.service.member.MemberServiceImpl;
//import com.todo.db.domain.member.Member;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/api/member")
//public class MemberApiController {
//
//
//    private MemberServiceImpl memberService;
//
//    @PostMapping("/register")
//    public Member register(@Valid @RequestBody MemberRegisterRequest request ) {
//
//        Member member = memberService.register(request);
//
//
//
//        return member;
//    }
//
//
//}
