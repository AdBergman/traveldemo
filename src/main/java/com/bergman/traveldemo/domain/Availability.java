package com.bergman.traveldemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class may be used to save search parameters
 */

@AllArgsConstructor
@Data
public class Availability {

    private String origin;
    private String destination;
    private String departureDate;

}
