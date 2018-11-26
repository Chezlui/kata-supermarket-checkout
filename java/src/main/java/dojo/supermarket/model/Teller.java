package dojo.supermarket.model;

import java.util.HashMap;
import java.util.Map;

public class Teller {

    private final SupermarketCatalog catalog;
    private Map<Product, Offer> offers = new HashMap<>();

    public Teller(SupermarketCatalog catalog) {

        this.catalog = catalog;
    }

    public Receipt checksOutArticlesFrom(ShoppingCart theCart) {
        Receipt receipt = new Receipt();
        Map<Product, Integer> productQuantities = theCart.productQuantities();
        for (Product p: productQuantities.keySet()) {
            double price;
            if (offers.containsKey(p)) {
                Offer offer = offers.get(p);
                price = offer.getTotalPrice(productQuantities.get(p), this.catalog.getPrice(p));
            } else {
                price = this.catalog.getPrice(p)*productQuantities.get(p);
            }
            receipt.addProduct(p, price);
        }

        return receipt;
    }

    public void addSpecialOffer(ThreeForThePriceOfTwo offer) {
        this.offers.put(offer.getProduct(), offer);
    }
}
