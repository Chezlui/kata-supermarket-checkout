package dojo.supermarket;

import dojo.supermarket.model.*;
import org.approvaltests.Approvals;
import org.junit.Test;

public class ReceiptPrinterTest {

    Product toothbrush = new Product("toothbrush", ProductUnit.Each);
    Product apples = new Product("apples", ProductUnit.Kilo);

    @Test
    public void oneLineItem() {
        ReceiptItem item = new ReceiptItem(toothbrush, 1, 0.99, 0.99);
        Approvals.verify(new ReceiptPrinter(40).printReceiptLineItem(item));
    }

    @Test
    public void quantityTwo() {
        ReceiptItem item = new ReceiptItem(toothbrush, 2, 0.99,0.99 * 2);
        Approvals.verify(new ReceiptPrinter(40).printReceiptLineItem(item));
    }

    @Test
    public void looseWeight() {
        ReceiptItem item = new ReceiptItem(apples, 2.3, 1.99,1.99 * 2.3);
        Approvals.verify(new ReceiptPrinter(40).printReceiptLineItem(item));
    }

    @Test
    public void total() {

        Receipt receipt = new Receipt();
        receipt.addProduct(toothbrush, 1, 0.99, 2*0.99);
        receipt.addProduct(apples, 0.75, 1.99, 1.99*0.75);
        Approvals.verify(new ReceiptPrinter(40).printTotal(receipt));
    }

    @Test
    public void discounts() {
        Receipt receipt = new Receipt();
        receipt.addDiscount(new Discount(apples, "3 for 2", 0.99));
        Approvals.verify(new ReceiptPrinter(40).printDiscounts(receipt));
    }

    @Test
    public void printWholeReceipt() {
        Receipt receipt = new Receipt();
        receipt.addProduct(toothbrush, 1, 0.99, 0.99);
        receipt.addProduct(toothbrush, 2, 0.99, 2*0.99);
        receipt.addProduct(apples, 0.75, 1.99, 1.99*0.75);
        receipt.addDiscount(new Discount(toothbrush, "3 for 2", 0.99));
        Approvals.verify(new ReceiptPrinter(40).printReceipt(receipt));
    }

}
