package Seguimiento3.model;

public class Node {
    
    private Node previous;
    private int value;
    private Node next;
    private int skipCounter;


    public Node(int value) {
        this.value = value;
    }


    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


    public int getSkipCounter() {
        return skipCounter;
    }

    public void addSkip() {
        skipCounter+=1;
    }
    
}
