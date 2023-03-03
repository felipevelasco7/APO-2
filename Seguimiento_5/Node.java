package Seguimiento_5;

public class Node {
    private Node left;

    private Node right;

    private String name;
    
    public Node(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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

    
}
