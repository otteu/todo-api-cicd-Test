package com.todo.db.repository.todo;


import com.todo.db.DbApplication;
import com.todo.db.domain.todo.TodoEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

// @ActiveProfiles("test")
@SpringBootTest(classes = DbApplication.class)
@Slf4j
class TodoRepositoryTest {

    private static final Logger log = LoggerFactory.getLogger(TodoRepositoryTest.class);

    @Autowired
    private TodoRepository todoRepository;

    @DisplayName("Test01")
    @Test
    void test01() {

        Assertions.assertNotNull(todoRepository);

        log.info(todoRepository.getClass().getName());

    }

    @DisplayName("Todo 리스트에 todo를 추가한다.")
    @Test
    void todo_insert() {
        // g

        TodoEntity todoEntity01 = createTodoEntity("title01", "complete01");
        TodoEntity todoEntity02 = createTodoEntity("title02", "complete02");

        todoRepository.saveAll(List.of(todoEntity01, todoEntity02));


        // when
        List<TodoEntity> todoEntities = todoRepository.findAll();

        // then
        assertThat(todoEntities).hasSize(2)
                .extracting("title","content")
                .containsExactlyInAnyOrder(
                        tuple("title01", "complete01"),
                        tuple("title02", "complete02")
                );
    }

    @DisplayName("Todo tno 하나를 조회 한다")
    @Test
    void todo_select() {


        Long tno = 1L;
        Optional<TodoEntity> result = todoRepository.findById(tno);
        TodoEntity todoEntity = result.orElseThrow();




    }

    @DisplayName("Todo 를 업데이를 한다")
    @Test
    void todo_update() {

        TodoEntity todoEntity = createTodoEntity("title01", "complete01");
        todoRepository.save(todoEntity);

        Long tno = 1L;

        Optional<TodoEntity> findOneTodoEntity = todoRepository.findById(tno);
        TodoEntity todoEntity01 = findOneTodoEntity.orElseThrow();

        assertThat(todoEntity01)
                .extracting("title", "content")
                .contains("title01", "complete01");

        todoEntity01.changeTilte("changeTitle01");
        todoEntity01.changeContent("changeComplete01");

        todoRepository.save(todoEntity01);

        Optional<TodoEntity> findChangeTodoEntity = todoRepository.findById(tno);
        TodoEntity todoChangeEntity01 = findChangeTodoEntity.orElseThrow();

        // then
        assertThat(todoChangeEntity01)
                .extracting("title", "content")
                .contains("changeTitle01", "changeComplete01");

    }

    @DisplayName("Todo 를 페이징하여 조회 합니다.")
    @Test
    void todo_page_select() {
        // Pageable pageable = (Pageable) PageRequest.of(0, 10, Sort.by("tno").descending());

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

        Page<TodoEntity> result = todoRepository.findAll(PageRequest.of(0, 10, Sort.by("tno").descending()));

        assertThat(result).hasSize(10);



    }


    private TodoEntity createTodoEntity(String title, String content) {
        return TodoEntity.builder()
                .title(title)
                .content(content)
                .dueDate(LocalDateTime.now())
                .build();
    }

}