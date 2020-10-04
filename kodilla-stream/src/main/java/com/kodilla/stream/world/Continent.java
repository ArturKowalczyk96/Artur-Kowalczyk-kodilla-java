package com.kodilla.stream.world;

import java.util.*;

public final class Continent {
    private final String continentName;
    private List<Country> listOfCountries = new ArrayList<>();

    public Continent(final String continentName, List<Country> listOfCountries){
        this.continentName = continentName;
        this.listOfCountries = listOfCountries;
    }

    public List<Country> getListOfCountries(){
        return new ArrayList<>(listOfCountries);
    }
}
