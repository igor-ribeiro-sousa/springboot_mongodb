package com.springbootmongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootmongodb.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User mirna1 = new User("1", "Mirna1", "mirna1@hmail.com");
		User mirna2 = new User("2", "Mirna2", "mirna2@hmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(mirna1, mirna2));
		return ResponseEntity.ok().body(list);
	}

}
