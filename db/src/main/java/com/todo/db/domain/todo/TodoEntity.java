package com.todo.db.domain.todo;


import com.todo.db.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.security.cert.CertPathBuilder;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_todo")
public class TodoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tno;

    @Column(length = 200, nullable = false)
    private String title;

    private String content;

    private boolean complete;

    // 마감일
    private LocalDate dueDate;

    @Builder
    private TodoEntity(String title,String content,LocalDate dueDate) {
        this.title = title;
        this.content = content;
        this.dueDate = dueDate;
    }

    @Builder
    private TodoEntity(Long tno, String title,String content, boolean complete, LocalDate dueDate) {
        this.tno = tno;
        this.title = title;
        this.content = content;
        this.complete = complete;
        this.dueDate = dueDate;

    }

    public void changeTilte(String title) {
        this.title = title;
    }

    public void changeContent(String content) {
        this.content = content;
    }

    public void isComplete(boolean complete) {
        this.complete = complete;
    }

    public void changeDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }


}
