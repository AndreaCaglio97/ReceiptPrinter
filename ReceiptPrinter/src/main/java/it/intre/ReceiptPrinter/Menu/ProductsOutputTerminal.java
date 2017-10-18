package it.intre.ReceiptPrinter.Menu;

import it.intre.ReceiptPrinter.ReceiptPrinter;


public class ProductsOutputTerminal implements IMenuOption {
    public void menuOptionFunction() {
        ReceiptPrinter receiptPrinter = new ReceiptPrinter();
        receiptPrinter.inputProductsOutputTerminal();
    }
}
