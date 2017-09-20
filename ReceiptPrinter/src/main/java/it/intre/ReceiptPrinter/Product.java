package it.intre.ReceiptPrinter;

public class Product {
    private String name;
    private boolean isImported;
    private double price;
    private Category category;
    private int quantity;
    private double taxAmount;
    private int taxPercentage;

    public Product(String name,boolean isImported,double price,Category category,int quantity,double taxAmount,int taxPercentage){
        this.name=name;
        this.isImported=isImported;
        this.price=price;
        this.category=category;
        this.quantity=quantity;
        this.taxAmount=taxAmount;
        this.taxPercentage=taxPercentage;
    }

    public Product(String name,boolean isImported,double price,Category category,int quantity) {
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

    private void setCategory(Category category) {
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

    public Category getCategory() {
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
        return category == product.category;
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

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", isImported=" + isImported +
                ", price=" + price +
                ", category=" + category +
                ", quantity=" + quantity +
                ", taxAmount=" + taxAmount +
                ", taxPercentage=" + taxPercentage +
                '}';
    }
}
