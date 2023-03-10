package model;

public class Score {

    private double score;

    private Score left;
    private Score right;

   
    public Score(double score){
        this.score=score;
    }



    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }

    

    public Score getLeft() {
        return left;
    }
    public void setLeft(Score left) {
        this.left = left;
    }




    public Score getRight() {
        return right;
    }
    public void setRight(Score right) {
        this.right = right;
    }





}
