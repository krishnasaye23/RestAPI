package com.example.dbproject.repository;

import com.example.dbproject.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Integer> {
    List<Movie> findAll();
    Movie findById(int movie_id);
    Movie deleteById(int movie_id);
    //Movie findBy(String movie_name);
    //List<Movie> movie=MovieRepo.findAll
    @Query("from Movie where movie_language=?1 order by rating")
    List<Movie> findByLanguageSorted(String movie_language);
}
