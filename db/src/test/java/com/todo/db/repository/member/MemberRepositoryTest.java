package com.todo.db.repository.member;

import com.todo.db.DbApplication;
import com.todo.db.domain.member.Member;
import com.todo.db.domain.member.MemberRole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = DbApplication.class)
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @DisplayName("")
    @Test
    void insert_member() {

        for(int i = 0; i < 10; i++) {
            Member member = Member.builder()
                    .email("user" +i+"@aaa.com")
                    .pw(passwordEncoder.encode("1111"))
                    .nickname("USER"+i)
                    .build();

            member.addRole(MemberRole.USER);

            if(1 > 5) {
                member.addRole(MemberRole.MANAGER);
            }

            if(i >= 8){
                member.addRole(MemberRole.ADMIN);
            }

            memberRepository.save(member);
        }


    }

}