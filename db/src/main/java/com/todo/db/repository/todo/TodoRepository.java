package com.todo.db.repository.todo;

import com.todo.db.domain.todo.TodoEntity;
import com.todo.db.search.todo.TodoEntitySearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long>, TodoEntitySearch {


}
