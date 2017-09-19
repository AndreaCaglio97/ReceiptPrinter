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

    public void calculationOfTax()
    {
        int taxPercentage=0;
        for(Product product : receipt)
        {
            if(product.getCategory()==Category.GENERAL);
            {
                taxPercentage+=10;
            }
            if(product.isImported())
            {
                taxPercentage+=5;
            }
            if(taxPercentage!=0)
            {
                product.setTaxPercentage(taxPercentage);
            }
        }
    }

}
