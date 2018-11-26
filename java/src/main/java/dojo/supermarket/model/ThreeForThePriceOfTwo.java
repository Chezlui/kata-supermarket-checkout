package dojo.supermarket.model;

public class ThreeForThePriceOfTwo implements Offer {
    private final Product product;
    private final double priceForOne;

    public ThreeForThePriceOfTwo(Product product, double priceForOne) {
        this.product = product;
        this.priceForOne = priceForOne;
    }

    @Override
    public Product getProduct() {
        return this.product;
    }

    @Override
    public double getTotalPrice(int quantity, double priceForOne) {
        int numberOfTrios = quantity/3;
        return (numberOfTrios * 2 * priceForOne) + quantity % 3 * priceForOne;
    }
}
