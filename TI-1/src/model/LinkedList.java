package model;
import java.util.Random;


public class LinkedList {
    private Node head;
    private Node tail;
    Random random = new Random();

    public void generateBoard(int n, int m, int s,int e){
        tail=null;
        head=null;
        generateBoard(m*n, 0);
        generateSnakes(s,m*n,head);
        generateLadders(e,m*n, head);
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
        if (e > 0) {
            Node node1 = getRandomNode(mn, head);
            Node node2 = getRandomNode( mn, node1);
            node1.setLadder(e);
            node2.setLadder(e);
            generateLadders(e - 1, mn, head);
        }
    }

    private void generateSnakes(int s, int mn, Node head){
        if (s > 0) {
            Node node1 = getRandomNode( mn, head);
            Node node2 = getRandomNode( mn, node1);
            int index = s-1;  // La letra que se le va a asignar
            char c = (char) ('A' + (index % 26)); // si el index es 0 se asigna la letra A, despues B, C..
            node1.setSnake(c);
            node2.setSnake(c);
            generateSnakes(s - 1, mn, head);
        }
    }

    private Node getRandomNode(int mn, Node pointer){
        int randIndex1 = random.nextInt(mn-2)+1;
        Node node1=getNodeAtIndex(head, randIndex1);
        if(node1.getLadder()!=0 || node1.getSnake()!='0' || node1==head || node1==pointer || node1==tail){
            return node1=getRandomNode( mn, head);                      //???? return??
        }
        else return node1;

    }

    private Node getNodeAtIndex(Node pointer, int index) {
        if (index < 0 || pointer == null) {//no encuentra el index 
            return getNodeAtIndex(head, index);
        } else if (index == 0) {// cuando el index es 0 significa que ya llego al nodo que se busca
            return pointer;
        } else { //se busca recursivamente el right
            return getNodeAtIndex(pointer.getRight(), index - 1);
        }
    }

    public Node findNode(Node pointer, int value){
        if(pointer!=null && pointer.getNumber()==value){ 
            
            return pointer;
        }
        else if (pointer!= null)return findNode(pointer.getRight(),value); // hace la recursion cuando no encunetra al nodo
        else return tail; // null cuando no lo encuentra
    }

    public boolean findLadder(Node pointer, int value, Player player, String playerSymbol){
        if(pointer!=null && pointer.getLadder()==value) {
            if(playerSymbol.equalsIgnoreCase("$")) pointer.setPlayer1(player);
            else if(playerSymbol.equalsIgnoreCase("%")) pointer.setPlayer2(player);
            else if (playerSymbol.equalsIgnoreCase("&")) pointer.setPlayer3(player);
            return true;
        }
        else if(pointer!=null) return findLadder(pointer.getRight(), value, player, playerSymbol);
        else return false;
    
    } 
    
    public boolean findSnakeTail(Node pointer, char value, Player player, String playerSymbol){
        
        if(pointer!=null && pointer.getSnake()==value) {
            if(playerSymbol.equalsIgnoreCase("$")) pointer.setPlayer1(player);
            else if(playerSymbol.equalsIgnoreCase("%")) pointer.setPlayer2(player);
            else if (playerSymbol.equalsIgnoreCase("&")) pointer.setPlayer3(player);
            return true;
        }
        else if(pointer!=null) return findSnakeTail(pointer.getLeft(), value, player, playerSymbol);
        else return false;
    
    }

    public void movePlayer(String value, int num){
        movePlayer(head, value, num);

    }

    private void movePlayer(Node pointer, String player, int num){

        if(pointer!=null && pointer.getPlayer1()!=null&& pointer.getPlayer1().getSymbol()==player) { // encuentra el nodo en el que esta jugador
            Node newPosition= findNode(head, pointer.getNumber()+num);//nodo al que se va a mover
            newPosition.setPlayer1(pointer.getPlayer1());
            pointer.setPlayer1(null);
            //revisa escaleras y serpientes en el nuevo nodo
            if(newPosition.getLadder()!=0) {if (findLadder(newPosition.getRight(),newPosition.getLadder(), newPosition.getPlayer1(), player)) newPosition.setPlayer1(null); System.out.println("escalera");}
            else if(newPosition.getSnake()!='0') {if (findSnakeTail(newPosition.getLeft(), newPosition.getSnake(), newPosition.getPlayer1(), player)) newPosition.setPlayer1(null); System.out.println("serpiente");}
            else System.out.println("se ha movido a la posicion "+ newPosition.getNumber());      
        }
        else if(pointer!=null && pointer.getPlayer2()!=null&& pointer.getPlayer2().getSymbol()==player) {

            Node newPosition= findNode(head, pointer.getNumber()+num);
            newPosition.setPlayer2(pointer.getPlayer2());
            pointer.setPlayer2(null);
            if(newPosition.getLadder()!=0) {if (findLadder(newPosition.getRight(),newPosition.getLadder(), newPosition.getPlayer2(), player)) newPosition.setPlayer2(null); System.out.println("escalera");}
            else if(newPosition.getSnake()!='0') {if (findSnakeTail(newPosition.getLeft(), newPosition.getSnake(), newPosition.getPlayer2(), player)) newPosition.setPlayer2(null); System.out.println("serpiente");}
            else System.out.println("se ha movido a la posicion "+ newPosition.getNumber());   
        }
        else if(pointer!=null && pointer.getPlayer3()!=null&& pointer.getPlayer3().getSymbol()==player) {
            Node newPosition= findNode(head, pointer.getNumber()+num);
            newPosition.setPlayer3(pointer.getPlayer3());
            pointer.setPlayer3(null);
            if(newPosition.getLadder()!=0) {if (findLadder(newPosition.getRight(),newPosition.getLadder(), newPosition.getPlayer3(), player)) newPosition.setPlayer3(null); System.out.println("escalera");}
            else if(newPosition.getSnake()!='0') {if (findSnakeTail(newPosition.getLeft(), newPosition.getSnake(), newPosition.getPlayer3(), player)) newPosition.setPlayer3(null); System.out.println("serpiente");}
            else System.out.println("se ha movido a la posicion "+ newPosition.getNumber());   
        }
        else if(pointer!=null)movePlayer(pointer.getRight(),player, num);// recursion hasta que encuentre el nodo en el que esta el jugador

    }

    public String print(int n, int m){
    
        String string="";

        if(m%2==0){ //si el numero de filas es par comienza por el tail
           string=print(tail, n, n, m);
        }
        else {// si es impar comienza en tail-n
            string=print(getNodeAtIndex(head, m*n-n), n, n, m);
        }
        return string;
    }

    private String print(Node pointer, int x, int n, int m){
       String string="";
        if(m>0){
            if(pointer!=null && n>0){

                if(pointer.getNumber()>10 ||pointer.getPlayer1()!=null || pointer.getPlayer2()!=null || pointer.getPlayer3()!=null ){ //anade el numero al string
                    string+="   ["+pointer.getNumber();
                    if(pointer.getPlayer1()!=null) string+= pointer.getPlayer1().getSymbol();
                    if(pointer.getPlayer2()!=null) string+=pointer.getPlayer2().getSymbol();
                    if(pointer.getPlayer3()!=null) string+=pointer.getPlayer3().getSymbol();
                    string+="]   ";

                } else  string+="   ["+pointer.getNumber()+"]    " ;
        
                if(n>1){// recursion para añadir los otros numeros al string
                    if(m%2==0){ //si la fila es par es en orden descendente
                        return string+= print(pointer.getLeft(), x, n-1, m);
                    }
                    else {// si es impar es en oden ascendente
                        return string+= print(pointer.getRight(), x, n-1, m);
                    }
                }else{// si n==1, ya es el ultimo de la fila 
                    
                    return string+="\n"+ print(findNode(head, pointer.getNumber()-x), x, x, m-1);
                }
            }
        }
        return string; 
    }

    public String showSnakesAndLadders(int n, int m){
    
        String string="";

        if(m%2==0){ //si el numero de filas es par comienza por el tail
           string=showSnakesAndLadders(tail, n, n, m);
        }
        else {// si es impar comienza en tail-n
            string=showSnakesAndLadders(getNodeAtIndex(head, m*n-n), n, n, m);
        }
        return string;
    }

    private String showSnakesAndLadders(Node pointer, int x, int n, int m){
       String string="";
        if(m>0){
            if(pointer!=null && n>0){

                if(pointer.getSnake()!='0'){ //anade el char de la serpiente al string
                    string+="   ["+pointer.getSnake()+"]    ";

                } else if(pointer.getLadder()!=0){ //anade el char de la serpiente al string
                    string+="   ["+pointer.getLadder()+"]    ";

                }else  string+="   [ ]    " ;// vacio si no hay serpiente
        
                if(n>1){// recursion para añadir las otras casillas al string
                    if(m%2==0){ //si la fila es par es en orden descendente
                        return string+= showSnakesAndLadders(pointer.getLeft(), x, n-1, m);
                    }
                    else {// si es impar es en oden ascendente
                        return string+= showSnakesAndLadders(pointer.getRight(), x, n-1, m);
                    }
                }else{// si n==1, ya es el ultimo de la fila 
                    
                    return string+="\n"+ showSnakesAndLadders(findNode(head, pointer.getNumber()-x), x, x, m-1);
                }
            }
        }
        return string; 
    }

    public boolean checkwinner(){
        boolean winner=false;
        if(tail.getPlayer1()!=null || tail.getPlayer2()!=null ||tail.getPlayer3()!=null) winner=true;
        return winner;
    }


}
