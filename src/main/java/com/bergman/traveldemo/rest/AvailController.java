package com.bergman.traveldemo.rest;

import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOffer;
import com.bergman.traveldemo.domain.Flight;
import com.bergman.traveldemo.service.AvailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class AvailController {

    @Autowired
    private AvailService availService;

    @GetMapping("/flightsearch")
    List<Flight> results (@RequestBody Params searchRequest){
        try {
            return availService.flightSearch(searchRequest);

        } catch (ResponseException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Flight Not Found.", e);
        }
    }

}
