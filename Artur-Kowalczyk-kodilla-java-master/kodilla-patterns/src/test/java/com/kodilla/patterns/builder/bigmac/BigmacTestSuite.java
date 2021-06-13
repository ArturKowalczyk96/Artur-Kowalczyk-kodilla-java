package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {

    @Test
    void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("with Sesame")
                .burgers(2)
                .sauce("BBQ")
                .ingredient("Onion")
                .ingredient("Pickle")
                .ingredient("Bacon")
                .build();
        System.out.println(bigmac);

        //When
        String witchBun = bigmac.getBun();
        int howManyBurgers = bigmac.getBurgers();
        String witchSauce = bigmac.getSauce();
        int howManyIngredients = bigmac.getIngredients().size();

        //Then
        assertEquals("with Sesame", witchBun);
        assertEquals(2, howManyBurgers);
        assertEquals("BBQ", witchSauce);
        assertEquals(3, howManyIngredients);
    }
}
