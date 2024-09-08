package com.todo.api.service.todo;

import com.todo.db.search.PageResponseDTO;
import com.todo.api.dto.todo.TodoDTO;
import com.todo.db.domain.todo.TodoEntity;
import com.todo.db.search.PageRequestDTO;
import jakarta.transaction.Transactional;

@Transactional
public interface TodoService {

    TodoDTO get(Long tno);

    Long register(TodoDTO dto);

    void modify(TodoDTO dto);

    void remove(Long tno);


    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);


    default TodoDTO entityToDTO(TodoEntity todoEntity){
        return TodoDTO.builder()
                        .tno(todoEntity.getTno())
                        .title(todoEntity.getTitle())
                        .content(todoEntity.getContent())
                        .complete(todoEntity.isComplete())
                        .dueDate(todoEntity.getDueDate())
                        .build();
    }

    default TodoEntity dtoToEntity(TodoDTO todoDTO){
        return TodoEntity.builder()
                .tno(todoDTO.getTno())
                .title(todoDTO.getTitle())
                .content(todoDTO.getContent())
                .complete(todoDTO.isComplete())
                .dueDate(todoDTO.getDueDate())
                .build();
    }

}
