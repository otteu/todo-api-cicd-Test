package com.todo.db.search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

// 상속을 할 경우
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageRequestDTO {

    @Builder.Default
    private int page = 1;

    @Builder.Default
    private int size = 10;



}
