package it.intre.ReceiptPrinter.CommandLine;

import it.intre.ReceiptPrinter.models.*;

import java.util.InputMismatchException;
import java.util.Scanner;

import static it.intre.ReceiptPrinter.database.DBManager.*;
import static it.intre.ReceiptPrinter.models.Category.*;

public class InputProductManager {

    static Scanner keyboard = new Scanner(System.in);

    public static void inputProductToDBFromCommandLine() {
        String other;
        Product product;
        do {
            product = createProduct();
            insertSingleProductToDB(product);
            other = answerYesNo("Do you want to insert another product?");
        }while(other.equalsIgnoreCase("yes"));
    }

    private static Product createProduct() {
        Product product = new Product();
        product.setName(insertProductName());
        product.setImported(isProductImported());
        product.setPrice(insertProductPrice());
        product.setCategory(insertProductCategory());
        return product;
    }

    private static String insertProductName() {
        System.out.println("Insert the product name: ");
        return keyboard.nextLine();
    }

    private static boolean isProductImported() {
        boolean isImported = false;
        String answer = answerYesNo("Is the product imported? ");
        if(answer.equalsIgnoreCase("yes"))
            isImported = true;
        return isImported;
    }

    private static double insertProductPrice() {
        double price = 0;
        boolean isInputValid;
        do {
            System.out.println("Insert the product price: ");
            try{
                price = keyboard.nextDouble();
            }catch(InputMismatchException e)
            {
                keyboard.nextLine();
                price = -1;
            }finally{
                isInputValid = checkValidInputPrice(price);
            }
        }while(!isInputValid);
        return price;
    }

    private static boolean checkValidInputPrice(double number) {
        boolean check;
        if(number < 0.01) {
            System.err.println("ERROR! Invalid input! ");
            check = false;
        }
        else {
            check = true;
        }
        return check;
    }


    public static Category insertProductCategory() {
        int answer = 0;
        boolean isInputValid;
        do {
            System.out.println("Choose the product Category:\n\t1)FOOD\n\t2)BOOK\n\t3)MEDICINE\n\t4)GENERAL\n\t5)NOT_GENERAL");
            try{
                answer = keyboard.nextInt();
            }catch(InputMismatchException e) {
                keyboard.nextLine();
                answer = -1;
            }finally{
                isInputValid = checkValidInputCategory(answer);
            }
        }while(!isInputValid);
        return getCategory(answer);
    }

    public static boolean checkValidInputCategory(int number) {
        boolean check;
        if((number < 1)||(number > 5)) {
            System.err.println("ERROR! Invalid input! ");
            check = false;
        }
        else {
            check = true;
        }
        return check;
    }

    private static String answerYesNo(String message) {
        String answer;
        do {
            System.out.println(message);
            answer = keyboard.nextLine();
            if((!answer.equalsIgnoreCase("yes")) && (!answer.equalsIgnoreCase("no")))
                System.err.println("ERROR! Invalid answer!");
        }while((!answer.equalsIgnoreCase("yes")) && (!answer.equalsIgnoreCase("no")));
        return answer;
    }
}
