package com.ltp.videoclubs.exception;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(Long movieId, String videoclubName) {
        super("The movie with id '" + movieId + "' does not excist in the videoclub '" + videoclubName + "'.");
    }
}
