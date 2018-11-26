package dojo.supermarket.model;

public class Teller {

    private final SupermarketCatalog catalog;

    public Teller(SupermarketCatalog catalog) {

        this.catalog = catalog;
    }

    public Receipt checksOutArticlesFrom(ShoppingCart theCart) {
        Receipt receipt = new Receipt();
        for (Product p : theCart.getItems()) {
            double price = this.catalog.getPrice(p);
            receipt.addProduct(p, price);
        }
        return receipt;
    }
}
