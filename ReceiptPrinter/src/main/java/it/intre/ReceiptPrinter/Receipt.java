package it.intre.ReceiptPrinter;

import java.util.HashSet;
import java.util.Set;

public class Receipt {
    private Set<Product> receipt;

    public Receipt()
    {
        receipt = new HashSet<Product>();
    }

    public Set<Product> getReceipt() {
        return receipt;
    }

    public void addNewProduct(Product product)
    {
        receipt.add(product);
    }

    public double calculationOfTax()
    {
        double taxAmount=0;
        for(Product product : receipt) {
            taxAmount += product.singleProductTax();
        }
        return taxAmount;
    }

    public double calculationOfTotal()
    {
        double total=0;
        for(Product product : receipt) {
            total += product.getPrice();
        }
        return total;
    }

    public void printReceipt()
    {
        double taxAmount = calculationOfTax();
        double total = calculationOfTotal();
        System.out.println("RECEIPT");
        System.out.println();
        for(Product product : receipt) {
            System.out.println(product.toString());
        }
        System.out.println();
        System.out.println("Total taxes: " + String.format( "%.2f", taxAmount ) + "€");
        System.out.println("Total:" + String.format( "%.2f", total ) + "€");
    }

}
