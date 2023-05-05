package model;

public class Order {
    private String buyerName;
    private String listOfProducts;
    private String dateOfSale;
    private double totalPrice;
    private Product product;
    private Product[] productsArray;


    public Order(String buyerName, String listOfProducts, String dateOfSale, Product[] productsArray){

        this.buyerName=buyerName;
        this.listOfProducts=listOfProducts;
        this.dateOfSale=dateOfSale;
        this.totalPrice=calculateTotalPrice();
        this.productsArray=productsArray;

    }

    private double calculateTotalPrice() {
        return 0;
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
