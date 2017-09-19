package it.intre.ReceiptPrinter;

public class App {
    public static void main( String[] args )
    {
        Product product = new Product("IPhone X",true, 1400, Category.GENERAL ,1);
        System.out.println(product.getPrice());
    }
}
