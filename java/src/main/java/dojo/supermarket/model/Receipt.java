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

    void addProduct(Product p, int quantity,  double price) {
        this.items.add(new ReceiptItem(p, quantity, price));
    }

    public List<ReceiptItem> getItems() {
        return new ArrayList<>(this.items);
    }

}
