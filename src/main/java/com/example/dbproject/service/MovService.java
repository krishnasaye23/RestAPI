package com.example.dbproject.service;

import com.example.dbproject.model.Movie;
import java.util.List;

public interface MovService {
    public Movie delrecord(int movie_id);
    public List<Movie> getMovies();
    public Movie getMoviebyid(int movie_id);
    public Movie addmovie(Movie movie);

    public Movie updatemovie(Movie movie);

    public List<Movie> getcustom(String movie_language);
    public Movie addcustom(int movie_id, String movie_name, String movie_language, double rating);
}
