package com.kodilla.stream.invoice.simple;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleInvoiceTestSuite {

    @Test
    public void testGetValueToPay() {
        //Given
        SimpleInvoice invoice = new SimpleInvoice();

        //When
        invoice.addItem(new SimpleItem(new SimpleProduct("Pr1", 17.28), 2.0));
        invoice.addItem(new SimpleItem(new SimpleProduct("Pr2", 11.99), 3.5));
        invoice.addItem(new SimpleItem(new SimpleProduct("Pr3", 6.49), 5.0));

        double valueToPay = invoice.getValueToPay();

        //Then
        assertEquals(108.975, valueToPay, 0.001);
    }
}
