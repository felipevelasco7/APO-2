
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;


public class Parking {
    LocalDate date = LocalDate.now();


    static private Vehicle vehicles;

    private Vehicle[] cars;
    private Vehicle[] motorcycles;




    public Parking() {
        cars= new Vehicle[100];
        motorcycles= new Vehicle[200];

    }

    public String addVehicle(String type, String plate, String id) throws CapacityException, IdException, PlateNumberException, HourException{
       
        if(type.equals("1")&&cars[cars.length-1]!=null){
            throw new CapacityException("Ya no hay mas cupos para carros");
        }
        if(type.equals("2")&&motorcycles[motorcycles.length-1]!=null){
            throw new CapacityException("Ya no hay mas cupos para motos");
        }
        if(!checkId(id)){
            throw new IdException("No puede entrar, tiene pico y cedula");
        }
        if(type.equals("1") && !checkCarPlate(plate)){
            throw new PlateNumberException("No puede entrar, tiene pico y placa");
        }
        if(type.equals("2") && !checkBikePlate(plate)){
            throw new PlateNumberException("No puede entrar, tiene pico y placa");
        }
        
        vehicles = new Vehicle(type, plate, id);
        return "Vehiculo agregado exitosamente";
        
    }

    private boolean checkBikePlate(String plate){
        boolean enter=true;
        LocalTime time = LocalTime.now();
        int hour = time.getHour();
        int plateNum= plate.charAt(plate.length()-2)*10+plate.charAt(plate.length()-1);

        if (hour>22 || hour<7) enter=false;
        if ((plateNum <50) && hour>14 ) enter=false;
        if ((plateNum <100 && plateNum>50) && hour<15) enter=false;

        return enter;
    }

    private boolean checkCarPlate(String plate){
        boolean enter=true;
        LocalTime time = LocalTime.now();
        int hour = time.getHour();
        
        char firstChar = plate.charAt(0);

        if (hour>22 || hour<7) enter=false;
        if ((firstChar >= 'A' && firstChar <= 'M') && hour>14 ) enter=false;
        if ((firstChar > 'M' && firstChar <= 'Z') && hour<15) enter=false;

        return enter;
    }

    private boolean checkId(String id){
        boolean enter=true;
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int dayOfWeekInt = dayOfWeek.getValue();
        int lastDigit = Character.getNumericValue(id.charAt(id.length()-1));

        System.out.println(dayOfWeekInt);

        if(dayOfWeekInt==1 && lastDigit<2) enter=false;
        if(dayOfWeekInt==2 && lastDigit>1 && lastDigit<4) enter=false;
        if(dayOfWeekInt==3 && lastDigit>3 && lastDigit<6) enter=false;
        if(dayOfWeekInt==4 && lastDigit>5 && lastDigit<8) enter=false;
        if(dayOfWeekInt==5 && (lastDigit==8 || lastDigit==9)) enter=false;

        return enter;
    }
    
}
