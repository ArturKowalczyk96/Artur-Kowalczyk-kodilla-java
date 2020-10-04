package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World {
    private List<Continent> listOfContinents = new ArrayList<>();

    public World(List<Continent> listOfCountries){
        this.listOfContinents = listOfCountries;
    }

    public List<Continent> getListOfContinents(){
        return new ArrayList<>(listOfContinents);
    }

    public BigDecimal getPeopleQuantity(){
        return listOfContinents.stream()
                .flatMap(continent -> continent.getListOfCountries().stream())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current.getPeopleQuantity()));
    }
}

