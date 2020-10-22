package com.kodilla.exception.test;

public class FlightFinderRunner {
    public static void main(String[] args) throws Exception{
        FlightFinder flightFinder = new FlightFinder();

        Flight flight01 = new Flight("Warszawa", "Kraków");
        Flight flight02 = new Flight("Olsztyn", "Gdańsk");
        Flight flight03 = new Flight("Wrocław", "Warszawa");
        Flight flight04 = new Flight("Radom", "Olsztyn");
        Flight flight05 = new Flight("Rzeszów", "Warszawa");

        try {
            System.out.println(flightFinder.findFlight(flight01) + " flight01");
            System.out.println(flightFinder.findFlight(flight02) + " flight02");
            System.out.println(flightFinder.findFlight(flight03) + " flight03");
            System.out.println(flightFinder.findFlight(flight04) + " flight04");
            System.out.println(flightFinder.findFlight(flight05) + " flight05");
        } catch (RouteNotFoundException e) {
            System.out.println("One of airports in route cannot be found!");
            System.out.println(e);
        } finally {
            System.out.println("Search ended.");
        }


    }
}
