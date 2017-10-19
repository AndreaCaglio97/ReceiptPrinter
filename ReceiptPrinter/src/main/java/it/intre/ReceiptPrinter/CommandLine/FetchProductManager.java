package it.intre.ReceiptPrinter.CommandLine;

import it.intre.ReceiptPrinter.models.Product;
import it.intre.ReceiptPrinter.models.Receipt;

import java.util.InputMismatchException;
import java.util.Scanner;

import static it.intre.ReceiptPrinter.CommandLine.InputProductManager.*;
import static it.intre.ReceiptPrinter.database.DBManager.*;

public class FetchProductManager {
    static Scanner keyboard = new Scanner(System.in);

    public void fetchProductFromDB() {
        int idProduct;
        Product product;
        Receipt receipt = new Receipt();
        String other;
        do {
            idProduct=insertProductId();//farà anche il check per controllare se esite l'id
                                         //del prodotto tramite una select che conta il numero dei prodotti
                                         //con quell'id (deve essercene 1)
            product = productFromDB(idProduct);
            receipt.addNewProduct(product);
            other = answerYesNo("Do you want to insert another product?");
        }while(other.equalsIgnoreCase("yes"));
    }

    private static int insertProductId() {
        int answer = 0;
        boolean isInputValid;
        do {
            System.out.println("Insert the product Id: ");
            try{
                answer = keyboard.nextInt();
            }catch(InputMismatchException e) {
                keyboard.nextLine();
                answer = -1;
            }finally{
                isInputValid = checkValidInputProductId(answer);
            }
        }while(!isInputValid);
        return answer;
    }

    public static boolean checkValidInputProductId(int idProduct) {
        boolean check;
        if((idProduct < 1)||(!checkIdProductExist(idProduct))) {
            System.out.println("ERROR! Invalid input! You must insert an existing product Id");
            check = false;
        }
        else {
            check = true;
        }
        return check;
    }

    private static boolean checkIdProductExist(int idProduct) {
        //chiama un metodo che usa una select per vedere se esite il prodotto nel db
        return false;
    }

}
