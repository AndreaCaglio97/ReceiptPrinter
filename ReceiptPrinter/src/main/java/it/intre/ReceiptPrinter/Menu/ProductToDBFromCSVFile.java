package it.intre.ReceiptPrinter.Menu;

import it.intre.ReceiptPrinter.ReceiptPrinter;


public class ProductToDBFromCSVFile implements IMenuOption {
    public void menuOptionFunction() {
        ReceiptPrinter receiptPrinter = new ReceiptPrinter();
        receiptPrinter.inputProductToDBFromCSVFile();
    }
}
