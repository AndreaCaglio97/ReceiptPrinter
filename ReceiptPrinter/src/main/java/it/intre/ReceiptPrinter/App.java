package it.intre.ReceiptPrinter;

public class App {
    public static void main( String[] args )
    {
        /*Product productBeforeTax = new Product("IPhone X",true, 1400, Category.GENERAL ,1);
        Product productBeforeTax2 = new Product("Barolo Riserva",false, 650, Category.FOOD ,1);
        Receipt r = new Receipt();
        r.addNewProduct(productBeforeTax);
        r.addNewProduct(productBeforeTax2);
        r.calculationOfTax();
        for(Product product : r.getReceipt())
        {
            System.out.println(product.toString());
        }*/
        /*double n1 = 0.023;
        double n2 = 0.063;

        double rounded1 = ((double) (long) (n1 * 20 + 0.5)) / 20;
        double rounded2 = ((double) (long) (n2 * 20 + 0.5)) / 20;

        double amount = 990.49;
        double rounded = ((double) (long) (amount * 20 + 0.5)) / 20;

        System.out.println(n1);
        System.out.println(rounded1);
        System.out.println(n2);
        System.out.println(rounded2);
        System.out.println(amount);
        System.out.println(rounded);*/

        /*double n1 = 0.023;
        System.out.println(n1);
        n1 = n1*20;
        n1 = Math.ceil(n1);
        n1 /= 20;
        System.out.println(String.format( "%.2f", n1 ));

        double n2 = 0.063;
        System.out.println(n2);
        n2 = n2*20;
        n2 = Math.ceil(n2);
        n2 /= 20;
        System.out.println(String.format( "%.2f", n2 ));

        double n3 = 0.054;
        System.out.println(n3);
        n2 = Math.ceil(n2*20)/20;
        System.out.println(String.format( "%.2f", n2 ));*/

        Receipt r = new Receipt();
        Product iBottleOfPerfume = new Product("Imported bottle of perfume",true,27.99,Category.GENERAL,1);
        Product bottleOfPerfume = new Product("Bottle of perfume",false,18.99,Category.GENERAL,1);
        Product packetOfHeadachePills = new Product("Packet of headache pills",false,9.75,Category.MEDICINE,1);
        Product boxOfChocolate = new Product("Box of chocolate",true,11.25,Category.FOOD,1);
        r.addNewProduct(iBottleOfPerfume);
        r.addNewProduct(bottleOfPerfume);
        r.addNewProduct(packetOfHeadachePills);
        r.addNewProduct(boxOfChocolate);
        r.printReceipt();
    }
}
