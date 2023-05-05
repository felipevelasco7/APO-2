package model;

import java.util.ArrayList;

public class Controller {
    public ArrayList<Product> products;
    public ArrayList<Order> orders;

    public Controller(){
        products=new ArrayList<Product>();
        orders=new ArrayList<Order>();

    }
    public String registerProducts(String productName, String description, double price, int quantity, int category){
        String msg="";
        Product objProd= new Product(productName, description, price, quantity,category);
        products.add(objProd);
        msg="Producto agregado exitosamente";
        return msg;
    }

    public String registerOrder(String buyerName, String listOfProducts, String dateOfSale){
        String msg="";
        String[] productNamesArray = listOfProducts.split(",");

        Product[] productsArray = new Product[5];

        Order objOrder= new Order(buyerName, listOfProducts, dateOfSale, productsArray);
        orders.add(objOrder);
        msg="Orden agregada exitosamente";
        return msg;
    }

    public String deleteProduct(String productName){
        return "Producto eliminado exitosamente";

    }

    public String IncreaseQuantity(String productName,int amount){
        return "Cantidad actualizada exitosamente";

    }


    public Product searchProductbyName(String productName){
        int x= products.size();
        int productIndex=-2;
        if(x>0) productIndex=searchProductIndex(productName, 0, x-1);

        if (productIndex >=0) {
            return products.get(productIndex);
        } else { //no se encontro
            return null;
        }
    }
    private int searchProductIndex(String productName, int start, int end){
        if(start>end){
            return -1;
        }
        int mid=(start+end)/2;
        int compareResult = productName.compareTo(products.get(mid).getProductName());

        if (compareResult == 0) {//caso base, retorna el indice donde se encontro el producto
            return mid;
        } else if (compareResult < 0) {
            return searchProductIndex(productName, start, mid - 1);
        } else {
            return searchProductIndex(productName, mid + 1, end);
        }

    }

    public String findProducts(String minProdName, String maxProdName, int aORd) {
        return " ";
    }
    public String findProducts(double minPrice, double maxPrice, int aORd) {
        return " ";
    }

    public String findOrders(String minBuyerName, String maxBuyerName, int aORd) {
        return " ";
    }
    public String findOrders(double minPrice, double maxPrice, int aORd) {
        return " ";
    }
}
