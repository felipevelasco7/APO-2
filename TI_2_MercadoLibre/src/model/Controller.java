package model;

import java.util.ArrayList;

public class Controller {
    public ArrayList<Product> products;
    public ArrayList<Order> orders;

    public Controller()  {
        products= new ArrayList<>();
        orders= new ArrayList<>();
    }
    public String registerProducts(String productName, String description, double price, int quantity, int category){
        String msg="";
        Product objProd= new Product(productName, description, price, quantity,category);
        products.add(objProd);
        msg="Producto agregado exitosamente";
        organizeProdByname();
        return msg;
    }

    public String registerOrder(String buyerName, String listOfProducts, String dateOfSale) {
        String[] productNamesArray = listOfProducts.split(",");
        Product[] productsArray = new Product[productNamesArray.length];

        for (int i = 0; i < productNamesArray.length; i++) {
            Product prod =searchProductbyName(productNamesArray[i]);
            if (prod!=null) productsArray[i]=prod;
            else return "El Producto "+productNamesArray[i]+" No esta registrado";
        }

        Order objOrder= new Order(buyerName, listOfProducts, dateOfSale, productsArray);
        orders.add(objOrder);
        return "Orden agregada exitosamente";
    }

    public String deleteProduct(String productName){
        int i=searchProductIndex(productName,0,products.size()-1);
        if(i==-1) return "Este producto no esta registrada";
        else products.remove(i);
        return "Producto eliminado exitosamente";

    }

    public String IncreaseQuantity(String productName,int amount){
        Product prod= searchProductbyName(productName);
        System.out.println(prod);
        if(prod==null) return "Este Producto no esta registrado";
        else prod.setQuantity(prod.getQuantity()+amount);

        return "Cantidad actualizada exitosamente";
    }

    public Product searchProductbyName(String productName){
        int x= products.size();
        int productIndex=-2;
        if(x>0) productIndex=searchProductIndex(productName, 0, x-1);

        if (productIndex >=0) {
            return products.get(productIndex);
        } else { //no se encontro(-1) o no hay productos registrsdos(-2)
            return null;
        }
    }
    public int searchProductIndex(String productName, int start, int end){
        if(start>end){
            return -1;
        }
        int mid=(start+end)/2;
        int compareResult = productName.compareTo(products.get(mid).getProductName());//=0 significa que es igual
        if (compareResult == 0) {//caso base, retorna el indice donde se encontro el producto
            return mid;
        } else if (compareResult < 0) {//es menor que 0, esta a la izquierda
            return searchProductIndex(productName, start, mid - 1);
        } else {
            return searchProductIndex(productName, mid + 1, end);//busca a la derecha
        }
    }
    private void organizeProdByname() {
        for (int i = 0; i < products.size(); i++) {
            for (int j = 1; j < products.size()-i; j++) {
                if(products.get(j).getProductName().compareTo(products.get(j-1).getProductName())<0){
                    // get values to swap
                    Product anterior = products.get(j-1);
                    Product actual = products.get(j);
                    // swap
                    products.set(j,anterior);
                    products.set(j-1,actual);
                }
            }
        }
        System.out.println("Lista:\n"+products);
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
