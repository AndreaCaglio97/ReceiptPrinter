package it.intre.ReceiptPrinter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadWrite {
    public static Receipt readProductFromFileCSV() {
        String fileName = "C:\\i3\\Projects\\ReceiptPrinter\\ReceiptPrinter\\src\\main\\java\\it\\intre\\ReceiptPrinter\\ProductList.csv";
        Receipt receipt = new Receipt();
        try {
            Scanner inputStream = new Scanner(new File(fileName));
            String line = inputStream.nextLine();
            while (inputStream.hasNextLine()) {
                line = inputStream.nextLine();
                String[] productAttributes = line.split(",");
                String name = productAttributes[0];
                boolean isImported = Boolean.parseBoolean(productAttributes[1]);
                double price = Double.parseDouble(productAttributes[2]);
                Category category = Category.valueOf(productAttributes[3]);
                int quantity = Integer.parseInt(productAttributes[4]);
                Product product = new Product(name,isImported,price,category,quantity);
                receipt.addNewProduct(product);
            }
            inputStream.close();
        } catch(FileNotFoundException e) {
            System.out.println("Cannot find file " + fileName);
        }
        return receipt;
    }
}
