package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {
    public boolean findFlight(Flight flight) throws RouteNotFoundException{
        Map<String, Boolean> airportsMap = new HashMap<>();
        airportsMap.put("Warszawa", true);
        airportsMap.put("Gdańsk", true);
        airportsMap.put("Radom", false);
        airportsMap.put("Wrocław", true);
        airportsMap.put("Olsztyn", false);
        airportsMap.put("Kraków", true);

        if(flight.getDepartureAirport()!= null && airportsMap.get(flight.getDepartureAirport()) != false && airportsMap.get(flight.getArrivalAirport())!= false) {
            return airportsMap.get(flight.getDepartureAirport()) && airportsMap.get(flight.getArrivalAirport());
        } else {
            throw new RouteNotFoundException("At least one of the Airports is not on available");
        }
    }
}
