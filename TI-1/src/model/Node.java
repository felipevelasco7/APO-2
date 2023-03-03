package model;

public class Node {
    private Node left;
    private Node right;

    private Node ladder;
    private Node snake;

    private int number;

    private Player player1;
    private Player player2;
    private Player player3;
    
    public Node(int number) {
        this.number = number;

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

    public Node getLadder() {
        return ladder;
    }

    public void setLadder(Node ladder) {
        this.ladder = ladder;
    }

    public Node getSnake() {
        return snake;
    }

    public void setSnake(Node snake) {
        this.snake = snake;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer3() {
        return player3;
    }

    public void setPlayer3(Player player3) {
        this.player3 = player3;
    }

    

}
