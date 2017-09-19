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

    /*@Test
    public void calculationOfTaxOfImportedGeneralProductTest()
    {
        Product productBeforeTax = new Product("IPhone X",true, 1400, Category.GENERAL ,1);
        Product productAfterTax = new Product("IPhone X",true, 1610, Category.GENERAL ,1,210,15);
        Receipt r = new Receipt();
        r.addNewProduct(productBeforeTax);
        r.calculationOfTax();
        assertTrue(r.getReceipt().contains(productAfterTax));
    }*/

}
