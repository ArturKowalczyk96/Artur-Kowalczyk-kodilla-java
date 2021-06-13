package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {

    @Test
    void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(" with Sesame")
                .burgers(2)
                .sauce("BBQ")
                .ingredient("Onion")
                .ingredient("Pickle")
                .ingredient("Bacon")
                .build();
        System.out.println(bigmac);

        //When
        int howManyIngredients = bigmac.getIngredients().size();
        String whichSauce = bigmac.getSauce();

        //Then
        assertEquals(3, howManyIngredients);
        assertEquals("BBQ", whichSauce);
    }
}
