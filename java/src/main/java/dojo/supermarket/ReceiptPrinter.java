package dojo.supermarket;

import dojo.supermarket.model.ReceiptItem;

import java.util.stream.IntStream;

public class ReceiptPrinter {

    private final int columns;

    public ReceiptPrinter(int columns) {
        this.columns = columns;
    }

    public String printReceiptLineItem(ReceiptItem item) {
        String price = "" + item.getPrice();
        String quantity = " * " + item.getQuantity();
        String name = item.getProduct().getName();

        String line;
        if (item.getQuantity() > 1) {
            int whitespaceSize = this.columns - quantity.length() - price.length();
            line = name + "\n";
            line += quantity + getWhitespace(whitespaceSize) + price + "\n";
        } else {
            int whitespaceSize = this.columns - name.length() - price.length();
            line = name + getWhitespace(whitespaceSize) + price + "\n";
        }
        return line;
    }

    private String getWhitespace(int whitespaceSize) {
        StringBuilder whitespace = new StringBuilder();
        for (int i = 0; i < whitespaceSize; i++) {
            whitespace.append(" ");
        }
        return whitespace.toString();
    }
}
