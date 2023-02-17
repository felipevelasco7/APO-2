package Seguimiento3.model;

public class LinkedList {

    private Node head;
    private Node tail;
    private Node activeTurn;
    
    public void addNodeAtTail(){
        Node node = new Node(0);
        if(head==null){ // lista vacia
            head=node;
            node.setValue(1);
            activeTurn=node;
            head.setNext(head);
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
            node.setValue(tail.getValue()+1);
        }
        tail=node;
        node.setNext(head);
        head.setPrevious(node);
    }

    public Node getActiveTurn() {
        return activeTurn;
    }
    public int getActiveTurnValue() {
        return activeTurn.getValue();
    }


    public String skipTurn() {
        String msg;
        if(head!=null){
            activeTurn.addSkip();
            msg="Turno pasado exitosamente. ";

            if(activeTurn.getSkipCounter()==3){
                msg=msg+deleteNode();
            }
            else{activeTurn=activeTurn.getNext();}
        }
        else{  msg="No hay turnos aun"; }
        return msg;
    }


    public String deleteNode(){
        String  msg= "Turno "+ activeTurn.getValue()+" borrado";
        if(head!=null){//no hay nada en la lista
            if(head==tail){ //si solo hay un nodo en la lista
                head=null; tail=null; activeTurn=null; 
                msg=msg+". Lista vacia";}
            else{
                activeTurn.getPrevious().setNext(activeTurn.getNext());;
                activeTurn.getNext().setPrevious(activeTurn.getPrevious());
                if(activeTurn.getNext()==activeTurn.getPrevious()){//si hay dos elementos
                    head=activeTurn.getNext();
                    tail=head;
                }
                msg= "Turno "+ activeTurn.getValue()+" borrado";
                activeTurn=activeTurn.getNext();
            }
        }
        else msg="no hay turnos";
        return msg;
    }
}
