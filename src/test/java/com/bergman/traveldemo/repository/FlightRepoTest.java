package com.bergman.traveldemo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.bergman.traveldemo.domain.Flight;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FlightRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private FlightRepository repository;

    @Test
    public void shouldFindNoFlights() {
        List<Flight> flightList = repository.findAll();
        assertThat(flightList.isEmpty());
    }

    @Test
    public void shouldSaveFlight(){
        Flight flight = repository.save(new Flight().builder().origin("STO").destination("LON").build());
        assertThat(flight).hasFieldOrPropertyWithValue("origin", "STO");
        assertThat(flight).hasFieldOrPropertyWithValue("destination", "LON");
    }
}
