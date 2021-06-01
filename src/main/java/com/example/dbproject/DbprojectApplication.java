package com.example.dbproject;

import com.example.dbproject.model.Movie;
import com.example.dbproject.model.MovieDetails;
import com.example.dbproject.repository.MovieDetailsRepo;
import com.example.dbproject.repository.MovieRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class DbprojectApplication {
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
				SpringApplication.run(DbprojectApplication.class, args);
		/*ConfigurableApplicationContext con= SpringApplication.run(DbprojectApplication.class, args);
		MovieDetailsRepo mdr=con.getBean(MovieDetailsRepo.class);
		MovieRepo mr=con.getBean(MovieRepo.class);
		MovieDetails m=new MovieDetails(101,"Action",162);
		mdr.save(m);
		mr.save(new Movie(301,"Master","Tamil",8.2,m));*/
	}

}
