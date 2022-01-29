package com.ismailsamirusta.todoapp.repository;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;

import com.ismailsamirusta.todoapp.model.Todo;

import reactor.core.publisher.Flux;

public interface TodoRepository extends FirestoreReactiveRepository<Todo> {
    Flux<Todo> findByTitle(String title);
    Flux<Todo> findByTitleContaining(String title);
    Flux<Todo> findByDescriptionContaining(String description);
    Flux<Todo> findByComplete(boolean complete);
    Flux<Todo> findByDueLessThan(DateTime date);
    Flux<Todo> findByDueGreaterThan(DateTime date);
    Flux<Todo> findByUser(String user);
    Flux<Todo> findByUserOrderByDueAsc(String user);
}
