package dojo.supermarket.model;

public class ThreeForThePriceOfTwo extends Offer {
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
    public Discount getDiscount(Product product, double quantity, double priceForOne) {
        int quantityAsInt = (int) quantity;
        int numberOfTrios = quantityAsInt/3;
        double discountAmount = quantity * priceForOne -
                ((numberOfTrios * 2 * priceForOne) + quantityAsInt % 3 * priceForOne);

        return new Discount(product,"3 for 2", discountAmount);
    }

}
