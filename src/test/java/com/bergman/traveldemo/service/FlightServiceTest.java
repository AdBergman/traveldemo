package com.bergman.traveldemo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static java.lang.Long.valueOf;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bergman.traveldemo.model.Flight;
import com.bergman.traveldemo.repository.FlightRepository;

import java.util.ArrayList;

//TODO: Review service layer testing
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FlightService.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class FlightServiceTest {
    Flight flight;
    Long id = valueOf(100);

    @Autowired
    FlightService flightService;

    @MockBean
    private FlightRepository flightRepository;

    @Before
    public void initialize() {
        flight = (new Flight().builder()
                .origin("STO").destination("GOT").airline("SK").number("1234")
                .departureTime("18:00").arrivalTime("19:00").fareBasis("ABC123")
                .priceTotal(100.00).taxesTotal(20.00).id(id)
                .build());
    }

    @Test
    public void shouldGetAllFlights(){
        when(flightRepository.findAll()).thenReturn(new ArrayList<>());
        assertThat(flightService.getAllFlights()).hasSize(0);
    }

    @Test
    public void shouldSaveFlight(){
         when(flightRepository.save(flight)).thenReturn(flight);
         assertThat(flightService.saveFlight(flight)).isEqualTo(flight);
    }

    @Test
    public void shouldGetFlight(){
        when(flightRepository.findById(flight.getId())).thenReturn(java.util.Optional.ofNullable(flight));
        assertThat(flightService.getFlight(flight.getId())).isEqualTo(flight);
    }

    @Test
    public void shouldDeleteFlight(){
        //TODO:
    }

    @Test
    public void shouldReplaceFlight(){
        //TODO:
    }

}
