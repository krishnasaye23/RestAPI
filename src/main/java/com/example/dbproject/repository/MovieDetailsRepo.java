package com.example.dbproject.repository;

import com.example.dbproject.model.MovieDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDetailsRepo extends JpaRepository<MovieDetails,Integer> {
}
