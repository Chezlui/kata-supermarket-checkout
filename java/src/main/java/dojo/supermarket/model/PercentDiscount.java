package dojo.supermarket.model;

public class PercentDiscount extends Offer {
    private final Product product;
    private final double percentDiscount;

    public PercentDiscount(Product product, double percentDiscount) {
        this.product = product;
        this.percentDiscount = percentDiscount;
    }

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public Discount getDiscount(Product product, double quantity, double priceForOne) {
        return new Discount( product, this.percentDiscount + "% off", quantity*priceForOne*this.percentDiscount/100.0);
    }
}
