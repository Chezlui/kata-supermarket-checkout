package dojo.supermarket.model;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<ReceiptItem> items = new ArrayList<>();

    public Double getTotalPrice() {
        double total = 0.0;
        for (ReceiptItem item : this.items) {
            total += item.getPrice();
        }
        return total;
    }

    public void addProduct(Product p, double price) {
        this.items.add(new ReceiptItem(p, price));
    }

    private class ReceiptItem {
        private final Product product;
        private final double price;

        public ReceiptItem(Product p, double price) {
            this.product = p;
            this.price = price;
        }

        public double getPrice() {
            return this.price;
        }
    }
}
