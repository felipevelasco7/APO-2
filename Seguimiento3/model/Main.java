package Seguimiento3.model;

public class Main {

    static private LinkedList list;

    public Main() {

        list = new LinkedList();
        
    }


    public void addTurn(){
        list.addNodeAtTail();
    }

    public String showActiveTurn(){
        String value;
        if(list.getActiveTurn()!=null){
            value= "Turno actual: "+ list.getActiveTurnValue()+" ";
        }
        else{ value="no hay turnos todavia";}

        return value;
    }

    public String skipTurn(){
        return list.skipTurn();

    }

    public String nextTurn(){
        return list.deleteNode();

    }
    
}
