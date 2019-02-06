package com.bergman.traveldemo.rest;

import com.amadeus.Params;
import com.bergman.traveldemo.domain.Flight;
import com.bergman.traveldemo.service.AvailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AvailController.class)

public class AvailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AvailService availService;

    //TODO: Should return OK for testing the controller, not 400.
    @Test
    public void flightSearch() throws Exception {
        List<Flight> mockList = new ArrayList<>();
        mockList.add(new Flight().builder().origin("STO").destination("GOT").build());
        Params params = Params.with("origin", "STO");

        when(availService.flightSearch(params)).thenReturn(mockList);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/flightsearch")
                .params(populateParams())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    private MultiValueMap<String, String> populateParams() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("origin", "STO");;
        params.add("destination", "GOT");
        params.add("departureDate", "2019-08-01");
        params.add("nonStop", "true");
        params.add("max", "1");
        return params;
    }

}
