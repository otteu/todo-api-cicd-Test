package com.todo.api.repository.todo;

import com.todo.api.domain.todo.TodoEntity;
import com.todo.api.search.todo.TodoEntitySearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long>, TodoEntitySearch {


}
