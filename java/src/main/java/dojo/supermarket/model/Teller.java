package dojo.supermarket.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Teller {

    private final SupermarketCatalog catalog;
    private Map<Product, Offer> offers = new HashMap<>();

    public Teller(SupermarketCatalog catalog) {

        this.catalog = catalog;
    }

    public void addSpecialOffer(SpecialOfferType offerType, Product product, double argument) {
        Offer offer = createSpecialOffer(offerType, product, argument);
        this.offers.put(offer.getProduct(), offer);
    }

    private Offer createSpecialOffer(SpecialOfferType offerType, Product product, double argument) {
        switch (offerType) {
            case ThreeForTwo:
                return new ThreeForThePriceOfTwo(product, argument);
            case TenPercentDiscount:
                return new PercentDiscount(product, argument);
            case TwoForAmount:
                return new XForYDiscount(product, 2, argument);
        }
        throw new IllegalArgumentException("unreachable");
    }

    public Receipt checksOutArticlesFrom(ShoppingCart theCart) {
        Receipt receipt = new Receipt();
        List<ProductQuantity> productQuantities = theCart.getItems();
        for (ProductQuantity pq: productQuantities) {
            Product p = pq.getProduct();
            double quantity = pq.getQuantity();
            double unitPrice = this.catalog.getUnitPrice(p);
            double price = quantity * unitPrice;
            receipt.addProduct(p, quantity, unitPrice, price);
        }
        for (Product p: theCart.productQuantities().keySet()) {
            double quantity = theCart.productQuantities.get(p);
            if (offers.containsKey(p)) {
                Offer offer = offers.get(p);
                double unitPrice = this.catalog.getUnitPrice(p);
                Discount discount = offer.getDiscount(p, quantity, unitPrice);
                receipt.addDiscount(discount);
            }

        }

        return receipt;
    }

}
