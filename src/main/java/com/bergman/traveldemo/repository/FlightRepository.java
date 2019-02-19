package com.bergman.traveldemo.repository;

import com.bergman.traveldemo.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
