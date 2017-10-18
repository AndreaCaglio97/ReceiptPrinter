package it.intre.ReceiptPrinter.Menu;

import it.intre.ReceiptPrinter.ReceiptPrinter;


public class CSVFileOutputTXTFile implements IMenuOption {
    public void menuOptionFunction() {
        ReceiptPrinter receiptPrinter = new ReceiptPrinter();
        receiptPrinter.inputProductsFromCSVFileOutputTXTFile();
    }
}
