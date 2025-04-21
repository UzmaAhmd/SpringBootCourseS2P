package com.uzmaaa.MyFirstAPI.controller;

import com.uzmaaa.MyFirstAPI.model.Movies;
import com.uzmaaa.MyFirstAPI.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class MoviesController {
    Movies m1=new Movies(1L,"Godfather","Marlon Brando",
            "Micheal Corleone", 23434.4);
    Movies m2=new Movies(2L,"Dark Knight","Christian Bale",
            "Heath Ledger", 242134.4);
    Movies m3=new Movies(3L,"Psycho","Anthony Perkins",
            "Micheal Corleone", 111134.4);
    Movies m4=new Movies(4L,"Haider","Shahid Kapoor","Tabu",
            23434.4);
    Movies m5=new Movies(5L,"Sholay","Amitabh Bachan","Amjad Khan",
            23434.4);
    Movies m6=new Movies(6L,"Silence of Lambs","Anthony Hopkins","Jodie Foster",
            23434.4);

    public List<Movies> moviesList=new ArrayList<>(List.of(m1,m2,m3,m4,m5,m6));



    //  http://localhost:8080/all
    @GetMapping("movies/all")
    public List<Movies> getMoviesList(){
        return moviesList;
    }




    // http://localhost:8080/movies/2
    @GetMapping("/movies/{id}")
    public Movies getMovieById(@PathVariable("id") Long id) {
        for (Movies movie : moviesList) {
            if (Objects.equals(movie.getId(), id)) {
                return movie;
            }
        }
        return null; // Ideally, return a proper error response instead of null
    }

    // http://localhost:8080/movies?title=Godfather
    @GetMapping("/movies")
    public List<Movies> getMoviesByTitle(@RequestParam("title") String title) {
        List<Movies> responseMovies = new ArrayList<>();
        for (Movies m : moviesList) {
            if (m.getMovieName().equalsIgnoreCase(title)) {
                responseMovies.add(m);
            }
        }
        return responseMovies;
    }


    //http://localhost:8080/movies/save
    @PostMapping("movies/save")
    public Movies saveData(@RequestBody Movies movies)
    {
        moviesList.add(movies);
        return movies;
    }

//    @PutMapping("movies/")


//   @PatchMapping("/movies/update/{id}")
//   public List<Movies> updateMoviesPartially(@PathVariable("id") Long id, @RequestBody Movies movie)
//   {
//       Movies foundMovie=null;
//
//   }


}
