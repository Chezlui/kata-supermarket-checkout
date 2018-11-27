package dojo.supermarket;

import dojo.supermarket.model.*;

import java.util.Map;

public class ReceiptPrinter {

    private final int columns;

    public ReceiptPrinter(int columns) {
        this.columns = columns;
    }

    public String printReceiptLineItem(ReceiptItem item) {
        String price = presentPrice(item.getTotalPrice());
        String quantity = presentQuantity(item);
        String name = presentProduct(item.getProduct());
        String unitPrice = presentPrice(item.getPrice());

        int whitespaceSize = this.columns - name.length() - price.length();
        String line = name + getWhitespace(whitespaceSize) + price + "\n";

        if (item.getQuantity() != 1) {
            line += "  " + unitPrice + " * " + quantity + "\n";
        }
        return line;
    }

    public String printDiscounts(Receipt receipt) {
        StringBuilder discountsText = new StringBuilder();
        for (Discount discount: receipt.getDiscounts()) {
            discountsText.append(printDiscount(discount));
        }
        return discountsText.toString();
    }

    public String printDiscount(Discount discount) {
        StringBuilder discountsText = new StringBuilder();

        String productPresentation = ReceiptPrinter.presentProduct(discount.getProduct());
        String pricePresentation = ReceiptPrinter.presentPrice(discount.getDiscountAmount());
        String description = discount.getDescription();
        discountsText.append(description);
        discountsText.append("(");
        discountsText.append(productPresentation);
        discountsText.append(")");
        discountsText.append(getWhitespace(this.columns - 3 - productPresentation.length() - description.length() - pricePresentation.length()));
        discountsText.append("-");
        discountsText.append(pricePresentation);
        discountsText.append("\n");
        return discountsText.toString();
    }

    public String printTotal(Receipt receipt) {
        String pricePresentation = presentPrice(receipt.getTotalPrice());
        String total = "Total: ";
        String whitespace = getWhitespace(this.columns - total.length() - pricePresentation.length());
        return total + whitespace + pricePresentation;
    }

    public static String presentProduct(Product product) {
        return product.getName();
    }

    public static String presentPrice(double price) {
        return String.format("%.2f", price);
    }

    public static String presentQuantity(ReceiptItem item) {
        return ProductUnit.Each.equals(item.getProduct().getUnit())
                ? String.format("%x", (int)item.getQuantity())
                : String.format("%.3f", item.getQuantity());
    }

    public static String getWhitespace(int whitespaceSize) {
        StringBuilder whitespace = new StringBuilder();
        for (int i = 0; i < whitespaceSize; i++) {
            whitespace.append(" ");
        }
        return whitespace.toString();
    }

    public String printReceipt(Receipt receipt) {
        StringBuilder result = new StringBuilder();
        for (ReceiptItem item : receipt.getItems()) {
            result.append(printReceiptLineItem(item));
        }
        for (Discount discount : receipt.getDiscounts()) {
            result.append(printDiscount(discount));
        }
        result.append("\n");
        result.append(printTotal(receipt));
        return result.toString();
    }
}
