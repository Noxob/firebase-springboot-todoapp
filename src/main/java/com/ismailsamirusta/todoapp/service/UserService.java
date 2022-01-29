package com.ismailsamirusta.todoapp.service;

import com.ismailsamirusta.todoapp.model.AppUser;

import reactor.core.publisher.Flux;

public interface UserService {
	
	public AppUser addUser(AppUser user) throws Exception;
	
	public AppUser findByUsername(String username);
}
