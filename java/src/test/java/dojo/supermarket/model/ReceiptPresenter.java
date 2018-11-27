package dojo.supermarket.model;

import dojo.supermarket.ReceiptPrinter;

public class ReceiptPresenter {

    public static String present(Receipt receipt) {
        StringBuilder b = new StringBuilder();
        for (ReceiptItem item : receipt.getItems()) {
            b.append(ReceiptItemPresenter.present(item));
            b.append("\n");
        }
        for (Discount discount: receipt.getDiscounts()) {
            b.append(DiscountPresenter.presentDiscount(discount));
            b.append("\n");
        }
        b.append("Total: ");
        b.append(ReceiptPrinter.presentPrice(receipt.getTotalPrice()));
        return b.toString();
    }
}

class ReceiptItemPresenter {
    static String present(ReceiptItem item) {
        return "ReceiptItem{" +
                "product=" + ReceiptPrinter.presentProduct(item.getProduct()) +
                ", quantity=" + ReceiptPrinter.presentQuantity(item) +
                ", price=" + ReceiptPrinter.presentPrice(item.getPrice()) +
                ", totalPrice=" + ReceiptPrinter.presentPrice(item.getTotalPrice()) +
                '}';
    }
}

class DiscountPresenter {

    public static String presentDiscount(Discount discount) {
        return "Discount: " + discount.getDescription() + "(" + ReceiptPrinter.presentProduct(discount.getProduct()) + ") -" + ReceiptPrinter.presentPrice(discount.getDiscountAmount());
    }
}