package model;

import java.util.ArrayList;

public class Controller {
    private ArrayList<Product> products;
    private ArrayList<Order> orders;

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

        Order objOrder= new Order(buyerName, listOfProducts, dateOfSale, totalPrice, productsArray);
        orders.add(objOrder);
        msg="Orden agregada exitosamente";
        return msg;
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
}
