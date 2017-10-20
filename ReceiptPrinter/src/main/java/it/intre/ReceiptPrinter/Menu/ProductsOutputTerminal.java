package it.intre.ReceiptPrinter.Menu;

import it.intre.ReceiptPrinter.CommandLine.InputProductManager;


public class ProductsOutputTerminal implements IMenuOption {
    public void menuOptionFunction() {
        InputProductManager inputProductManager = new InputProductManager();
        inputProductManager.inputProductToReceiptFromCommandLine();
    }
}
