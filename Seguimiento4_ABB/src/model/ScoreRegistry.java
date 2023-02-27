package Seguimiento4_ABB.src.model;

public class ScoreRegistry {
    private String username;
    private int score;

    public ScoreRegistry(int score, String username) {
        this.username = username;
        this.score = score;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    
}
