package dojo.supermarket.model;

public interface SupermarketCatalog {
    void addProduct(Product toothbrush, double price);

    double getPrice(Product p);
}
