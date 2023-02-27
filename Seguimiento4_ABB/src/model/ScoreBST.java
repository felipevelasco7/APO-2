package Seguimiento4_ABB.src.model;

public class ScoreBST {
    private Node root;


    public void addNode(ScoreRegistry scoreRegistry) {
        if (root == null) { // arbol vacio
            root = new Node(scoreRegistry);
        } else {
            Node newNode = new Node(scoreRegistry);
            addNode(root, newNode);
        }
    }

    private void addNode(Node pointer, Node newNode) {
        if (newNode.getScoreRegistry().getScore() < pointer.getScoreRegistry().getScore()) { // ir hacia el subarbol izquierdo
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

    public void print(){
        print(root);
        System.out.println();

    }

    private void print(Node pointer){
        if(pointer !=null){
            print(pointer.getLeft());
            System.out.print(pointer.getScoreRegistry().getScore()+" ");
            print(pointer.getRight());
        }
    } 
    

    public void printFromRight(){
        printFromRight(root);
        System.out.println();
    }
    private void printFromRight(Node pointer){
        if(pointer !=null){
            printFromRight(pointer.getRight());
            System.out.print(pointer.getScoreRegistry().getScore()+" ");
            printFromRight(pointer.getLeft());

        }
    }

    public void getMin(){
        getMin(root);
        System.out.println();

    }
    private void getMin(Node pointer){
        if(pointer.getLeft()==null){
            System.out.print(pointer.getScoreRegistry().getScore()+" ");
        }
        else{
            getMin(pointer.getLeft());
        }

    } 


    public void getMax(){
        getMax(root);
        System.out.println();

    }
    private void getMax(Node pointer){
        if(pointer.getRight()==null){
            System.out.print(pointer.getScoreRegistry().getScore()+" ");
        }
        else{
            getMax(pointer.getRight());
        }

    } 


    public Node find(int value){
        return find(value, root);
    }

    private Node find(int value, Node pointer){
        if(pointer!=null){
            if(value==pointer.getScoreRegistry().getScore()){
                return pointer;            
            }
            else if(value>pointer.getScoreRegistry().getScore()){
                return find(value, pointer.getRight());
            }
            else{
                return find(value, pointer.getLeft());
            }
        }
       else return null;
        
    }




}
