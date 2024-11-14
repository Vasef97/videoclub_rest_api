package com.ltp.videoclubs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.videoclubs.entity.Movie;
import com.ltp.videoclubs.repository.VideoclubRepository;
import com.ltp.videoclubs.service.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/movie")
@CrossOrigin(origins = "http://localhost:5173")
@Tag(name = "Movie Controller", description = "Post and retrieve movie info.")
public class MovieController {

  @Autowired
  VideoclubRepository videoclubRepository;

  @Autowired
  MovieService movieService;

  @PostMapping("/videoclub/{videoclubId}")
  @Operation(summary = "Save a movie to a specific videoclub.")
  public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie, @PathVariable Long videoclubId) {
    return new ResponseEntity<>(movieService.saveMovie(movie, videoclubId), HttpStatus.CREATED);
  }

  @GetMapping("/{movieId}/videoclub/{videoclubId}")
  @Operation(summary = "Get a specific movie from a specific videoclub.")
  public ResponseEntity<Movie> getMovieFromVideoclub(@PathVariable Long videoclubId, @PathVariable Long movieId) {
    Movie movie = movieService.getMovie(videoclubId, movieId);
    if (movie != null) {
      return new ResponseEntity<>(movie, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/{movieId}/videoclub/{videoclubId}")
  @Operation(summary = "Delete a specific movie from a specific videoclub.")
  public ResponseEntity<Void> deleteMovieFromVideoclub(@PathVariable Long videoclubId, @PathVariable Long movieId) {
    movieService.deleteMovie(videoclubId, movieId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/all/videoclub/{videoclubId}")
  @Operation(summary = "Get all movies from a specific videoclub.")
  public ResponseEntity<Iterable<Movie>> getMoviesByVideoclub(@PathVariable Long videoclubId) {
    return new ResponseEntity<>(movieService.getMoviesByVideoclub(videoclubId), HttpStatus.OK);
  }

}
