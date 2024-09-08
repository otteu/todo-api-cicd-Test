package com.todo.api.service.todo;

import com.todo.db.search.PageResponseDTO;
import com.todo.api.dto.todo.TodoDTO;
import com.todo.db.domain.todo.TodoEntity;
import com.todo.db.repository.todo.TodoRepository;
import com.todo.db.search.PageRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
@Log4j2
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;


    @Override
    public TodoDTO get(Long tno) {

        Optional<TodoEntity> findOne = todoRepository.findById(tno);
        TodoEntity todoEntity = findOne.orElseThrow();
        TodoDTO todoDTO = entityToDTO(todoEntity);

        return todoDTO;
    }

    @Transactional
    @Override
    public Long register(TodoDTO dto) {

        TodoEntity todoEntity = dtoToEntity(dto);

        TodoEntity todoEntity1 = todoRepository.save(todoEntity);

        return todoEntity1.getTno();
    }

    @Transactional
    @Override
    public void modify(TodoDTO dto) {
        Optional<TodoEntity> findOne = todoRepository.findById(dto.getTno());

        TodoEntity todoEntity = findOne.orElseThrow();

        todoEntity.changeTilte(dto.getTitle());
        todoEntity.changeContent(dto.getContent());
        todoEntity.isComplete(dto.isComplete());
        todoEntity.changeDueDate(dto.getDueDate());

        todoRepository.save(todoEntity);
    }

    @Transactional
    @Override
    public void remove(Long tno) {

        todoRepository.deleteById(tno);

    }

    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {

        // JPA
        Page<TodoEntity> result = todoRepository.search1(pageRequestDTO);

        List<TodoDTO> dtoList = result.get().map(todoEntity -> entityToDTO(todoEntity))
                .collect(Collectors.toList());

        return new PageResponseDTO<TodoDTO>(dtoList, pageRequestDTO, result.getTotalElements());
    }
}
