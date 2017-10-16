package it.intre.ReceiptPrinter.CommandLine;

import java.util.InputMismatchException;
import java.util.Scanner;
import static it.intre.ReceiptPrinter.CommandLine.InputProductManager.inputProductToDBFromCommandLine;
import static it.intre.ReceiptPrinter.ReceiptPrinter.*;

public class MenuManager {

    static Scanner keyboard = new Scanner(System.in);
    private int choice;

    private void setChoice(int choice) {
        this.choice = choice;
    }

    private void printList() {
        System.out.println("Menu':\n\t" +
                           "1)Insert products to DB from the command line\n\t" +
                           "2)Create a receipt and print it in the command line\n\t" +
                           "3)Create a receipt from a .csv file and print it on a .txt file\n\t" +
                           "4)Get products from DB and print a receipt in the command line\n\t" +
                           "5)Insert products to DB from a .csv file\n\t" +
                           "6)Exit");
    }

    private void insertChoice() {
        boolean isInputValid;
        do {
            printList();
            try{
                setChoice(keyboard.nextInt());
            }catch(InputMismatchException e) {
                keyboard.nextLine();
                setChoice(-1);
            }finally{
                isInputValid = checkValidChoice();
            }
        }while(!isInputValid);
    }

    private boolean checkValidChoice() {
        boolean check;
        if((choice < 1)||(choice > 6)) {
            System.out.println("ERROR! Invalid input! You must insert a number between 1 and 6");
            check = false;
        } else {
            check = true;
        }
        return check;
    }

    private void selectFunctionAccordingToChoice() {
        if(choice == 1) {
            inputProductToDBFromCommandLine();
        } else if(choice == 2) {
            inputProductsOutputTerminal();
        } else if(choice == 3) {
            inputProductsFromCSVFileOutputTXTFile();
        } else if(choice == 4) {
            inputProductsFromDBOutputTerminal();
        } else if(choice == 5){
            inputProductToDBFromCSVFile();
        }
    }

    public void printMenu() {
        do {
            insertChoice();
            selectFunctionAccordingToChoice();
        }while(choice != 6);
    }
}
