package model;

public class Order {
    private String buyerName;
    private String listOfProducts;
    private String dateOfSale;
    private double totalPrice;
    private Product product;
    private Product[] productsArray;


    public Order(String buyerName, String listOfProducts, String dateOfSale, double totalPrice, Product[] productsArray){

        this.buyerName=buyerName;
        this.listOfProducts=listOfProducts;
        this.dateOfSale=dateOfSale;
        this.totalPrice=totalPrice;
        this.productsArray=productsArray;

    }





}
