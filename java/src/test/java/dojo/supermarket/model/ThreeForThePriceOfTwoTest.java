package dojo.supermarket.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreeForThePriceOfTwoTest {

    Product toothbrush = new Product("toothbrush", ProductUnit.Each);

    @Test
    public void three_for_the_price_of_two() {
        ThreeForThePriceOfTwo offer = new ThreeForThePriceOfTwo(toothbrush, 0.99);
        assertEquals(0.99, offer.getTotalPrice(1, 0.99), 0.001);
        assertEquals(2*0.99, offer.getTotalPrice(2, 0.99), 0.001);
        assertEquals(2*0.99, offer.getTotalPrice(3, 0.99), 0.001);
        assertEquals(3*0.99, offer.getTotalPrice(4, 0.99), 0.001);
        assertEquals(4*0.99, offer.getTotalPrice(5, 0.99), 0.001);
        assertEquals(4*0.99, offer.getTotalPrice(6, 0.99), 0.001);
    }
}
