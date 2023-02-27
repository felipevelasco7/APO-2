public class Main {
    public static void main(String[] args) {

        BST tree = new BST();

        tree.addNode(10);
        tree.addNode(2);
        tree.addNode(5);
        tree.addNode(4);
        tree.addNode(6);
        tree.addNode(10);
        tree.print();
        tree.printFromRight();
        tree.getMin();


        Node nodeFind =tree.find(5);
        if( nodeFind!=null){
            System.out.println(nodeFind.getValue());
        }
        



    }
}