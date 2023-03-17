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

    public String printFromRight(){
        String scores="";
        return printFromRight(root, scores);
    }
wdjkjdhc
    private String printFromRight(Score pointer, String scores){
        if(pointer !=null){
            printFromRight(pointer.getRight(),scores);
            scores+=pointer.getScore()+" ";
            printFromRight(pointer.getLeft(),scores);

        }
        return scores;
    }
}
