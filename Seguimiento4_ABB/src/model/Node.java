package Seguimiento4_ABB.src.model;

public class Node {
    private Node left;

    private Node right;

    private ScoreRegistry scoreRegistry;
    

    public Node(ScoreRegistry scoreRegistry) {
        this.scoreRegistry = scoreRegistry;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public ScoreRegistry getScoreRegistry() {
        return scoreRegistry;
    }

    public void setScoreRegistry(ScoreRegistry scoreRegistry) {
        this.scoreRegistry = scoreRegistry;
    }

    

}
