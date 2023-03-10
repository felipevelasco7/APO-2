package model;

public class Controler {
    
    static private ScoresBST highScores;
    static private LinkedList list;

    public Controler(){
        list = new LinkedList();
        ScoresBST highScores = new ScoresBST();

    }


    public void generateBoard(int n, int m, int s, int e){
        list.generateBoard(n,m,s,e);

    }
    

    public void showBoard(){

    }

    public void throwDice(){

    }

    public void showSnakesAndLadders(){

    }

    public void calculateScore(){

    }

    public void addScore(){
        
    }

    public void showHighScores(){

    }

    
}
