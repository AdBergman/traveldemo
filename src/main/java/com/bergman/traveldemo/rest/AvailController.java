package com.bergman.traveldemo.rest;

import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.bergman.traveldemo.model.Flight;
import com.bergman.traveldemo.service.AvailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Api(description = "An end point to search for availability in Amadeus using the 3 letter City Pair Codes")
@RestController
public class AvailController {

    @Autowired
    private AvailService availService;

    @ApiOperation("Returns the direct flights with the lowest fare.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "origin", value = "The city where you are flying from, for example:  STO", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "destination", value = "The city you are flying to, for example: LON", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "departureDate", value = "The date of departure, for example:  2019-10-01", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "nonStop", value = "That the flight should be nonstop (has to be true). For example: true", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "max", value = "The amount of flight options to be returned, for example: 5", dataType = "Integer", paramType = "query", required = true)
    })
    @GetMapping("/flightsearch")
    List<Flight> flightSearch (@RequestBody Params searchRequest){
        try {
            return availService.flightSearch(searchRequest);
        } catch (ResponseException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Flight Not Found.", e);
        }
    }

}
