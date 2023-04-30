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

}
