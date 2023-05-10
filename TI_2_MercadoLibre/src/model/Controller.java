package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Controller {
    public ArrayList<Product> products;
    public ArrayList<Order> orders;

    public Controller()  {
        products= new ArrayList<>();
        orders= new ArrayList<>();
    }

    //Registrar
    public String registerProducts(String productName, String description, double price, int quantity, int category){
        String msg="";
        Product objProd= new Product(productName, description, price, quantity,category);
        products.add(objProd);
        msg="Producto agregado exitosamente";
        organizeProdByName();
        return msg;
    }
    public String registerOrder(String buyerName, String listOfProducts, String dateOfSale) {

        String[] productNamesArray = listOfProducts.split(",");
        Product[] productsArray = new Product[productNamesArray.length];

        for (int i = 0; i < productNamesArray.length; i++) {
            int index=searchProductIndex(productNamesArray[i], 0, products.size()-1);
            if (index>=0) {
                Product prod= products.get(index);
                productsArray[i] = prod;
                productsArray[i].setQuantity(productsArray[i].getQuantity()-1);
                productsArray[i].setNumberOfSales(productsArray[i].getNumberOfSales()+1);
            }
            else return "El Producto "+productNamesArray[i]+" No esta registrado";
        }

        Order objOrder= new Order(buyerName, listOfProducts, dateOfSale, productsArray,createDate(dateOfSale));
        orders.add(objOrder);
        System.out.println(objOrder + " precio "+ objOrder.getTotalPrice()+ objOrder.getBuyerName());
        return "Orden agregada exitosamente";
    }

    //crear fecha
    public Calendar createDate(String dateString) {
        String[] parts = dateString.split("/");
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[0]);
        int year = Integer.parseInt(parts[2]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return calendar;
    }

    //Borrar
    public String deleteProduct(String productName){
        int i=searchProductIndex(productName,0,products.size()-1);
        if(i==-1) return "Este producto no esta registrada";
        else products.remove(i);
        return "Producto eliminado exitosamente";

    }

    //Agregar cantidades
    public String IncreaseQuantity(String productName,int amount){
        Product prod= products.get(searchProductIndex(productName, 0, products.size()-1));
        System.out.println(prod);
        if(prod==null) return "Este Producto no esta registrado";
        else prod.setQuantity(prod.getQuantity()+amount);

        return "Cantidad actualizada exitosamente";
    }

    //Organizar Productos
    private void organizeProdByName() {
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
    }
    private void organizeProdByPrice() {
        for (int i = 0; i < products.size(); i++) {
            for (int j = 1; j < products.size()-i; j++) {
                if(products.get(j).getPrice() > products.get(j-1).getPrice()){
                    // get values to swap
                    Product anterior = products.get(j-1);
                    Product actual = products.get(j);
                    // swap
                    products.set(j,anterior);
                    products.set(j-1,actual);
                }
            }
        }
    }
    private void organizeProdBySales() {
        for (int i = 0; i < products.size(); i++) {
            for (int j = 1; j < products.size()-i; j++) {
                if(products.get(j).getNumberOfSales() > products.get(j-1).getNumberOfSales()){
                    // get values to swap
                    Product anterior = products.get(j-1);
                    Product actual = products.get(j);
                    // swap
                    products.set(j,anterior);
                    products.set(j-1,actual);
                }
            }
        }
    }


    //Buscar Productos
    public String searchProductbyName(String productName){
        int x= products.size();
        int productIndex=-2;
        if(x>0) productIndex=searchProductIndex(productName, 0, x-1);

        if (productIndex >=0) {
            return products.get(productIndex).getProductInfo();
        } else { //no se encontro(-1) o no hay productos registrsdos(-2)
            return "Este producto no esta registradp";
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
    public String searchProductByPrice(double price){
        organizeProdByPrice();
        int begin = 0;
        int end = products.size() - 1;
        while (begin <= end){
            int mid = (end+begin)/2;
            double midValue = products.get(mid).getPrice();
            if(midValue == price){                                  //cuando lo encuentra
                return products.get(mid).getProductInfo();
            }else if(price > midValue){
                begin = mid+1;
            }else if(price < midValue){
                end = mid-1;
            }
        }
        return "No hay un producto con ese precio";
    }
    public String searchProductByCat(int cat){
        String names="";
        for (Product p : products) {
            String pName =p.getProductName();
            if(p.getCategory()==cat){
                names+="\n"+pName;
            }
        }
        return names;
    }
    public String searchProductBySales(int sales){
        organizeProdBySales();
        int begin = 0;
        int end = products.size() - 1;
        while (begin <= end){
            int mid = (end+begin)/2;
            int midValue = products.get(mid).getNumberOfSales();
            if(midValue == sales){                                  //cuando lo encuentra
                return products.get(mid).getProductInfo();
            }else if(sales > midValue){
                begin = mid+1;
            }else if(sales < midValue){
                end = mid-1;
            }
        }
        return "No hay un producto con estas ventas";

    }


    //Encontrar Productos por rango
    public String findProducts(String startStr, String endStr, int aORd) {
        //int n = Math.min(startStr.length(), endStr.length());
        String names="";
        int l1=startStr.length();
        int l2=endStr.length();
        for (Product p : products) {
            String pName =p.getProductName();
            if (pName.substring(0,l1 ).compareToIgnoreCase(startStr.substring(0, l1)) >= 0 && pName.substring(0, l2).compareToIgnoreCase(endStr.substring(0, l2)) <= 0) {
                if(aORd==2) names ="\n"+pName +names;
                else names+="\n"+pName;     //ascendente
            }
        }
        names="Productos en rango "+ startStr+" a "+endStr+" :"+names;
        return names;
    }
    public String findProducts(double minPrice, double maxPrice, int aORd) {
        String names="";

        for (Product p : products) {
            if (p.getPrice() >= minPrice && p.getPrice() <= maxPrice) {
                double price=p.getPrice();
                String pName =p.getProductName()+" precio: "+price;
                if(aORd==2) names ="\n"+pName +names; //orden descendente
                else names+="\n"+pName; //ascendente
            }
        }
        names="Productos en rango de precio "+ minPrice+" a "+maxPrice+" :"+names;
        return names;
    }
    public String findProductsBySales(double minSales, double maxSales, int aORd){
        organizeProdBySales();
        String names="";

        for (Product p : products) {
            if (p.getNumberOfSales() >= minSales && p.getNumberOfSales() <= maxSales) {
                int sales= p.getNumberOfSales();
                String pName =p.getProductName()+" numero de ventas: "+sales;
                if(aORd==2) names ="\n"+pName +names; //orden descendente
                else names+="\n"+pName; //ascendente
            }
        }
        names="Productos con ventas en rango "+ minSales+" a "+maxSales+" :"+names;
        return names;
    }


    //Organizar Ordenes
    public void organizeOrdersByPrice() {//menor a mayor
        for (int rojo = 0; rojo < orders.size() - 1; rojo++) {
            for (int azul = rojo + 1; azul < orders.size(); azul++) {
                if (orders.get(rojo).getTotalPrice() > orders.get(azul).getTotalPrice()) {
                    // get values to swap
                    Order valorRojo = orders.get(rojo);
                    Order valorAzul = orders.get(azul);
                    // swap
                    orders.set(rojo, valorAzul);
                    orders.set(azul, valorRojo);
                }
            }
        }
    }
    public void organizeOrdersByName() {
        for (int i = 0; i < orders.size(); i++) {
            for (int j = 1; j < orders.size()-i; j++) {
                if(orders.get(j).getBuyerName().compareTo(orders.get(j-1).getBuyerName())<0){
                    // get values to swap
                    Order anterior = orders.get(j-1);
                    Order actual = orders.get(j);
                    // swap
                    orders.set(j,anterior);
                    orders.set(j-1,actual);
                }
            }
        }
        System.out.println(" Ordenes por nombre :\n"+orders);
    }
    public void organizeOrdersByDate() {
        for (int i = 0; i < orders.size(); i++) {
            for (int j = 1; j < orders.size()-i; j++) {
                if(orders.get(j).getDate().before((orders.get(j-1).getDate()))){
                    // get values to swap
                    Order anterior = orders.get(j-1);
                    Order actual = orders.get(j);
                    // swap
                    orders.set(j,anterior);
                    orders.set(j-1,actual);
                }
            }
        }
        System.out.println(" Ordenes por nombre :\n"+orders);
    }


    //Buscar Ordenes
    public String searchOrderByName(String buyerName){
        int x= orders.size();
        int orderIndex=-2;
        if(x>0) orderIndex=searchOrderIndex(buyerName, 0, x-1);

        if (orderIndex >=0) {
            return orders.get(orderIndex).getOrderInfo();
        } else { //no se encontro(-1) o no hay ordenes registrsdos(-2)
            return "No se encontro la orden";
        }
    }
    public int searchOrderIndex(String buyerName, int start, int end){
        if(start>end){
            return -1;
        }
        int mid=(start+end)/2;
        int compareResult = buyerName.compareTo(orders.get(mid).getBuyerName());//=0 significa que es igual
        if (compareResult == 0) {//caso base, retorna el indice donde se encontro el producto
            return mid;
        } else if (compareResult < 0) {//es menor que 0, esta a la izquierda
            return searchOrderIndex(buyerName, start, mid - 1);
        } else {
            return searchOrderIndex(buyerName, mid + 1, end);//busca a la derecha
        }
    }
    public String searchOrderByPrice(double price){
        organizeOrdersByPrice();
        int begin = 0;
        int end = orders.size() - 1;
        while (begin <= end){
            int mid = (end+begin)/2;
            double midValue = orders.get(mid).getTotalPrice();
            if(midValue == price){                                  //cuando lo encuentra
                return orders.get(mid).getOrderInfo();
            }else if(price > midValue){
                begin = mid+1;
            }else if(price < midValue){
                end = mid-1;
            }
        }
        return "No hay un producto con ese precio";
    }
    public String searchOrderByDate(String d) {
        Calendar date=createDate(d);
        organizeOrdersByDate();
        int begin = 0;
        int end = orders.size() - 1;
        while (begin <= end){
            int mid = (end+begin)/2;
            Calendar midValue = orders.get(mid).getDate();
            if(midValue == date){                                  //cuando lo encuentra
                return orders.get(mid).getOrderInfo();
            }else if(date.after(midValue)){
                begin = mid+1;
            }else if(date.before(midValue)){
                end = mid-1;
            }
        }
        return "No hay una orden con esa fecha";
    }


    //Encontrar ordenes por rango
    public String findOrders(String minBuyerName, String maxBuyerName, int aORd) {
        String names="";
        int l1=minBuyerName.length();
        int l2=maxBuyerName.length();
        for (Order p : orders) {
            String pName =p.getBuyerName();
            if (pName.substring(0,l1 ).compareToIgnoreCase(minBuyerName.substring(0, l1)) >= 0 && pName.substring(0, l2).compareToIgnoreCase(maxBuyerName.substring(0, l2)) <= 0) {
                if(aORd==2) names ="\n"+pName +names;
                else names+="\n"+pName;     //ascendente
            }
        }
        names="Ordenes en rango "+ minBuyerName+" a "+maxBuyerName+" :"+names;
        return names;
    }
    public String findOrders(double minPrice, double maxPrice, int aORd) {
        String names="";
        for (Order p : orders) {
            if (p.getTotalPrice() >= minPrice && p.getTotalPrice() <= maxPrice) {
                String pName =p.getBuyerName();
                if(aORd==2) names ="\n"+pName +names; //orden descendente
                else names+="\n"+pName; //ascendente
                names+= " "+p.getTotalPrice();
            }
        }
        names="Ordenes en rango "+ minPrice+" a "+maxPrice+" :"+names;
        return names;
    }
    public String findOrdersByDate(String min, String max, int aORd) {
        Calendar minDate=createDate(min);
        Calendar maxDate=createDate(max);

        String names="";
        for (Order p : orders) {
            if (p.getDate().after(minDate)&& p.getDate().before(maxDate)) {

                String pName =p.getBuyerName()+" fecha: "+p.getDateOfSale();
                if(aORd==2) names ="\n"+pName +names; //orden descendente
                else names+="\n"+pName; //ascendente
                names+= " "+p.getTotalPrice();
            }
        }
        names="Ordenes en rango de fecha"+ min+" a "+max+" :"+names;
        return names;

    }





}
