package Seguimiento_5;

public class BST {
    private Node root;
    
    public void addRoot(String[] array){
        int x= array.length;
        if(x!=0) root=addRoot(array, 0, x-1);
    }

    private Node addRoot(String[] array, int start, int end){
        if(start>end){
            return null;
        }
        int root=(start+end)/2;
        Node name= new Node(array[root]);
        name.setLeft(addRoot(array, start, root-1)) ;
        name.setRight(addRoot(array, root+1, end)) ;
        return name;

    }


    public int depth(){
        return getMax(root, 1);
    }
    
    private int getMax(Node pointer, int counter){
        
        if(pointer.getRight()==null){
            return counter;
        }
        else{
            return getMax(pointer.getRight(), counter+1);
        }
    } 

    public void printFromRight(){
        printFromRight(root);
        System.out.println();
    }
    private void printFromRight(Node pointer){
        if(pointer !=null){
            printFromRight(pointer.getRight());
            System.out.print(pointer.getName()+" ");
            printFromRight(pointer.getLeft());

        }
    }

}
