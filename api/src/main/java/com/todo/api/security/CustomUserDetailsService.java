//package com.todo.api.security;
//
//import com.todo.api.dto.member.MemberDTO;
//import com.todo.db.domain.member.Member;
//import com.todo.db.repository.member.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.stream.Collectors;
//
//
//@RequiredArgsConstructor
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);
//
//    private MemberRepository memberRepository;
//
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        log.info("---------loadUserByUsername-----------" + username);
//
//        Member member = memberRepository.getWithRoles(username);
//
//        if(member == null) {
//            throw new UsernameNotFoundException("Not Found");
//        }
//
//        MemberDTO memberDTO = new MemberDTO(
//                member.getEmail(),
//                member.getPw(),
//                member.getNickname(),
//                member.isSocial(),
//                member.getMemberRoleList()
//                        .stream()
//                        .map(memberRole -> memberRole.name())
//                        .collect(Collectors.toList()));
//
//
//        return memberDTO;
//    }
//
//}
