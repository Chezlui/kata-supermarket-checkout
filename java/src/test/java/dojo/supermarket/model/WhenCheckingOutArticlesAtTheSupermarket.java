package dojo.supermarket.model;

import org.junit.Before;
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
}
