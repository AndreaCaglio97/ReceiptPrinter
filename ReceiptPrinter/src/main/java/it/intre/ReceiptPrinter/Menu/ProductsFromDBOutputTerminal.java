package it.intre.ReceiptPrinter.Menu;

import it.intre.ReceiptPrinter.CommandLine.FetchProductManager;


public class ProductsFromDBOutputTerminal implements IMenuOption {
    public void menuOptionFunction() {
        FetchProductManager fetchProductManager = new FetchProductManager();
        fetchProductManager.fetchProductFromDB();
    }
}
