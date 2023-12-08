package com.nsd.datasource.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nsd.datasource.entities.UserInfo;
import com.nsd.datasource.repositoryes.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;

	@Autowired
	private PasswordEncoder encoder;

	public UserInfo saveUser(UserInfo info) {
		info.setPassword(encoder.encode(info.getPassword()));
		return repo.save(info);
	}

}
