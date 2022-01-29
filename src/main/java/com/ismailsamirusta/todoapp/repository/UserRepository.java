package com.ismailsamirusta.todoapp.repository;


import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;

import com.ismailsamirusta.todoapp.model.AppUser;

import reactor.core.publisher.Flux;

@Repository
public interface UserRepository  extends FirestoreReactiveRepository<AppUser>{
	
	public Flux<AppUser> findByUsername(String username);
	
}
