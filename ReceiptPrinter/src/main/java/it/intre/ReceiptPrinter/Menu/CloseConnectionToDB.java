package it.intre.ReceiptPrinter.Menu;

import it.intre.ReceiptPrinter.database.ConnectionManager;

public class CloseConnectionToDB implements IMenuOption {
    public void menuOptionFunction() {
        ConnectionManager.getConnectionSingleton().closeConnectionToDB();
    }
}
