package com.bergman.traveldemo.flight.availability;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AvailController {

    @Autowired
    private AvailService availService;

    @GetMapping("/search")
    FlightOffer[] flightOffers(@RequestBody String searchRequest){

        try {
            return availService.requestAvailability(searchRequest);
        } catch (ResponseException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Flight Not Found.", e);
        }

    }

}
