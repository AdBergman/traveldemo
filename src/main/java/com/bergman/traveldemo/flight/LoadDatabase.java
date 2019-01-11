package com.bergman.traveldemo.flight;

import com.bergman.traveldemo.flight.book.Flight;
import com.bergman.traveldemo.flight.book.FlightRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(FlightRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Flight("Stockholm", "London", "BA", "100")));
            log.info("Preloading " + repository.save(new Flight("London", "Stockholm", "BA", "101")));
        };
    }
}
