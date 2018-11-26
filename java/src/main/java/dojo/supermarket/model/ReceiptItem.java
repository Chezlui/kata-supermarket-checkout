package dojo.supermarket.model;

import java.util.Objects;

public class ReceiptItem {
    private final Product product;
    private final double price;
    private final int quantity;

    public ReceiptItem(Product p, int quantity, double price) {
        this.product = p;
        this.quantity = quantity;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptItem that = (ReceiptItem) o;
        return Double.compare(that.price, price) == 0 &&
                quantity == that.quantity &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {

        return Objects.hash(product, price, quantity);
    }
}
