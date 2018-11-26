package dojo.supermarket.model;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class WhenCheckingOutArticlesAtTheSupermarket {
    private SupermarketCatalog catalog;
    private Teller teller;
    private ShoppingCart theCart;
    private Product toothbrush;
    private Product rice;

    @Before
    public void setUp() {
        catalog = new DummyCatalog();
        teller = new Teller(catalog);
        theCart = new ShoppingCart();

        toothbrush = new Product("toothbrush");
        catalog.addProduct(toothbrush, 0.99);
        rice = new Product("rice");
        catalog.addProduct(rice, 2.99);
    }

    @Test
    public void an_empty_shopping_cart_should_cost_nothing() {
        Receipt receipt = teller.checksOutArticlesFrom(theCart);
        assertEquals(0.00, receipt.getTotalPrice(), 0.001);

    }

    @Test
    public void one_normal_item() {
        theCart.addItem(toothbrush);
        Receipt receipt = teller.checksOutArticlesFrom(theCart);
        assertEquals(0.99, receipt.getTotalPrice(), 0.001);
    }

    @Test
    public void two_normal_items() {
        theCart.addItem(toothbrush);
        theCart.addItem(rice);
        Receipt receipt = teller.checksOutArticlesFrom(theCart);
        assertEquals(0.99 + 2.99, receipt.getTotalPrice(), 0.001);
    }

    @Test
    public void buy_two_get_one_free() {
        theCart.addItem(toothbrush);
        theCart.addItem(toothbrush);
        theCart.addItem(toothbrush);
        teller.addSpecialOffer(new ThreeForThePriceOfTwo(toothbrush, catalog.getPrice(toothbrush)));
        Receipt receipt = teller.checksOutArticlesFrom(theCart);
        assertEquals(0.99 + 0.99, receipt.getTotalPrice(), 0.001);
    }

    @Test
    public void three_for_the_price_of_two() {
        Offer offer = new ThreeForThePriceOfTwo(toothbrush, 0.99);
        assertEquals(0.99, offer.getTotalPrice(1, 0.99), 0.001);
        assertEquals(2*0.99, offer.getTotalPrice(2, 0.99), 0.001);
        assertEquals(2*0.99, offer.getTotalPrice(3, 0.99), 0.001);
        assertEquals(3*0.99, offer.getTotalPrice(4, 0.99), 0.001);
        assertEquals(4*0.99, offer.getTotalPrice(5, 0.99), 0.001);
        assertEquals(4*0.99, offer.getTotalPrice(6, 0.99), 0.001);
    }
}
