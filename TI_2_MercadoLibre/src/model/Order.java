package model;

public class Order {
    private String buyerName;
    private String listOfProducts;
    private String dateOfSale;
    private double totalPrice;
    private Product[] productsArray;


    public Order(String buyerName, String listOfProducts, String dateOfSale, Product[] pArray){

        this.buyerName=buyerName;
        this.listOfProducts=listOfProducts;
        this.dateOfSale=dateOfSale;
        this.productsArray= pArray;
        this.totalPrice=calculateTotalPrice();


    }

    private double calculateTotalPrice() {
        double totalPrice=0;
        for (int i=0; i<productsArray.length;i++) {
            totalPrice+=productsArray[i].getPrice();
        }
        return totalPrice;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
