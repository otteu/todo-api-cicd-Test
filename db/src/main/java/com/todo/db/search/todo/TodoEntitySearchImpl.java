package com.todo.db.search.todo;

import com.querydsl.jpa.JPQLQuery;
import com.todo.db.domain.todo.QTodoEntity;
import com.todo.db.domain.todo.TodoEntity;
import com.todo.db.search.PageRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;


public class TodoEntitySearchImpl extends QuerydslRepositorySupport implements TodoEntitySearch {


    private static final Logger log = LoggerFactory.getLogger(TodoEntitySearchImpl.class);

    public TodoEntitySearchImpl() {
        super(TodoEntity.class);
    }

    @Override
    public Page<TodoEntity> search1(PageRequestDTO pageRequestDTO) {

        log.info("search1-------------------------");

        QTodoEntity qTodoEntity = QTodoEntity.todoEntity;

        JPQLQuery<TodoEntity> query = from(qTodoEntity);

        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPage() -1,
                pageRequestDTO.getSize(),
                Sort.by("tno").descending()
        );

        this.getQuerydsl().applyPagination(pageable, query);

        List<TodoEntity> list = query.fetch();
        long total = query.fetchCount();

        return new PageImpl<>(list, pageable, total);
    }



}
