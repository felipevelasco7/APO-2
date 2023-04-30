package test;
import junit.framework.TestCase;
import model.PriorityQ;
import model.Passenger;

public class PriorityQTest extends TestCase{
    private PriorityQ priorityQ;
    public void setupStage1(){
        priorityQ = new PriorityQ();
    }
    public void setupStage2(){
        setupStage1();
        Passenger p1 = new Passenger("Lucas","1193",2, "A",200, false,true,false);
        priorityQ.push(p1,-3);

    }
    public void setupStage3(){
        setupStage2();
        Passenger p2 = new Passenger("Julian","2143",2, "B",300, false,true,false);
        priorityQ.push(p2,-5);
    }


}
