package com.example.dbproject.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "MovieTable")
public class Movie {
    @Id
    @Min(value = 300)
    private int movie_id;
    @NotNull(message = "movie name should not be null")
   // @Pattern(regexp="^[a-z][A-Z][0-9]",message="should not contain special characters")
    //@Pattern(regexp = )
    private String movie_name;
    private String movie_language;
    private double rating;
    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "Details_id",referencedColumnName = "id")
    //@JsonBackReference
    private MovieDetails details;

    public Movie(int movie_id, String movie_name, String movie_language, double rating) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.movie_language = movie_language;
        this.rating=rating;
    }

    /*public Movie() {

    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getMovie_language() {
        return movie_language;
    }

    public void setMovie_Language(String language) {
        this.movie_language = language;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", movie_name='" + movie_name + '\'' +
                ", language='" + movie_language + '\'' +
                ", rating=" + rating +
                '}';
    }*/
}
