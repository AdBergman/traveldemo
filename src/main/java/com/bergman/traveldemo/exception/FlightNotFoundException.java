package com.bergman.traveldemo.exception;

public class FlightNotFoundException extends RuntimeException {

    public FlightNotFoundException(Long id) {
        super("" + id);
    }
}
