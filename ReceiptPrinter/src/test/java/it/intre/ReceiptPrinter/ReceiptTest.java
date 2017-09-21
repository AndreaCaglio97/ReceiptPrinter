package it.intre.ReceiptPrinter;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ReceiptTest {
    @Test
    public void addNewProductOnReceiptTest()
    {
        Product product = new Product("IPhone X",true, 1400, Category.GENERAL ,1);
        Receipt r = new Receipt();
        r.addNewProduct(product);
        assertTrue(r.getReceipt().contains(product));
    }

    @Test
    public void calculationOfTaxTest()
    {
        Receipt r = new Receipt();
        Product book = new Product("Book",false,12.49,Category.BOOK,1);
        Product musicCD = new Product("Music CD",false,14.99,Category.GENERAL,1);
        Product chocolateBar = new Product("Chocolate bar",false,0.85,Category.FOOD,1);
        r.addNewProduct(book);
        r.addNewProduct(musicCD);
        r.addNewProduct(chocolateBar);
        double taxAmount = r.calculationOfTax();
        assertEquals(1.50,taxAmount,0.001);
    }

    @Test
    public void calculationOfTotalTest()
    {
        Receipt r = new Receipt();
        Product boxOfChocolate = new Product("Box of chocolate",true,10.00,Category.FOOD,1);
        Product bottleOfPerfume = new Product("Bottle of perfume",true,47.50,Category.GENERAL,1);
        r.addNewProduct(boxOfChocolate);
        r.addNewProduct(bottleOfPerfume);
        r.calculationOfTax();
        double total = r.calculationOfTotal();
        assertEquals(65.15,total,0.001);
    }

    @Test
    public void calculationOfTaxAndTotalTest()
    {
        Receipt r = new Receipt();
        Product iBottleOfPerfume = new Product("Imported bottle of perfume",true,27.99,Category.GENERAL,1);
        Product bottleOfPerfume = new Product("Bottle of perfume",false,18.99,Category.GENERAL,1);
        Product packetOfHeadachePills = new Product("Packet of headache pills",false,9.75,Category.MEDICINE,1);
        Product boxOfChocolate = new Product("Box of chocolate",true,11.25,Category.FOOD,1);
        r.addNewProduct(iBottleOfPerfume);
        r.addNewProduct(bottleOfPerfume);
        r.addNewProduct(packetOfHeadachePills);
        r.addNewProduct(boxOfChocolate);
        double taxAmount = r.calculationOfTax();
        double total = r.calculationOfTotal();
        assertEquals(6.70,taxAmount,0.001);
        assertEquals(74.68,total,0.001);
    }

    /*@Test
    public void calculationOfTaxOfImportedGeneralProductTest()
    {
        Product productBeforeTax = new Product("IPhone X",true, 1400, Category.GENERAL ,1);
        calculationOfTaxTest(productBeforeTax,1610,210,15);
    }

    @Test
    public void calculationOfTaxOfNotImportedGeneralProductTest()
    {
        Product productBeforeTax = new Product("Orologio Armani",false, 250, Category.GENERAL ,1);
        calculationOfTaxTest(productBeforeTax,275,25,10);
    }

    @Test
    public void calculationOfTaxOfImportedNotGeneralProductTest()
    {
        Product productBeforeTax = new Product("Champagne",true, 500, Category.FOOD ,1);
        calculationOfTaxTest(productBeforeTax,525,25,5);
    }

    @Test
    public void calculationOfTaxOfNotImportedNotGeneralProductTest()
    {
        Product productBeforeTax = new Product("Barolo Riserva",false, 650, Category.FOOD ,1);
        calculationOfTaxTest(productBeforeTax,650,0,0);
    }*/
}
