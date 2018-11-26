package dojo.supermarket.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

    private final List<Product> items = new ArrayList<>();

    List<Product> getItems() {
        return new ArrayList<>(items);
    }

    void addItem(Product product) {
        items.add(product);
    }

    Map<Product, Integer> productQuantities() {
        Map<Product, Integer> productQuantities = new HashMap<>();
        for (Product p : getItems()) {
            if (productQuantities.containsKey(p)) {
                productQuantities.put(p, productQuantities.get(p) + 1);
            } else {
                productQuantities.put(p, 1);
            }
        }
        return productQuantities;
    }


}
