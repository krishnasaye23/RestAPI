package com.example.dbproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@JsonPropertyOrder({"id","runtime","genre","releasedate"})
@Table(name = "details")
public class MovieDetails {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String genre;
   // @Size(min = 60,max = 240)
    private int runtime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd:MM:yyyy hh:mm:ss")
    private Date releasedate;
    @OneToMany(mappedBy = "details",cascade = CascadeType.ALL)
    //@JoinColumn(name = "Movie_id",referencedColumnName = "movie_id")
    //@JsonManagedReference
    private List<Movie> MovieTable;

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    /*public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }*/

    @Override
    public String toString() {
        return "MovieDetails{" +
                "id=" + id +
                ", genre='" + genre + '\'' +
                ", runtime=" + runtime +
              //  ", movie=" + movie +
                '}';
    }
}
