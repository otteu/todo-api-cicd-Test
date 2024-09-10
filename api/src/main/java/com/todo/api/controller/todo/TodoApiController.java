package com.todo.api.controller.todo;

import com.todo.api.common.api.Api;
import com.todo.api.common.error.UserErrorCode;
import com.todo.api.domain.todo.TodoEntity;
import com.todo.api.repository.todo.TodoRepository;
import com.todo.api.search.PageRequestDTO;
import com.todo.api.search.PageResponseDTO;
import com.todo.api.service.todo.TodoService;

import com.todo.api.dto.todo.TodoDTO;

import lombok.RequiredArgsConstructor;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/todo")
public class TodoApiController {

    private final TodoRepository todoRepository;

    private final TodoService todoService;



    @GetMapping("/")
    public String index() {
        return "Hello World !!";
    }

    @GetMapping("/{tno}")
    public TodoDTO get(@PathVariable("tno") Long tno){

        return todoService.get(tno);
    }

    // @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/list")
    public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO){

        return todoService.getList(pageRequestDTO);

    }

    @PostMapping("/")
    public Map<String, Long> register(@RequestBody TodoDTO dto){

        Long tno = todoService.register(dto);

        return  Map.of("TNO", tno);
    }

    @PutMapping("/{tno}")
    public Map<String, String> modify(@PathVariable("tno") Long tno,
                                      @RequestBody TodoDTO todoDTO) {
        todoDTO.setTno(tno);

        todoService.modify(todoDTO);

        return Map.of("RESULT", "SUCCESS");
    }

    @DeleteMapping("/{tno}")
    public Map<String, String> remove(@PathVariable Long tno){
        todoService.remove(tno);

        return Map.of("RESULT", "SUCCESS");
    }





    // TEST INSERT
    @GetMapping("")
    public void save(){
        String title = "title01";
        String content = "complate01";
        LocalDateTime dateTime = LocalDateTime.now();

        TodoEntity todoEntity = TodoEntity.builder()
                .title(title)
                .content(content)
                .dueDate(dateTime)
                .build();

        todoRepository.save(todoEntity);
    }



    @GetMapping("/api/{tno}")
    public Api<TodoEntity> me2(@PathVariable Long tno ){

        Optional<TodoEntity> findResult =  todoRepository.findById(tno);
        TodoEntity body = findResult.orElseThrow();

        TodoDTO todoDTO = TodoDTO.builder()
                .tno(body.getTno())
                .title(body.getTitle())
                .content(body.getContent())
                .complete(body.isComplete())
                .dueDate(body.getDueDate())
                .build();

        Api api = Api.OK(todoDTO);

        return api;
    }

    @GetMapping("/error")
    public Api<Object> error(){
        return Api.ERROR(UserErrorCode.USER_ERROR_CODE);
    }

    @GetMapping("/GlobalError")
    public Api<Object> GlobalError(){


        Integer.parseInt("h");

        return Api.ERROR(UserErrorCode.USER_ERROR_CODE);
    }


}
