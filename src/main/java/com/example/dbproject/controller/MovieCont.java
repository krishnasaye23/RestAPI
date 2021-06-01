package com.example.dbproject.controller;

import com.example.dbproject.model.Movie;
import com.example.dbproject.model.MovieDetails;
import com.example.dbproject.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.xml.bind.DatatypeConverter;
import java.util.List;

@RestController
public class MovieCont {
     @Autowired
     private MovieService ms;
     @Autowired
     private RestTemplate rs;

     @GetMapping("/reqres")
     public String getRestTemplate(){
          String url="https://reqres.in/api/unknown";
          String objects=rs.getForObject(url,String.class);
          assert objects != null;
          return objects;
          //return Arrays.asList(objects);
     }
     @GetMapping("/tmdb")
     public String getRestTemplate(@RequestParam("api_key") String api_key,
                                   @RequestParam("language") String language){
          String url="https://api.themoviedb.org/3/movie/latest?api_key=6c48578f0439ca20868c61df656bb82c&language=en-US";
          String objects=rs.getForObject(url,String.class);
          assert objects != null;
          return objects;
     }
     @GetMapping("/complex")
     public ResponseEntity findMovies()
     {
          String username="Httpresttemplate";
          String pwd="12345";
          String url = "https://api.themoviedb.org/3/movie/latest";
          String authorizationHeader = "Basic " + DatatypeConverter.printBase64Binary((username + ":" + pwd).getBytes());
          HttpHeaders requestHeaders = new HttpHeaders();

          //requestHeaders.add("Authorization", authorizationHeader);
          requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
          HttpEntity<String> requestEntity = new HttpEntity<>(requestHeaders);

          UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
                  .queryParam("api_key", "6c48578f0439ca20868c61df656bb82c")
                  .queryParam("language", "en-US");
          ResponseEntity<String> responseEntity = rs.exchange(
                  uriBuilder.toUriString(),
                  HttpMethod.GET,
                  requestEntity,
                  String.class
          );
          if (responseEntity.getStatusCode() == HttpStatus.OK) {
               System.out.println("response received");
               System.out.println(responseEntity.getBody());
          } else {
               System.out.println("error occurred");
               System.out.println(responseEntity.getStatusCode());
          }
          return responseEntity;
     }

     @GetMapping("/")
     public String home(){
         return "Welcome to Movie Database";
     }

     @GetMapping("/movies")
     public ResponseEntity<List<Movie>> get(){
          List<Movie> mo=ms.getMovies();
          return new ResponseEntity<>(mo,HttpStatus.OK);
     }
     @GetMapping("/movies/moviedetails")
     public ResponseEntity<List<MovieDetails>> getdetails(){
          List<MovieDetails> mo=ms.getDetails();
          return new ResponseEntity<>(mo,HttpStatus.OK);
     }
     @GetMapping("/movies/{movie_id}")
     public ResponseEntity<Movie> get2(@PathVariable int movie_id){
          Movie movie=ms.getMoviebyid(movie_id);
          return new ResponseEntity<>(movie,HttpStatus.OK);
     }
     @PostMapping("/movies/addmovie")
     public ResponseEntity<Movie> addmovie(@RequestBody Movie movie) {
          Movie responsemovie=ms.addmovie(movie);
          return new ResponseEntity<>(responsemovie,HttpStatus.CREATED);
     }
     @PostMapping("movies/addcustommovie")
     public ResponseEntity<Movie> addcustom(@RequestParam("movie_id") int movie_id,
                            @RequestParam("movie_name") String movie_name,
                            @RequestParam("movie_language") String movie_language,
                            @RequestParam("rating") double rating){
          Movie responsemovie=ms.addcustom(movie_id,movie_name,movie_language,rating);
          return new ResponseEntity<>(responsemovie,HttpStatus.ACCEPTED) ;
     }
     @GetMapping("/movies/{movie_language}")
     public ResponseEntity<List<Movie>> getcustom(@PathVariable String movie_language) {
          List<Movie> result= ms.getcustom(movie_language);
          return new ResponseEntity<>(result,HttpStatus.OK);
     }
     @PutMapping("/movies/addmovie")
     public ResponseEntity<Movie> updatemovie(@RequestBody Movie movie){
          Movie responsemovie = ms.updatemovie(movie);
          return new ResponseEntity<>(responsemovie,HttpStatus.OK);
     }
     @DeleteMapping("movies/deletemovie")
     public ResponseEntity<Movie> delrecord(@RequestParam("movie_id") int movie_id){
          Movie responsemovie = ms.delrecord(movie_id);
          return new ResponseEntity<>(responsemovie,HttpStatus.ACCEPTED);
     }
}
