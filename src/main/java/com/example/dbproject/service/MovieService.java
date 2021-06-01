package com.example.dbproject.service;

import com.example.dbproject.model.Movie;
import com.example.dbproject.model.MovieDetails;
import com.example.dbproject.repository.MovieDetailsRepo;
import com.example.dbproject.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Component

@Service
public class MovieService implements MovService{

    @Autowired
    private MovieRepo m;
    @Autowired
    private MovieDetailsRepo md;
    @Override
    public List<Movie> getMovies() {
        var movies = new ArrayList<Movie>();
        movies = (ArrayList<Movie>) m.findAll();

        return movies;
    }
    public List<MovieDetails> getDetails() {
        var movies = new ArrayList<MovieDetails>();
        movies = (ArrayList<MovieDetails>) md.findAll();

        return movies;
    }
    @Override
    public Movie getMoviebyid(int movie_id) {
        //var movies2 = new ArrayList<Movie>();
         //movies2=(ArrayList<Movie>) m.findById(movie_id);
        Movie opt=m.findById(movie_id);
        return opt;
    }
    @Override
    public Movie addmovie(Movie movie){
        //var movies3=new ArrayList<Movie>();
        //movies3.add(movie);
        m.save(movie);
        return movie;
    }
    @Override
    public Movie updatemovie(Movie movie){
        m.save(movie);
        return movie;
    }

    @Override
    public List<Movie> getcustom(String movie_language){
        var movies4=new ArrayList<Movie>();
        movies4=(ArrayList<Movie>) m.findByLanguageSorted(movie_language);
        return movies4;
    }
    @Override
    public Movie addcustom(int movie_id, String movie_name, String movie_language, double rating) {
        m.save(new Movie(movie_id,movie_name,movie_language,rating));
        Movie f=m.findById(movie_id);
        return f;
    }
    @Override
    public Movie delrecord(int movie_id) {
        Movie g=m.deleteById(movie_id);
        return g;
    }
}
