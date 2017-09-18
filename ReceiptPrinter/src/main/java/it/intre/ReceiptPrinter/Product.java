package it.intre.ReceiptPrinter;

public class Product {
    private String name;
    private boolean isImported;
    private double price;
    private String category;
    private int quantity;
    private double taxAmount;
    private int taxPercentage;

    public Product(String name,boolean isImported,double price,String category,int quantity,double taxAmount,int taxPercentage){
        setName(name);
        setImported(isImported);
        setPrice(price);
        setCategory(category);
        setQuantity(quantity);
        setTaxAmount(taxAmount);
        setTaxPercentage(taxPercentage);
    }

    public Product(String name,boolean isImported,double price,String category,int quantity) {
        this(name,isImported,price,category,quantity,0,0);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setImported(boolean imported) {
        isImported = imported;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private void setCategory(String category) {
        this.category = category;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public void setTaxPercentage(int taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public String getName() {
        return name;
    }

    public boolean isImported() {
        return isImported;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public int getTaxPercentage() {
        return taxPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (isImported != product.isImported) return false;
        if (Double.compare(product.price, price) != 0) return false;
        if (quantity != product.quantity) return false;
        if (Double.compare(product.taxAmount, taxAmount) != 0) return false;
        if (taxPercentage != product.taxPercentage) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        return category != null ? category.equals(product.category) : product.category == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (isImported ? 1 : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + quantity;
        temp = Double.doubleToLongBits(taxAmount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + taxPercentage;
        return result;
    }
}
