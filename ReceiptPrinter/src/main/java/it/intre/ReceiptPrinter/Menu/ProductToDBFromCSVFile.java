package it.intre.ReceiptPrinter.Menu;

import static it.intre.ReceiptPrinter.ReceiptPrinter.inputProductToDBFromCSVFile;

public class ProductToDBFromCSVFile implements IMenuOption {
    public void menuOptionFunction() {
        inputProductToDBFromCSVFile();
    }
}
