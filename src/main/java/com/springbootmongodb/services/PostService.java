package com.springbootmongodb.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootmongodb.domain.Post;
import com.springbootmongodb.repository.PostRepository;
import com.springbootmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	//QUERY METHOD
	/*
	  public List<Post> findByTitle(String text) { return
	  repository.findByTitleContainingIgnoreCase(text); }
	*/
	
	//@QUERY
	public List<Post> findByTitle(String text) {
		return repository.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repository.fullSearch(text, minDate, maxDate);
	}

//	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
//		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
//		return repo.fullSearch(text, minDate, maxDate);
//	}

}