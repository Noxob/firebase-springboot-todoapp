package com.ismailsamirusta.todoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ismailsamirusta.todoapp.model.AppUser;
import com.ismailsamirusta.todoapp.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bcrypto;

	private final String USER_ID_PREFIX = "USER:";

	@Override
	public AppUser addUser(AppUser user) throws Exception {
		user.setId(USER_ID_PREFIX + user.getUsername());

		if (user.getUsername() == null || user.getUsername().isEmpty() || user.getPassword() == null
				|| user.getPassword().isEmpty()) {
			throw new Exception("username/password cannot be empty");
		}
		if(findByUsername(user.getUsername()) != null) {
			throw new Exception("username is already taken");
		}
		user.setPassword(bcrypto.encode(user.getPassword()));
		return userRepository.save(user).block();
	}

	@Override
	public AppUser findByUsername(String username) {
		return userRepository.findByUsername(username).blockFirst();
	}

}
