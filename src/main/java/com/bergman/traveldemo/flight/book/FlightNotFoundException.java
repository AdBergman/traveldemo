package com.bergman.traveldemo.flight.book;

public class FlightNotFoundException extends RuntimeException {

    FlightNotFoundException(Long id) {
        super("" + id);
    }
}
