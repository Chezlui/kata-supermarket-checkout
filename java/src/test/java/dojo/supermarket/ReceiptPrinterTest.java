package dojo.supermarket;

import dojo.supermarket.model.Product;
import dojo.supermarket.model.ReceiptItem;
import org.approvaltests.Approvals;
import org.junit.Test;

public class ReceiptPrinterTest {

    Product toothbrush = new Product("toothbrush");

    @Test
    public void oneLineItem() {
        ReceiptItem item = new ReceiptItem(toothbrush, 1, 0.99);
        Approvals.verify(new ReceiptPrinter(40).printReceiptLineItem(item));
    }

    @Test
    public void quantityTwo() {
        ReceiptItem item = new ReceiptItem(toothbrush, 2, 0.99 * 2);
        Approvals.verify(new ReceiptPrinter(40).printReceiptLineItem(item));
    }

}
