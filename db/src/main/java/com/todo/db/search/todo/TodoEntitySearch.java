package com.todo.db.search.todo;

import com.todo.db.domain.todo.TodoEntity;
import com.todo.db.search.PageRequestDTO;
import org.springframework.data.domain.Page;

public interface TodoEntitySearch {

    Page<TodoEntity> search1(PageRequestDTO pageRequestDTO);

}
