package it.intre.ReceiptPrinter.CommandLine;

import java.util.Scanner;

import static it.intre.ReceiptPrinter.database.DBManager.*;

public class InputProductManager {

    static Scanner keyboard = new Scanner(System.in);

    public static void inputProductToDBFromCommandLine()
    {
        String other;
        String[] productAttributes;
        do
        {
            productAttributes = inputProductAttributes();
            insertSingleProductToDB(productAttributes);
            other = answerOtherProduct();
        }while(other.equalsIgnoreCase("yes"));
    }

    public static String[] inputProductAttributes()
    {
        return null;
    }

    public static String answerOtherProduct()
    {
        String other = null;
        do
        {
            System.out.println("Do you want to insert another product?");
            other = keyboard.nextLine();

        }while(other==null); //controllo correttezza risposta
        return other;
    }
}
