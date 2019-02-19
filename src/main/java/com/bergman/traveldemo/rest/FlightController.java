package com.bergman.traveldemo.rest;

import com.bergman.traveldemo.model.Flight;
import com.bergman.traveldemo.exception.FlightNotFoundException;
import com.bergman.traveldemo.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/flights")
    List<Flight> getAllFlights(){
        return flightService.getAllFlights();
    }

    @GetMapping("/flights/{id}")
    Flight getFlight(@PathVariable Long id) {
        try {
            return flightService.getFlight(id);
        } catch (FlightNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Flight Not Found.", e);
        }
    }

    @PostMapping("/flights")
    Flight addFlight(@RequestBody Flight newFlight) {
        return flightService.saveFlight(newFlight);
    }



    @PutMapping("/flights/{id}")
    Flight replaceFlight(@RequestBody Flight newFlight, @PathVariable Long id) {
        try {
        return flightService.replaceFlight(id, newFlight);
        } catch (FlightNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Flight Not Found.", e);
        }
    }

    @DeleteMapping("/flights/{id}")
    void deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
    }
}
