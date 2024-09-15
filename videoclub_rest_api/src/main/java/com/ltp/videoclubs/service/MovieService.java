package com.ltp.videoclubs.service;

import com.ltp.videoclubs.entity.Movie;

public interface MovieService {

    Movie getMovie(Long videoclubId, Long id);

    Movie saveMovie(Movie movie, Long videoclubId);

    Iterable<Movie> getMoviesByVideoclub(Long videoclubId);

}
