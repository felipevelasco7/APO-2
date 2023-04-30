package model;

public class Passenger {
    public String name;
    public String id;
    public int miles;
    public boolean older;
    public boolean specialNeeds;
    public boolean travelsWithBaby;
    public int row;
    public int priority;
    public String column;
    public int arrivalOrder;
    private boolean firstClass =false;

    public Passenger(String name, String id,  int row, String column, int miles, boolean older, boolean specialNeeds, boolean travelsWithBaby) {
        this.name = name;
        this.id = id;
        this.miles = miles;
        this.older = older;
        this.specialNeeds = specialNeeds;
        this.travelsWithBaby = travelsWithBaby;
        this.row = row;
        this.column = column;
        firstClass=true;

        priority=miles/100;
        if (older)priority++;
        if (specialNeeds)priority++;
        if (travelsWithBaby)priority++;
    }

    public Passenger(String name, String id, int row, String column) {
        this.name = name;
        this.id = id;
        this.row = row;
        this.column = column;
    }

    public String printPassenger(){
        String info = "Nombre: "+name+" Id: "+id+" Fila: "+row+" Columna:"+column;
        if(firstClass) info += "\n millas:"+miles+" Adulto Mayor: "+older+" Atencion Especial: "+specialNeeds+" Bebe:"+travelsWithBaby;
        return info;
    }

    public int getArrivalOrder() {
        return arrivalOrder;
    }

    public void setArrivalOrder(int arrivalOrder) {
        this.arrivalOrder = arrivalOrder;
    }
    public int getPriority() {
        return priority;
    }
    public String getId() {
        return id;
    }
}
