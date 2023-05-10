package ui;
import java.util.Scanner;
import model.Controller;

public class Main {
    public static Controller controller;
    public static Scanner input=new Scanner(System.in);

    public static void main(String[] args)  {
        controller= new Controller();
        menu();

    }

    private static void menu() {
        System.out.println();
        System.out.println("Menu: Ingrese el numero de la opcion que desea realizar");
        System.out.println("1. Registrar producto");
        System.out.println("2. Registrar orden");
        System.out.println("3. Aumentar la cantidad de un producto.");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Buscar un producto");
        System.out.println("6. Busar una orden");

        System.out.println("7. Cerrar programa");
        String choice= input.nextLine();
        switch (choice) {
            case "1":
                registerProduct();
                break;
            case "2":
                registerOrder();
                break;
            case "3":
                System.out.println("Aumentar cantidad de un producto:\nIngrese el nombre del producto:");
                String prodName=input.nextLine();
                System.out.println("Ingrese la cantidad a aumentar");
                int amount=Integer.parseInt(input.nextLine());
                System.out.println(controller.IncreaseQuantity(prodName, amount));
                break;
            case "4":
                System.out.println("Eliminar un producto:\nIngrese el nombre del producto:");
                String productName=input.nextLine();
                System.out.println(controller.deleteProduct(productName));
                break;
            case "5":
                searchProducts();
                break;
            case "6":
                searchOrders();
                break;
            case "7":
                System.out.println("Gracias");
                break;
            default:
                System.out.println("Ingrese una opcion valida");
        }
        if(!choice.equalsIgnoreCase("7")) menu();
    }

    private static void searchOrders() {
        System.out.println("Buscar ordenes");
        System.out.println("1. Para buscar por rango\n2. Para buscar una orden especifica");
        boolean range=false;
        if (input.nextLine().equals("1")) range=true   ;

        System.out.println("1. Buscar por nombre del comprador");
        System.out.println("2. Buscar por precio total");
        System.out.println("3. Buscar por fecha de compra");
        System.out.println("4. Volver");
        String choice= input.nextLine();
        int aORd=1;
        if (range){
            System.out.println("1.Para mostrar los resultados en orden ascendent\n 2.Para mostrarlos en orden descendente");
            if(input.nextLine().equals("2")) aORd=2;
        }

        switch (choice) {
            case "1":
                if(range) {
                    System.out.println("Ingrese el rago de nombre minimo del comprador:");
                    String min=input.nextLine();
                    System.out.println("Ingrese el rago de nombre maximo del comprador:");
                    controller.findOrders(min,input.nextLine(),aORd);
                }else {
                    System.out.println("Ingrese el nombre del comprador:");
                    controller.searchOrderByName(input.nextLine());
                }
                break;
            case "2":
                if(range) {
                    System.out.println("Ingrese el rago de precio minimo:");
                    double min=input.nextDouble();
                    System.out.println("Ingrese el rago de precio maximo:");
                    controller.findOrders(min,input.nextDouble(),aORd);
                }else{
                    System.out.println("Ingrese el precio:");
                    controller.searchOrderByPrice(input.nextDouble());
                }
                break;
            case "3":
                if(range) {
                    System.out.println("Ingrese el rago de fecha minimo en formato dia/mes/ano:");
                    String min=input.nextLine();
                    System.out.println("Ingrese el rago de fecha maximo en formato dia/mes/ano:");
                    System.out.println(controller.findOrdersByDate(min,input.nextLine(),aORd));
                }else{
                    System.out.println("Ingrese la fecha de la compra en formato dia/mes/ano :");
                    System.out.println(controller.searchOrderByDate(input.nextLine()));
                }
                break;
            case "4":
                break;
            default:
                System.out.println("Ingrese una opcion valida");
                searchOrders();
        }
    }
    private static void searchProducts() {
        System.out.println("Buscar productos");
        System.out.println("1. Para buscar por rango\n2. Para buscar un producto especifico");
        boolean range=false;
        if (input.nextLine().equals("1")) range=true   ;

        System.out.println("\n1. Buscar por nombre");
        System.out.println("2. Buscar por precio");
        System.out.println("3. Buscar por categoria");
        System.out.println("4. Buscar por numero de veces comprado");
        String choice= input.nextLine();
        int aORd=1;
        if (range){
            System.out.println("1.Para mostrar los resultados en orden ascendente\n 2.Para mostrarlos en orden descendente");
            if(input.nextLine().equals("2")) aORd=2;
        }

        switch (choice) {
            case "1":
                if(range) {
                    System.out.println("Ingrese el rago de nombre minimo del producto:");
                    String min=input.nextLine();
                    System.out.println("Ingrese el rago de nombre maximo del producto:");
                    System.out.println(controller.findProducts(min,input.nextLine(),aORd));
                }else {
                    System.out.println("Ingrese el nombre del producto:");
                    System.out.println(controller.searchProductbyName(input.nextLine()));
                }
                break;
            case "2":
                if(range) {
                    System.out.println("Ingrese el rago de precio minimo:");
                    double min=input.nextDouble();
                    System.out.println("Ingrese el rago de precio maximo:");
                    System.out.println(controller.findProducts(min,input.nextDouble(),aORd));
                }else {
                    System.out.println("Ingrese el precio del producto:");
                    System.out.println(controller.searchProductByPrice(input.nextDouble()));
                }
                break;
            case "3":
                System.out.println("Ingrese la categoria del producto:\n1.Libros\n2.Electronica\n3.Ropa y accesorios\n4.Alimentos y bebidas\n5.Papeleria\n6.Deportes\n7.Productos de belleza y cuidado personal\n8.Juguetes y juegos");
                System.out.println(controller.searchProductByCat(Integer.parseInt(input.nextLine())));
                break;
            case "4":
                if(range) {
                    System.out.println("Ingrese el rago de veces comprado minimo:");
                    double min=input.nextDouble();
                    System.out.println("Ingrese el rago de veces comprado maximo:");
                    System.out.println(controller.findProductsBySales(min,input.nextDouble(),aORd));
                }else {
                    System.out.println("Ingrese el numero de veces comprado:");
                    System.out.println(controller.searchProductBySales(Integer.parseInt(input.nextLine())));
                }
                break;
            default:
                System.out.println("Ingrese una opcion valida");
                searchProducts();
        }
    }

    private static void registerProduct() {
        System.out.println("Registrar producto");

        System.out.println("Ingrese el nombre del producto");
        String prodName= input.nextLine();
        System.out.println("Ingrese la descripcion del producto");
        String descr= input.nextLine();
        System.out.println("Ingrese el precio del producto");
        double price= input.nextDouble();
        System.out.println("Ingrese la cantidad del producto");
        int quantity= Integer.parseInt(input.nextLine());
        System.out.println("Ingrese la categoria del producto: \n1. Libros \n2.Electrónica \n3.Ropa y accesorios \n4.Alimentos y bebidas \n5.Papelería \n6. Deportes \n7.Productos de belleza y cuidado personal \n8.Juguetes y juegos");
        int cat= Integer.parseInt(input.nextLine());
        System.out.println(controller.registerProducts(prodName,descr,price,quantity,cat));
    }
    private static void registerOrder() {
        System.out.println("Registar pedido");

        System.out.println("Ingrese el nombre del compradios");
        String buyer= input.nextLine();
        System.out.println("Ingrese la lista de productos separados colamente por comas.");
        String prodList= input.nextLine();
        System.out.println("Ingrese la fecha de compra en formato dia/mes/ano");
        String dateOfSale= input.nextLine();
        System.out.println(controller.registerOrder(buyer,prodList,dateOfSale));
    }


}