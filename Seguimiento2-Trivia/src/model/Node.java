package model;
import java.util.Random;


public class Node {

    private Player player;
    private Node next;
    private Node previous;
    private int value;

    private String question;
    private double result;
    private String status;
    

    public Node(int value) {
        this.value = value;

        Random random = new Random();

        int num1 = random.nextInt(100);
        int num2 = random.nextInt(99)+1;
        int operation = random.nextInt(4);

        switch (operation) {
        case 0:
            result = num1 + num2;
            question= num1 + " + " + num2;
            break;
        case 1:
            result = num1 - num2;
            question= num1 + " - " + num2 ;
            break;
        case 2:
            result = num1 * num2;
            question=num1 + " * " + num2 ;
            break;
        case 3:
            result = num1 / num2;
            question=num1 + " / " + num2 ;
            break;
        }
  
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

    public String getQuestion() {
        return question;
    }

    public double getResult() {
        return result;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }


}
