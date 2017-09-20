package it.intre.ReceiptPrinter;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;


public class AppTest {

    @Test
    public void createNewProductTest()
    {
        Product product = new Product("IPhone X",true, 1400, Category.GENERAL ,1);
        assertEquals("IPhone X",product.getName());
        assertEquals(true,product.isImported());
        assertEquals(1400,product.getPrice(),0.001);
        assertEquals(Category.GENERAL,product.getCategory());
        assertEquals(1,product.getQuantity());
        assertEquals(0,product.getTaxAmount(),0.001);
        assertEquals(0,product.getTaxPercentage());
    }

    @Test
    public void addNewProductOnReceiptTest()
    {
        Product product = new Product("IPhone X",true, 1400, Category.GENERAL ,1);
        Receipt r = new Receipt();
        r.addNewProduct(product);
        assertTrue(r.getReceipt().contains(product));
    }


    private void calculationOfTaxTest(Product productBeforeTax,double expectedPrice,double expectedTaxAmount,int expectedTaxPercentage)
    {
        Receipt r = new Receipt();
        r.addNewProduct(productBeforeTax);
        r.calculationOfTax();
        double price = 0;
        double taxAmount  =0;
        int taxPercentage = 0;
        for(Product product : r.getReceipt()) {
            price=product.getPrice();
            taxAmount=product.getTaxAmount();
            taxPercentage=product.getTaxPercentage();
        }
        assertEquals(expectedPrice,price,0.001);
        assertEquals(expectedTaxAmount,taxAmount,0.001);
        assertEquals(expectedTaxPercentage,taxPercentage);
    }

    @Test
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
    }

}
