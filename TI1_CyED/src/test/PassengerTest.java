package test;
import junit.framework.TestCase;
import model.Passenger;

public class PassengerTest extends TestCase {
    private Passenger passenger;


    public void setupStage1(){

    }
    public void setupStage2(){
        passenger = new Passenger("Lucas","1193",2, "A",200, false,true,false);
    }
    public void setupStage3(){
        passenger = new Passenger("Julian","2143",5, "A");
    }

    public void testPassenger(){
        setupStage1();
        Passenger p1 = new Passenger("Lucas","1193",2, "A",200, false,true,false);
        passenger = p1;
        assertEquals(p1, passenger);
    }

    public void testGetPriority(){
        setupStage2();
        assertEquals(3, passenger.getPriority());
    }

    public void testGetPriority2(){
        setupStage3();
        assertEquals(0, passenger.getPriority());
    }

}
