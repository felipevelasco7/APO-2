package model;
import java.util.Calendar;

public class Order {
    private String buyerName;
    private String listOfProducts;
    private String dateOfSale;
    private double totalPrice;
    private Calendar date;
    private Product[] productsArray;


    public Order(String buyerName, String listOfProducts, String dateOfSale, Product[] pArray, Calendar date){

        this.buyerName=buyerName;
        this.listOfProducts=listOfProducts;
        this.dateOfSale=dateOfSale;
        this.productsArray= pArray;
        this.totalPrice=calculateTotalPrice();
        this.date=date;
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
    public String getOrderInfo() {
        return "Nombre del comprados: "+buyerName+"\n Productos: "+listOfProducts+"\n fecha: "+dateOfSale+";  precio: "+totalPrice;

    }

    public Calendar getDate() {
        return date;
    }

    public String getDateOfSale() {
        return dateOfSale;
    }
}
