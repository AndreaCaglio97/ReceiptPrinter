package it.intre.ReceiptPrinter.Menu;

import it.intre.ReceiptPrinter.ReceiptPrinter;


public class ProductsFromDBOutputTerminal implements IMenuOption {
    public void menuOptionFunction() {
        ReceiptPrinter receiptPrinter = new ReceiptPrinter();
        receiptPrinter.inputProductsFromDBOutputTerminal();
    }
}
