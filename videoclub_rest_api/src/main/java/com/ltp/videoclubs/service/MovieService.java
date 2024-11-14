package com.ltp.videoclubs.service;

import com.ltp.videoclubs.entity.Movie;

public interface MovieService {

    Movie getMovie(Long videoclubId, Long id);

    Movie saveMovie(Movie movie, Long videoclubId);

    void deleteMovie(Long videoclubId, Long movieId);

    Iterable<Movie> getMoviesByVideoclub(Long videoclubId);

}
