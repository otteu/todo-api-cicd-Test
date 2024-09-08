package com.todo.api.service.todo;

import com.todo.db.domain.member.Member;
import com.todo.db.domain.member.MemberRole;
import com.todo.db.repository.member.MemberRepository;
import com.todo.db.search.PageResponseDTO;
import com.todo.api.dto.todo.TodoDTO;
import com.todo.db.domain.todo.TodoEntity;
import com.todo.db.repository.todo.TodoRepository;
import com.todo.db.search.PageRequestDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
class TodoServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(TodoServiceImplTest.class);
    @Autowired
    private TodoService todoService;

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("하나를 조회 하여 DTO 객체로 반환 받는다.")
    @Test
    void get_DTO() {
        TodoEntity todoEntity = createTodoEntity("title01", "content01");
        Long tno = 1L;

        todoRepository.save(todoEntity);

        TodoDTO todoDTO = todoService.get(tno);
        // then
        assertThat(todoDTO)
                .extracting("title", "content")
                .contains("title01", "content01");

    }

    @DisplayName("todoDTO를 받아서 TodoEntity로 변경 하여 저장 한다.")
    @Test
    void register() {

        TodoDTO todoDTO = createTodoDTO("title01", "content01");

        Long saveTno = todoService.register(todoDTO);
        TodoDTO findTodoDTO = todoService.get(saveTno);

        assertThat(findTodoDTO)
                .extracting("title", "content")
                .contains("title01", "content01");

    }

    @DisplayName("todoDTO를 받아서 TodoEntity로 변경 하여 저장 한다.")
    @Test
    void modify() {

        TodoEntity todoEntity = createTodoEntity("title01", "content01");
        todoRepository.save(todoEntity);

        Long tno = 1L;
        TodoDTO todoDTO = createTodoDTO("chagneTitle01", "changeContent01");
        todoDTO.setTno(tno);
        todoService.modify(todoDTO);

        Optional<TodoEntity> findTodoEntityOptional = todoRepository.findById(tno);
        TodoEntity findTodoEntity = findTodoEntityOptional.orElseThrow();

        assertThat(findTodoEntity)
                .extracting("title", "content")
                .contains("chagneTitle01", "changeContent01");

    }

    @DisplayName("todoDTO를 받아서 TodoEntity로 변경 하여 저장 한다.")
    @Test
    void remove() {

        TodoDTO todoDTO = createTodoDTO("title01", "content01");

        Long saveTno = todoService.register(todoDTO);
        TodoDTO findTodoDTO = todoService.get(saveTno);

        assertThat(findTodoDTO)
                .extracting("title", "content")
                .contains("title01", "content01");

    }


    @DisplayName("페이징을 처리 해본다.")
    @Test
    void page() {

        TodoEntity todoEntity01 = createTodoEntity("title01", "complete01");
        TodoEntity todoEntity02 = createTodoEntity("title02", "complete02");
        TodoEntity todoEntity03 = createTodoEntity("title03", "complete03");
        TodoEntity todoEntity04 = createTodoEntity("title04", "complete04");
        TodoEntity todoEntity05 = createTodoEntity("title05", "complete05");
        TodoEntity todoEntity06 = createTodoEntity("title06", "complete06");
        TodoEntity todoEntity07 = createTodoEntity("title07", "complete07");
        TodoEntity todoEntity08 = createTodoEntity("title08", "complete08");
        TodoEntity todoEntity09 = createTodoEntity("title09", "complete09");
        TodoEntity todoEntity10 = createTodoEntity("title10", "complete10");
        TodoEntity todoEntity11 = createTodoEntity("title11", "complete11");


        todoRepository.saveAll(List.of(
                        todoEntity01, todoEntity02, todoEntity03, todoEntity04,todoEntity05,
                        todoEntity06, todoEntity07, todoEntity08, todoEntity09,todoEntity10,
                        todoEntity11
                )
        );


        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();

        PageResponseDTO<TodoDTO> pageList = todoService.getList(pageRequestDTO);

        System.out.println(pageList);


    }

//    Test 목정으로 진행
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @DisplayName("")
//    @Test
//    void insert_member() {
//
//        for(int i = 0; i < 10; i++) {
//            Member member = Member.builder()
//                    .email("user" +i+"@aaa.com")
//                    .pw(passwordEncoder.encode("1111"))
//                    .nickname("USER"+i)
//                    .build();
//
//            member.addRole(MemberRole.USER);
//
//            if(1 > 5) {
//                member.addRole(MemberRole.MANAGER);
//            }
//
//            if(i >= 8){
//                member.addRole(MemberRole.ADMIN);
//            }
//
//            memberRepository.save(member);
//        }
//
//
//    }



    private TodoDTO createTodoDTO(String title, String content) {
        return TodoDTO.builder()
                .title(title)
                .content(content)
                .dueDate(LocalDateTime.now())
                .build();
    }

    private TodoEntity createTodoEntity(String title, String content) {
        return TodoEntity.builder()
                .title(title)
                .content(content)
                .dueDate(LocalDateTime.now())
                .build();
    }

}