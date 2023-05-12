package test;
import junit.framework.TestCase;
import model.Controller;
import model.Order;
import model.Product;

public class ControllerTest extends TestCase {
    private Controller controller;

    public void setupStage1()  {
        controller = new Controller();
    }

    public void setupStage2()  {
        setupStage1();
        controller.registerProducts("camisa", "roja", 15, 5, 3);//3=ropa
        controller.products.get(0).setNumberOfSales(20);
        controller.registerProducts("cuaderno", "un cuaderno cuadriculado", 23, 3, 1);//1=libros
        controller.registerProducts("audifonos", "bluetooth", 30, 3, 2);//2=electronica
        controller.products.get(0).setNumberOfSales(10);
    }

    public void setupStage5() {
        setupStage2();
        controller.registerOrder("Carlos","cuaderno,audifonos","21/2/2023");
        controller.registerOrder("Gloria","audifonos","25/2/2023");
        controller.registerOrder("Simon","camisa,cuaderno","21/5/2021");
    }

    public void testRegisterOrder3(){
       setupStage1();
        System.out.println(controller.registerOrder("Carlos","cuaderno,audifonos","21/2/2023"));
    }
    public void testDeleteProduct(){
        setupStage1();
        for(int i=0;i<controller.products.size();i++){
            System.out.println(controller.products.get(i).getProductName());
        }
        System.out.println(controller.deleteProduct("camiseta"));
        for(int i=0;i<controller.products.size();i++){
            System.out.println(controller.products.get(i).getProductName());
        }

    }
    public void testDeleteProduct2() {
        setupStage2();
        System.out.println(controller.deleteProduct("silla"));
    }

    public void testIncreaseQuantity()  {
        setupStage2();
        System.out.println(controller.IncreaseQuantity("cuaderno",2));
        Product prod= controller.products.get(controller.searchProductIndex("cuaderno", 0, controller.products.size()-1));
        assertEquals(5, prod.getQuantity());
    }

    public void testIncreaseQuantity2(){
        setupStage2();
        controller.IncreaseQuantity("silla",2);
        System.out.println("Este producto no esta registrado");

    }
    public void testRegisterProduct()  {
        setupStage1();
        System.out.println(controller.registerProducts("camiseta", "talla m", 15, 5, 3));//3=ropa
        System.out.println(controller.searchProductbyName("camiseta"));

    }

    public void testRegisterProduct2()  {
        setupStage2();
        System.out.println(controller.registerProducts("camiseta", "talla m", 15, 5, 3));//3=ropa
        assertEquals(4, controller.products.size());
    }

    public void testRegisterOrder()  {
        setupStage2();
        System.out.println(controller.registerOrder("Carlos", "cuaderno,megafono", "21/2/2023"));

    }
    public void testSearchProductByName()  {
        setupStage2();
        Product prod= controller.products.get(controller.searchProductIndex("cuaderno", 0, controller.products.size()-1));
        assertEquals("cuaderno", prod.getProductName());
    }
    public void testSearchProductByPrice()  {
        setupStage2();
        System.out.println(controller.searchProductByPrice(233));
    }
    public void testRegisterOrder2() {
        setupStage2();
        System.out.println(controller.registerOrder("Carlos", "cuaderno,audifonos", "21/2/2023" ));
        assertEquals(53.0, controller.orders.get(0).getTotalPrice());
    }

    public void testFindProducts()  {
        setupStage2();
        String msg="Productos en rango C a CA :\n" + "camisa";
        System.out.println(controller.findProducts("C","CA",1 )); //Con mayusculas

    }
    public void testFindProducts2()  {
        setupStage2();
        String msg="Productos en rango de precio 20.0 a 30.0 :" + "\ncuaderno precio: 23.0\naudifonos precio: 30.0" ;
        assertEquals(msg, controller.findProducts(20,30,2 )); //en orden descendente
    }
    public void testFindProductsBySales()  {
        setupStage2();
        System.out.println(controller.findProductsBySales(10,40,2));//descendente

    }
    public void testFindOrders() {
        setupStage5();
        String msg="Ordenes en rango A a G :\n" + "Gloria\n" + "Carlos"; //orden descendente
        assertEquals(msg, controller.findOrders("A","G",2 ));
    }
    public void testFindOrders2()  {
        setupStage5();
        String msg="Ordenes en rango 0.0 a 50.0 :\n" + "Gloria 30.0\n" + "Simon 38.0";
        assertEquals(msg, controller.findOrders(0,50,1 ));
        controller.organizeOrdersByPrice();
    }
    public void testOrganizeOrdersByPrice()  {
        setupStage5();
        controller.organizeOrdersByPrice();
        assertEquals( 53.0, controller.orders.get(2).getTotalPrice());

        controller.organizeOrdersByName();
        assertEquals( "Gloria", controller.orders.get(1).getBuyerName());

    }

    public void testOrganizeOrdersByDate()  {
        setupStage5();
        controller.organizeOrdersByDate();
        for(int i=0;i<controller.orders.size();i++){
            System.out.println(controller.orders.get(i).getDate());
        }

    }
    public void testOrganizeOrdersByName()  {
        setupStage5();
        controller.organizeOrdersByName();
        for(int i=0;i<controller.orders.size();i++){
            System.out.println(controller.orders.get(i).getBuyerName());
        }
    }

    public void testFindOrdersByDate()  {
        setupStage5();
        System.out.println(controller.findOrdersByDate("11/3/2020","22/2/2023",1));
    }
    public void testSearchOrderByDate()  {
        setupStage5();
        System.out.println(controller.searchOrderByDate("21/2/2023" ));
    }
    public void testSearchOrderByPrice()  {
        setupStage5();
        System.out.println(controller.searchOrderByPrice(38.0 ));
    }
    public void testSearchOrderByName()  {
        setupStage5();
        System.out.println(controller.searchOrderByName("Simon" ));
    }

    public void testsSearchProductByCat()  {
        setupStage5();
        System.out.println(controller.findOrdersByDate("11/3/2020","22/2/2023",1));
    }
    public void testSearchProductBySales()  {
        setupStage2();
        System.out.println(controller.searchProductBySales(0));
    }
    public void testSearchProductByCat()  {
        setupStage2();
        System.out.println(controller.searchProductByCat(1));
    }






}