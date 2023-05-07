package test;
import junit.framework.TestCase;
import model.Controller;

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
        controller.registerOrder("Simon","camisa,cuaderno","21/5/2023");
    }

    public void testDeleteProduct(){
        setupStage2();
        controller.deleteProduct("cuaderno");
        assertEquals(2, controller.products.size());
    }
    public void testDeleteProduct2() {
        setupStage2();
        System.out.println(controller.deleteProduct("silla"));
    }

    public void testIncreaseQuantity()  {
        setupStage2();
        System.out.println(controller.IncreaseQuantity("cuaderno",2));
        assertEquals(5, controller.searchProductbyName("cuaderno").getQuantity());
    }

    public void testIncreaseQuantity2(){
        setupStage2();
        try {
            controller.IncreaseQuantity("silla",2);

        } catch (Exception e) {
            System.out.println("Este producto no esta registrado");
        }
    }
    public void testRegisterProduct()  {
        setupStage1();
        controller.registerProducts("camiseta", "talla m", 15, 5, 3);//3=ropa
        assertEquals("camiseta", controller.products.get(0).getProductName());
        assertEquals("talla m", controller.products.get(0).getDescription());
        assertEquals("Ropa y accesorios", controller.products.get(0).getCategoryName());

    }

    public void testRegisterProduct2()  {
        setupStage2();
        controller.registerProducts("camiseta", "talla m", 15, 5, 3);//3=ropa
        assertEquals(4, controller.products.size());
    }

    public void testRegisterOrder()  {
        setupStage2();
        System.out.println(controller.registerOrder("Carlos", "cuaderno,megafono", "21/2/2023"));
        assertEquals(0, controller.orders.size());

    }
    public void testSearchProductbyName()  {
        setupStage2();
        System.out.println(controller.searchProductIndex("cuaderno", 0, 3-1));
        System.out.println(controller.searchProductbyName("cuaderno").getProductName());
        assertEquals("cuaderno", controller.searchProductbyName("cuaderno").getProductName());
    }

    public void testRegisterOrder2() {
        setupStage2();
        System.out.println(controller.registerOrder("Carlos", "cuaderno,audifonos", "21/2/2023" ));
        assertEquals(53.0, controller.orders.get(0).getTotalPrice());
        assertEquals(1, controller.orders.size());
    }

    public void testFindProducts()  {
        setupStage2();
        assertEquals("camisa\ncuaderno", controller.findProducts("C","M",1 ));
    }
    public void testFindProducts2()  {
        setupStage2();
        assertEquals("audifonos\ncuaderno", controller.findProducts(20,30,1 ));
    }
    public void testFindOrders() {
        setupStage5();
        assertEquals("camisa\ncuaderno", controller.findOrders("A","G",2 ));
    }
    public void testFindOrders2()  {
        setupStage5();
        assertEquals("audifonos\ncuaderno", controller.findOrders(0,50,1 ));
    }



}