package dojo.supermarket.model;

public interface Offer {
    Product getProduct();

    Discount getDiscount(Product product, double quantity, double priceForOne);
}
