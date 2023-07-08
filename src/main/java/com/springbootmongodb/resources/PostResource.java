package com.springbootmongodb.resources;

<<<<<<< HEAD
import java.util.Date;
=======
>>>>>>> 269d0757ec584c1b9672a2038d05f816ee926369
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootmongodb.domain.Post;
import com.springbootmongodb.resources.util.URL;
import com.springbootmongodb.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	@Autowired
	private PostService service;

	@GetMapping(value="/{id}")
 	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/titlesearch")
 	public ResponseEntity<List<Post>> finddByTitle(@RequestParam(value="text", defaultValue = "") String text) {
		text = URL.decodePara(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
<<<<<<< HEAD
	@GetMapping(value="/fullsearch")
 	public ResponseEntity<List<Post>> fullSearch(
 			@RequestParam(value="text", defaultValue = "") String text,
 			@RequestParam(value="minDate", defaultValue = "") String minDate,
 			@RequestParam(value="maxDate", defaultValue = "") String maxDate) {
		text = URL.decodePara(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}
	
=======
>>>>>>> 269d0757ec584c1b9672a2038d05f816ee926369
}