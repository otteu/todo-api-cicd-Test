package com.todo.api.dto.todo;



import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

    private Long tno;

    // @NotNull(message = "제목은 필수 입니다.")
    private String title;

    // @NotNull(message = "내용은 필수 입니다.")
    private String content;

    private boolean complete;
    // 마감일
    // private LocalDateTime dueDate;

    private LocalDate dueDate;

}
