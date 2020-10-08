package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    private Object Country;

    @Test
    public void testGetPeopleQuantity(){
        //Given
        //continent1
        Continent continent1 = new Continent("continent1", new ArrayList<Country>());
        continent1.addCountry(new Country("Country 1", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 2", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 3", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 4", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 5", new BigDecimal("1")));
        //continent1
        Continent continent2 = new Continent("continent1", new ArrayList<Country>());
        continent1.addCountry(new Country("Country 1", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 2", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 3", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 4", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 5", new BigDecimal("1")));
        //continent1
        Continent continent3 = new Continent("continent1", new ArrayList<Country>());
        continent1.addCountry(new Country("Country 1", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 2", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 3", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 4", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 5", new BigDecimal("1")));
        //continent1
        Continent continent4 = new Continent("continent1", new ArrayList<Country>());
        continent1.addCountry(new Country("Country 1", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 2", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 3", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 4", new BigDecimal("1")));
        continent1.addCountry(new Country("Country 5", new BigDecimal("1")));

        World world = new World(new ArrayList<Continent>());
        world.addContinent(continent1);
        world.addContinent(continent2);
        world.addContinent(continent3);
        world.addContinent(continent4);


        //When
        BigDecimal peopleQuantity = world.getPeopleQuantity();
        BigDecimal expected = new BigDecimal("20");
        //Then
        assertEquals(expected, peopleQuantity);
        System.out.println(peopleQuantity);
    }
}
