package com.bergman.traveldemo.rest;

import com.bergman.traveldemo.domain.Flight;
import com.bergman.traveldemo.service.FlightService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(FlightController.class)

public class FlightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlightService flightService;

    @Test
    public void getAllFlights() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/flights")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getFlight() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/flights/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addFlight() throws Exception
    {
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform( MockMvcRequestBuilders
                .post("/flights")
                .content(objectMapper.writeValueAsString(new Flight().builder()
                        .origin("STO").destination("GOT").airline("SK").number("1234")
                        .build()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

}
