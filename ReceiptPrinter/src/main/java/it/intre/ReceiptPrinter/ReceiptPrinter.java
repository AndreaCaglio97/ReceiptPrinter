package it.intre.ReceiptPrinter;


import it.intre.ReceiptPrinter.items.Category;
import it.intre.ReceiptPrinter.items.Product;
import it.intre.ReceiptPrinter.items.Receipt;

import java.sql.Connection;

import static it.intre.ReceiptPrinter.database.DBManager.*;

public class ReceiptPrinter {
    public static void inputProductsOutputTerminal()
    {
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

    public static void inputProductsFromCSVFileOutputTXTFile()
    {
        Receipt receipt = new Receipt();
        receipt.readProductFromFileCSV("ProductList.csv");
        receipt.writeReceiptOnFileFormatted();
    }

    public static void main( String[] args )
    {
        //inputProductsOutputTerminal();
        //inputProductsFromCSVFileOutputTXTFile();
        Connection conn = connectionToDB();
        //viewTable(conn);
        Product p1 = productFromDB(1,conn);
        Product p2 = productFromDB(2,conn);
        Product p3 = productFromDB(3,conn);
        Receipt receipt = new Receipt();
        receipt.addNewProduct(p1);
        receipt.addNewProduct(p2);
        receipt.addNewProduct(p3);
        receipt.printReceipt();
        CloseConnectionToDB(conn);
    }
}
