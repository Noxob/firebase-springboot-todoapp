package com.ismailsamirusta.todoapp.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ismailsamirusta.todoapp.model.Todo;
import com.ismailsamirusta.todoapp.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	private TodoRepository todoRepository;
	
	private final String TODO_ID_PREFIX = "TODO:";
	
	@Override
	public Todo save(Todo todo) throws Exception {
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String id =TODO_ID_PREFIX + todo.getTitle().replace(" ", "_")+":"+user;
		Todo tempTodo = todoRepository.findById(id).block();
		
		if(todo.getId()==null || todo.getId().isEmpty()) {
			if(tempTodo != null) {
				throw new Exception("You already have a todo with the same name!");
			}else {
				todo.setId(id);
			}
		}
		if(todo.getCreated()==null) {
			todo.setCreated(new Date());
		}else {
			todo.setUpdated(new Date());
		}
		if(todo.getUser()==null || todo.getUser().isEmpty()) {
			todo.setUser(user);
		}else if (!todo.getUser().equals(user)) {
			throw new Exception("You can only change your own todos!");
		}
		
		return todoRepository.save(todo).block();
	}
	
	@Override
	public List<Todo> getAllTodos() {
		return (List<Todo>) todoRepository.findAll().buffer().blockFirst();
	}

	@Override
	public List<Todo> getMyTodos() {
		return todoRepository.findByUserOrderByDueAsc(SecurityContextHolder.getContext().getAuthentication().getName()).buffer().blockFirst();
	}

	@Override
	public List<Todo> getTodosByComplete(boolean complete) {
		return todoRepository.findByComplete(complete).buffer().blockFirst();
	}

	@Override
	public boolean removeTodoById(String id) {
		todoRepository.deleteById(id).block();
		return true;
	}

}
