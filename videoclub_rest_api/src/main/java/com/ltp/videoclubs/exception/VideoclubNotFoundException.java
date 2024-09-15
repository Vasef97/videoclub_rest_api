package com.ltp.videoclubs.exception;

public class VideoclubNotFoundException extends RuntimeException {

    public VideoclubNotFoundException(Long id) {
        super("The videoclub with id '" + id + "' does not excist");
    }

}
