package dojo.supermarket.model;

public class XForYDiscount extends Offer {
    private final Product product;
    private final int xQuantity;
    private final double priceForThatQuantity;

    public XForYDiscount(Product product, int xQuantity, double priceForThatQuantity) {
        this.product = product;
        this.xQuantity = xQuantity;
        this.priceForThatQuantity = priceForThatQuantity;
    }

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public Discount getDiscount(Product product, double quantity, double priceForOne) {
        int quantityAsInt = (int) quantity;
        int numberOfXs = xQuantity/quantityAsInt;
        double total = priceForThatQuantity*numberOfXs + quantityAsInt % xQuantity * priceForOne;
        double discount = priceForOne*quantity - total;
        return new Discount(product, xQuantity + " for " + priceForThatQuantity, discount);
    }
}
