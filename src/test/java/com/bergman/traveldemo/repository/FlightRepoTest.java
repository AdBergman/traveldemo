package com.bergman.traveldemo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
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

    @Test
    public void shouldFindFlightById(){
        Flight flight1 = new Flight().builder().origin("STO").destination("LON").build();
        entityManager.persist(flight1);

        Flight flight2 = new Flight().builder().origin("GOT").destination("LON").build();
        entityManager.persist(flight2);

        Flight testFlight = repository.getOne(flight1.getId());
        assertThat(testFlight).isEqualTo(flight1);
    }

    @Test
    public void shouldFindAllFlights() {
        Flight flight1 = new Flight().builder().origin("STO").destination("LON").build();
        entityManager.persist(flight1);

        Flight flight2 = new Flight().builder().origin("GOT").destination("LON").build();
        entityManager.persist(flight2);

        Flight flight3 = new Flight().builder().origin("NYC").destination("LON").build();
        entityManager.persist(flight3);

        List<Flight> flightList = repository.findAll();

        assertThat(flightList).hasSize(3).contains(flight1, flight2, flight3);
    }

    @Test(expected = JpaObjectRetrievalFailureException.class)
    public void shouldDeleteFlightById(){
        Flight flight1 = new Flight().builder().origin("STO").destination("LON").build();
        entityManager.persist(flight1);

        Flight flight2 = new Flight().builder().origin("GOT").destination("LON").build();
        entityManager.persist(flight2);

        repository.deleteById(flight1.getId());
        assertThat(flight1).isNotEqualTo(repository.getOne(flight1.getId()));
    }

    @Test
    public void shouldDeleteAllFlights() {
        entityManager.persist(new Flight().builder().origin("STO").destination("LON").build());
        entityManager.persist(new Flight().builder().origin("LON").destination("STO").build());
        repository.deleteAll();
        assertThat(repository.findAll()).isEmpty();
    }
}
