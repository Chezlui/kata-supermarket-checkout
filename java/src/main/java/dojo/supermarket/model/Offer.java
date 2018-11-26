package dojo.supermarket.model;

public interface Offer {
    Product getProduct();

    double getTotalPrice(int quantity, double priceForOne);
}
