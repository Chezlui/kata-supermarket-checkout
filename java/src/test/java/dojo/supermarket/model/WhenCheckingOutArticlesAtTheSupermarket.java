package dojo.supermarket.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WhenCheckingOutArticlesAtTheSupermarket {
    SupermarketCatalog catalog = new DummyCatalog();
    Teller teller = new Teller(catalog);
    ShoppingCart theCart = new ShoppingCart();

    @Test
    public void an_empty_shopping_cart_should_cost_nothing() {
        Receipt receipt = teller.checksOutArticlesFrom(theCart);
        assertThat(receipt.getTotalPrice(), equalTo(0.00));
    }

    @Test
    public void one_toothbrush_costs_99() {
        Product toothbrush = new Product("toothbrush");
        catalog.addProduct(toothbrush, 0.99);
        theCart.addItem(toothbrush);
        Receipt receipt = teller.checksOutArticlesFrom(theCart);
        assertThat(receipt.getTotalPrice(), equalTo(0.99));

    }
}
