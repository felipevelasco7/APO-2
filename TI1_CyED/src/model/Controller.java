package model;

import java.util.ArrayList;

public class Controller {
    private FileReader reader;
    private ArrayList<PriorityQ<Passenger>> boardingOrder;
    private ArrayList<PriorityQ<Passenger>> unboardingOrder;


    public Controller() {
    }


    public String loadInfo(String pathName) throws Exception{
        reader = new FileReader(pathName);
        return reader.showPlaneSpecifications();
    }

    public String readArrivals(){
        reader.readArrivals();
        return reader.showArrivals();

    }

    public String showBoardingOrder() {
        boardingOrder = new ArrayList();
        for(int i = 0; i<reader.planeRows; i++){
            boardingOrder.add(new PriorityQ());
        }
        for(String id: reader.getArrivals()){
            Passenger p = reader.getPassengers().search(id);
            if(p.row <= reader.planeFirstClassRows ){
                int row =  reader.planeFirstClassRows - p.row;
                boardingOrder.get(row).push(p, p.priority, p.arrivalOrder);
            } else {
                int row =  reader.planeRows - p.row + reader.planeFirstClassRows;
                boardingOrder.get(row).push(p, -1* p.arrivalOrder);
            }
        }

        String order="";
        for(PriorityQ<Passenger> rowBoarding: boardingOrder){
            while(!rowBoarding.isEmpty()){
                Passenger p = rowBoarding.pop();
                order +="\n " +p.name+ " " +p.id + " " +p.row  + " " +p.column;
            }

        }
        return order;
    }

    public String showUnboardingOrder() {
        unboardingOrder = new ArrayList();
        for(int i = 0; i<reader.planeRows; i++){
            unboardingOrder.add(new PriorityQ());
        }
        for(String id: reader.getArrivals()){
            Passenger p = reader.getPassengers().search(id);
            unboardingOrder.get(p.row-1).push(p, -1*Math.abs((reader.planeColumns+1)/2.0-reader.columnCharToInt(p.column.charAt(0))), p.arrivalOrder);
        }


        String order="";
        for(PriorityQ<Passenger> rowBoarding: unboardingOrder){
            while(!rowBoarding.isEmpty()){
                Passenger p = rowBoarding.pop();
                order +="\n " +p.name+ " " +p.id + " " +p.row  + " " +p.column;
            }

        }
        return order;
    }
}
