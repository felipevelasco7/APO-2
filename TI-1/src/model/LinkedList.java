package model;

public class LinkedList {
    private Node head;
    private Node tail;


    public void addNodeAtTail(int numberOfSquares){
        
        addNodeAtTail(numberOfSquares, 0);
    }

    
    private void addNodeAtTail(int numberOfSquares, int i){
        if(i<numberOfSquares){
        
            Node node = new Node(0);
            if(head==null){ // lista vacia
                head=node;
                node.setNumber(1);
            } else {
                tail.setRight(node);
                node.setLeft(tail);
                node.setNumber(tail.getNumber()+1);
            }
            tail=node;
            node.setRight(head);
            head.setLeft(node);
            addNodeAtTail(numberOfSquares, i+1);
        }
        
    }

}
