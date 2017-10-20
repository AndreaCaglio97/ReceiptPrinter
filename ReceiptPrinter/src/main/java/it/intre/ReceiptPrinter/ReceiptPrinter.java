package it.intre.ReceiptPrinter;


import it.intre.ReceiptPrinter.Menu.MenuManager;
import it.intre.ReceiptPrinter.models.Category;
import it.intre.ReceiptPrinter.models.Product;
import it.intre.ReceiptPrinter.models.Receipt;

import static it.intre.ReceiptPrinter.database.DBManager.*;

public class ReceiptPrinter {
    public void inputProductsOutputTerminal() {
        Receipt r = new Receipt();
        Product iBottleOfPerfume = new Product("Imported bottle of perfume",true,27.99, Category.GENERAL,1);
        Product bottleOfPerfume = new Product("Bottle of perfume",false,18.99,Category.GENERAL,1);
        Product packetOfHeadachePills = new Product("Packet of headache pills",false,9.75,Category.MEDICINE,1);
        Product boxOfChocolate = new Product("Box of chocolate",true,11.25,Category.FOOD,1);
        r.addNewProduct(iBottleOfPerfume);
        r.addNewProduct(bottleOfPerfume);
        r.addNewProduct(packetOfHeadachePills);
        r.addNewProduct(boxOfChocolate);
        r.printReceipt();
    }

    public void inputProductsFromCSVFileOutputTXTFile() {
        Receipt receipt = new Receipt();
        receipt.readProductFromFileCSV("ProductList.csv");
        receipt.writeReceiptOnFileFormatted();
        System.out.println("The location of receipt.text is C:\\i3\\Projects\\ReceiptPrinter\\ReceiptPrinter");
    }


    public void inputProductToDBFromCSVFile() {
        inputDBProductFromFileCSV("insertQueryProductList.csv");
    }

    public static void main( String[] args ) {
        MenuManager menuManager = new MenuManager();
        menuManager.printMenu();
    }
}
