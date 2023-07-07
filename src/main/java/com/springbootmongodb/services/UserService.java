package com.springbootmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootmongodb.domain.User;
import com.springbootmongodb.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;// Injeção de dependencia do Spring

	public List<User> findAll() {
		return repository.findAll();
	}
}
