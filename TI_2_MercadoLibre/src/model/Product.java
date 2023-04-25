package model;

public class Product {

    private String productName;
    private String description;
    private double price;
    private int quantity;
    private int numberOfSales;
    private int category;

    public Product(String productName, String description, double price, int quantity, int category){
        this.productName=productName;
        this.description=description;
        this.price=price;
        this.quantity=quantity;
        this.category=category;
        this.numberOfSales=0;

    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName(){
        String cat="";
        switch (category){
            case 1: cat="Libros";
                break;
            case 2:cat="Electronica";
                break;
            case 3: cat="Ropa y accesorios";
                break;
            case 4:cat="Alimentos y bebidas";
                break;
            case 5:cat="Papeleria";
                break;
            case 6:cat="Deportes";
                break;
            case 7:cat="Productos de belleza y cuidado personal";
                break;
            case 8:cat="Juguetes y juegos";
                break;
        }
        return cat;
    }
    public String getProductInfo() {
        return "Nombre: "+productName+"\n Descripcion: "+description+"\n Precio: "+price+";  Cantidad: "+quantity+"\n Ventas totales: "+numberOfSales+";  Categoria: "+getCategoryName();
    }

}
