package model;
import java.util.Random;


public class Controler {
    
    static private ScoresBST highScores;
    static private LinkedList list;
    static final Random random = new Random();

    private int n;
    private int m;
     


    public Controler(){
        list = new LinkedList();
        ScoresBST highScores = new ScoresBST();

    }


    public String generateBoard(int n, int m, int s, int e){
        this.n=n;
        this.m=m;
        list.generateBoard(n,m,s,e);
        String board=showBoard();
        return board;
    }
    

    public boolean checkwinner(){
      return list.checkwinner();
    }

    public String showBoard(){
        return list.print(n, m);
    }


    public void move(int num, String symbol){
        list.movePlayer(symbol, num);
    }


    public int throwDice(){
        return random.nextInt(6) + 1;
    }

    public String showSnakesAndLadders(){

        return list.showSnakesAndLadders(n,m);
    }

    public String calculateScore(long endTime, long startTime, int currentPlayer){

        long t = endTime - startTime;
        double puntaje = (600 - t) / 6;
        addScore(puntaje);
        String player;
        if(currentPlayer==0) player="$";
        if(currentPlayer==1) player="%";
        else player="&";

        String msg= player+ " es el Ganador! El puntaje final es: "+ puntaje;
        
        return msg;
    }

    public void addScore(double puntaje){

        highScores.addNode(puntaje);
    }

    public String showHighScores(){
        return highScores.printFromRight();

    }

    
}
