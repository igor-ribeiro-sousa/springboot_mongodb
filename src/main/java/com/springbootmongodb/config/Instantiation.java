package com.springbootmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.springbootmongodb.domain.Post;
import com.springbootmongodb.domain.User;
import com.springbootmongodb.dto.AuthorDTO;
import com.springbootmongodb.dto.CommentDTO;
import com.springbootmongodb.repository.PostRepository;
import com.springbootmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();

		User igor  = new User(null, "Igor Sousa", "sousa@gmail.com");
		User virna = new User(null, "Virna Sousa", "sousa@gmail.com");
		User mirna = new User(null, "Mirna Sousa", "sousa@gmail.com");
		userRepository.saveAll(Arrays.asList(igor, virna, mirna ));
		
		
		Post post1 = new Post(null, sdf.parse("2023/07/01"), "Partiu viagem!", "Vou viajar para SP. Abraços!", new AuthorDTO(igor));
		Post post2 = new Post(null, sdf.parse("2023/07/01"), "Bom dia!", "Acordei feliz!", new AuthorDTO(igor));
		
		CommentDTO c1 = new CommentDTO("Boa viagem!", sdf.parse("23/07/02"), new AuthorDTO(mirna));
		CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("23/07/02"), new AuthorDTO(virna));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/07/02"), new AuthorDTO(mirna));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		mirna.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(mirna);
		

	}

}
