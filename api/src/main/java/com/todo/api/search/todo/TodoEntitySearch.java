package com.todo.api.search.todo;

import com.todo.api.domain.todo.TodoEntity;
import com.todo.api.search.PageRequestDTO;
import org.springframework.data.domain.Page;

public interface TodoEntitySearch {

    Page<TodoEntity> search1(PageRequestDTO pageRequestDTO);

}
