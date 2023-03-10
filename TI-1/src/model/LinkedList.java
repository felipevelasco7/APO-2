package model;
import java.util.Random;


public class LinkedList {
    private Node head;
    private Node tail;


    public void generateBoard(int n, int m, int s,int e){
        
        generateBoard(m*n, 0);
        generateSnakes(s,m*n,head);
        generateLadders(e,m*n, head);
        print(n,m);
    }

    
    private void generateBoard(int numberOfSquares, int i){
        if(i<numberOfSquares){

            Node node = new Node(1);
            if(head==null){ // lista vacia
                head=node;
                node.setPlayer1(new Player("$"));
                node.setPlayer2(new Player("%"));
                node.setPlayer3(new Player("&"));

            } else {
                tail.setRight(node);
                node.setLeft(tail);
                node.setNumber(tail.getNumber()+1);
            }
            tail=node;
            generateBoard(numberOfSquares, i+1);
        }
        
    }


    private void generateLadders(int e, int mn, Node head){
        Random random = new Random();
        if (e > 0) {
            Node node1 = getRandomNode(random, mn, head);
            Node node2 = getRandomNode(random, mn, node1);
            node1.setLadder(e);
            node2.setLadder(e);
            generateLadders(e - 1, mn, head);
        }
    }

    private void generateSnakes(int s, int mn, Node head){
        Random random = new Random();
        if (s > 0) {
            Node node1 = getRandomNode(random, mn, head);
            Node node2 = getRandomNode(random, mn, node1);
            int index = s-1;  // La letra que se le va a asignar
            char c = (char) ('A' + (index % 26)); // si el index es 0 se asigna la letra A, despues B, C..
            node1.setSnake(c);
            node2.setSnake(c);
            generateSnakes(s - 1, mn, head);
        }
    }

    private Node getRandomNode(Random random, int mn, Node head){
        int randIndex1 = random.nextInt(mn-1)+1;
        Node node1=getNodeAtIndex(head, randIndex1);
        if(node1.getLadder()!=0 || node1.getSnake()!='0' || node1==head){
            return node1=getRandomNode(random, mn, head);                      //???? return??
        }
        else return node1;

    }

    private Node getNodeAtIndex(Node pointer, int index) {
        if (index < 0 || pointer == null) {//no encuentra el index 
            return null;
        } else if (index == 0) {// cuando el index es 0 significa que ya llego al nodo que se busca
            return pointer;
        } else { //se busca recursivamente el right
            return getNodeAtIndex(pointer.getRight(), index - 1);
        }
    }



    public void print(int n, int m){
    
        //print(getNodeAtIndex(head, m*n-n), n, n, m);
        print(getNodeAtIndex(head, m*n-n), n, n, m);

    }

    


    // private void print(Node pointer, int x, int n, int m){

    //     if(pointer!=null && m>0){


    //         if(n>0){
    //             if(pointer.getNumber()>10){
    //                 System.out.print("    ["+pointer.getNumber()+"]   ");
    //             }
    //             else  System.out.print("    ["+pointer.getNumber()+"]    ");

    //             print(pointer.getLeft(), x, n-1, m);
    //         }
    //         else {
    //             n=x;
    //             System.out.println();
    //             print(pointer, x, n, m-1);
    //         }
    //     }
    // }

    public Node findNode(Node pointer, int value){
        if(pointer!=null && pointer.getNumber()!=value){ // hace la recursion cuando no encunetra al nodo
            findNode(pointer.getRight(),value);
        }
        return pointer; // null cuando no lo encuentra
    }

    private String print(Node pointer, int x, int n, int m){

        if(m>0){
            if(pointer!=null && n>0){
                if(pointer.getNumber()>10){
                    System.out.print("    ["+pointer.getNumber()+"]   ");
                }
                else  System.out.print("    ["+pointer.getNumber()+"]    ");

                if(m%2==0){
                    print(pointer.getRight(), x, n-1, m);
                }
                else {
                    print(pointer.getLeft(), x, n-1, m);
                }
            }
            else {
                System.out.println();
                print(getNodeAtIndex(head, x*m-x-1), x, x, m-1);
            }
        }
        
    }

    // private void print(Node pointer, int x, int n, int m){

    //     if(m>0){
    //         if(pointer!=null && n>0){
    //             if(pointer.getNumber()>10){
    //                 System.out.print("    ["+pointer.getNumber()+"]   ");
    //             }
    //             else  System.out.print("    ["+pointer.getNumber()+"]    ");

    //             if(m%2==0){
    //                 print(pointer.getRight(), x, n-1, m);
    //             }
    //             else {
    //                 print(pointer.getLeft(), x, n-1, m);
    //             }
    //         }
    //         else {
    //             System.out.println();
    //             print(getNodeAtIndex(head, x*m-x-1), x, x, m-1);
    //         }
    //     }
    // }

}
