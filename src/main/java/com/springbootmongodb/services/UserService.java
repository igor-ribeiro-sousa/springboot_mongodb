package com.springbootmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootmongodb.domain.User;
import com.springbootmongodb.dto.UserDTO;
import com.springbootmongodb.repository.UserRepository;
import com.springbootmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;// Injeção de dependencia do Spring

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User user) {
		return repository.insert(user);
	}
	
	public User update(User user) {
		User meuUser = findById(user.getId());
		updateData(meuUser, user);
		return repository.save(meuUser);
	}

	private void updateData(User meuUser, User user) {
		meuUser.setName(user.getName());
		meuUser.setEmail(user.getEmail());
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
