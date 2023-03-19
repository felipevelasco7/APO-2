package model;

public class ScoresBST {
    private Score root;

    public void addNode(double value) {
        if (root == null) { // arbol vacio
            root = new Score(value);
        } else {
            Score newNode = new Score(value);
            addNode(root, newNode);
        }
    }

    private void addNode(Score pointer, Score newNode) {
        if (newNode.getScore() < pointer.getScore()) { // ir hacia el subarbol izquierdo
            if (pointer.getLeft() == null) {
                pointer.setLeft(newNode);
            } else {
                addNode(pointer.getLeft(), newNode); // nueva recursion hacia el nivel inferior del left
            }
        } else { // ir hacia el subarbol derecho
            if (pointer.getRight() == null) {
                pointer.setRight(newNode);
            } else {
                addNode(pointer.getRight(), newNode); // nueva recursion hacia el nivel inferior del right
            }
        }


    }

    public String printBSTFromRight(){
        return printBSTFromRight(root);
    }

    private String printBSTFromRight(Score root) {
        if (root == null) {
            return "";
        }
        String right = printBSTFromRight(root.getRight()); // recursively print right subtree
        String current = root.getScore() + " "; // print current node
        String left = printBSTFromRight(root.getLeft()); // recursively print left subtree
        return right + current + left;
    }

}
