package Seguimiento4_ABB.src.model;

public class Controler {
    public static void main(String []args){
        ScoreBST scoreTree = new ScoreBST();
        UserBST userTree = new UserBST();
        
    }


    public void addScoreRegistry(String username, int score){
        ScoreRegistry scoreRegistry = new ScoreRegistry(score, username);
    }
    
    public void searchByScore(int scoreToSearch){

    }


    public void alphabeticalOrder(){
        
    }

    public void top5(){
        
    }
    
    
}
