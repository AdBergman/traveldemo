package com.bergman.traveldemo.flight.availability;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOffer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class AvailService {
    @Value("${AMADEUS_CLIENT_ID}")
    private String AMADEUS_CLIENT_ID;
    @Value("${AMADEUS_CLIENT_SECRET}")
    private String AMADEUS_CLIENT_SECRET;

    public FlightOffer[] requestAvailability(String searchRequest) throws ResponseException {
        Amadeus amadeus = Amadeus
                .builder(AMADEUS_CLIENT_ID, AMADEUS_CLIENT_SECRET)
                .build();

        // Flight Low-fare Search
        FlightOffer[] flightOffers = amadeus.shopping.flightOffers.get(Params
                .with("origin", "NYC")
                .and("destination", "MAD")
                .and("departureDate", "2019-08-01"));

        System.out.println(flightOffers[0].toString());
        return flightOffers;
    }
}
