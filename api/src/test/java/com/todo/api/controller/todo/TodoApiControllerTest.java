//package com.todo.api.controller.todo;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.todo.api.dto.todo.TodoDTO;
//import com.todo.api.service.todo.TodoService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@WebMvcTest(controllers = TodoApiController.class)
//class TodoApiControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private TodoService todoService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @DisplayName("todo를 등록 한다.")
//    @Test
//    void todo_insert() throws Exception {
//        // given
//        boolean complete = false;
//
//        TodoDTO todo = TodoDTO.builder()
//                .title("titl01")
//                .content("content01")
//                .complete(complete)
//                .dueDate(LocalDateTime.now())
//                .build();
//
//        // when, then
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/todo")
//                .content(objectMapper.writeValueAsString(todo))
//                .contentType(MediaType.APPLICATION_JSON)
//        )
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @DisplayName("Todo 를 등록 할때 제목은 필수 입니다.")
//    @Test
//    void create_todo_validation() throws Exception {
//        boolean complete = false;
//
//        TodoDTO todo = TodoDTO.builder()
//                .title(null )
//                .content("content01")
//                .complete(complete)
//                .dueDate(LocalDateTime.now())
//                .build();
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/todo")
//                        .content(objectMapper.writeValueAsString(todo))
//                        .contentType(MediaType.APPLICATION_JSON)
//                )
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().isBadRequest());
//
//    }
//
//
//
//
//
//}