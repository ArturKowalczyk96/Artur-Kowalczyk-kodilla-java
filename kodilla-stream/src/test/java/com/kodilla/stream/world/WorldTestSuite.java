package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.*;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity(){
        //Given
        World world = new World();
        List<Continent> world = new ArrayList<>();
        world.add(new Continent("Asia", {new Country("Country 1", "45642534"),
                new Country("Country 2", "48676786"),
                new Country("Country 3", "786456788"),
                new Country("Country 4", "78674867"),
                new Country("Country 5", "789678677")});
        world.add(new Continent("Africa", {new Country("Country 6", "7864111"),
                new Country("Country 7", "89961451"),
                new Country("Country 8", "88513544"),
                new Country("Country 9", "4864538786"),
                new Country("Country 10", "13873456378")});
        world.add(new Continent("Europe", {new Country("Country 11", "48643483"),
                new Country("Country 12", "15373861531"),
                new Country("Country 13", "43583123483"),
                new Country("Country 14", "41234853138"),
                new Country("Country 15", "13837864153")});
        world.add(new Continent("America", {new Country("Country 16", "15223758378536"),
                new Country("Country 17", "7864152374"),
                new Country("Country 18", "7864156345"),
                new Country("Country 19", "48678678615"),
                new Country("Country 20", "7867867861523")});

        //When
        BigDecimal peopleQuantity = world.getPeopleQuantity();
    }
}
