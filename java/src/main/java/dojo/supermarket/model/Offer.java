package dojo.supermarket.model;

public abstract class Offer {
    abstract Product getProduct();

    abstract Discount getDiscount(Product product, double quantity, double priceForOne);
}
