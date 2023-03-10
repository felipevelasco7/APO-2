import java.util.Scanner;

public class Main {
    public static Scanner input=new Scanner(System.in);
    static private Parking parking;

    public static void main(String[] args) {
        parking = new Parking();
        boolean seguir=true;
        while( seguir=true){
            menu();

        }

        


    }


    public static void menu(){
        System.out.println("El vehiculo es: \n1. un carro \n2. una moto");
        String type= input.nextLine();
        System.out.println("Ingrese la placa");
        String plate= input.nextLine();
        System.out.println("Ingrese la cedula");
        String id= input.nextLine();
        
        try {
            System.out.println(parking.addVehicle(type, plate, id));
            
        } catch (CapacityException e) {
            System.out.println(e);        
        } catch (IdException e) {
            System.out.println(e);
        } catch (PlateNumberException e) {
            System.out.println(e);
        } catch (HourException e) {
        System.out.println(e);
        }
    
    }


}