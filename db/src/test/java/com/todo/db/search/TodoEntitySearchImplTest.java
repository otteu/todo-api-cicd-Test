package com.todo.db.search;

import com.todo.db.DbApplication;
import com.todo.db.domain.todo.TodoEntity;
import com.todo.db.repository.todo.TodoRepository;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = DbApplication.class)
@Slf4j
@Rollback
class TodoEntitySearchImplTest {

    private static final Logger log = LoggerFactory.getLogger(TodoEntitySearchImplTest.class);

    @Autowired
    private TodoRepository todoRepository;


    /*
    @DisplayName("QueryDsl 을 사용 하여 search 해본다.")
    @Test
    void search1_test() {

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

        todoRepository.search1();

    }*/


    private TodoEntity createTodoEntity(String title, String content) {
        return TodoEntity.builder()
                .title(title)
                .content(content)
                .dueDate(LocalDateTime.now())
                .build();
    }

}