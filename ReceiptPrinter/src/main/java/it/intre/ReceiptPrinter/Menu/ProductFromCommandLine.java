package it.intre.ReceiptPrinter.Menu;

import static it.intre.ReceiptPrinter.CommandLine.InputProductManager.*;

public class ProductFromCommandLine implements IMenuOption {
    public void menuOptionFunction() {
        inputProductToDBFromCommandLine();
    }
}
