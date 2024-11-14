package com.ltp.videoclubs.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltp.videoclubs.entity.Movie;
import com.ltp.videoclubs.entity.Videoclub;
import com.ltp.videoclubs.exception.MovieNotFoundException;
import com.ltp.videoclubs.exception.VideoclubNotFoundException;
import com.ltp.videoclubs.repository.MovieRepository;
import com.ltp.videoclubs.repository.VideoclubRepository;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    VideoclubRepository videoclubRepository;

    @Override
    public Movie saveMovie(Movie movie, Long videoclubId) {
        Optional<Videoclub> optionalVideoclub = videoclubRepository.findById(videoclubId);
        if (!optionalVideoclub.isPresent()) {
            throw new VideoclubNotFoundException(videoclubId);
        }
        Videoclub videoclub = optionalVideoclub.get();
        movie.setVideoclub(videoclub);
        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovie(Long videoclubId, Long movieId) {
        Optional<Videoclub> videoclub = videoclubRepository.findById(videoclubId);
        if (videoclub.isPresent()) {
            Optional<Movie> movie = movieRepository.findById(movieId);
            if (movie.isPresent() && movie.get().getVideoclub().getId().equals(videoclubId)) {
                return movie.get();
            } else {
                Videoclub notFoundVideoclub = videoclub.get();
                throw new MovieNotFoundException(movieId, notFoundVideoclub.getName());
            }
        } else {
            throw new VideoclubNotFoundException(videoclubId);
        }
    }

    @Override
    public void deleteMovie(Long videoclubId, Long movieId) {
        Optional<Videoclub> videoclub = videoclubRepository.findById(videoclubId);
        if (videoclub.isPresent()) {
            Optional<Movie> movie = movieRepository.findById(movieId);
            if (movie.isPresent() && movie.get().getVideoclub().getId().equals(videoclubId)) {
                movieRepository.delete(movie.get());
            } else {
                throw new MovieNotFoundException(movieId, videoclub.get().getName());
            }
        } else {
            throw new VideoclubNotFoundException(videoclubId);
        }
    }

    @Override
    public Iterable<Movie> getMoviesByVideoclub(Long videoclubId) {
        Optional<Videoclub> videoclub = videoclubRepository.findById(videoclubId);
        if (videoclub.isPresent()) {
            return movieRepository.findByVideoclub(videoclub.get());
        }
        return new ArrayList<>();
    }

}
