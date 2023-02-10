package SimpleLinkedlist.src;

public class SimpleLinkedList {

    private Node root;

    public SimpleLinkedList() {
        this.root = null;
    }

    public Node addNodeAtEnd(Node pointer, int value){
        if(pointer == null){ // caso base: se encontro el ultimo nodo de la lista
            Node node = new Node(null, value);
            if(root==null){ // caso en el que la lista no tiene ningun nodo
                root=node;
            }
            return node; // retorna el ultimo nodo de la lista
        }
        else { // caso recursivo, la responsabilidad pasa a ser del siguiente del pointer
            Node node = addNodeAtEnd(pointer.getNext(), value);
            pointer.setNext(node);
            return pointer; // retorna el ultimo nodo de la lista
        }
    }


    public void addNodeAfter (Node pointer, int value, int targetValue){

        if(pointer!=null){

            if (pointer.getValue()==targetValue){
                Node node= new Node (null, value);
                node.setNext(pointer.getNext());
                pointer.setNext(node);
            }else {
                addNodeAfter(pointer.getNext(), value, targetValue);
            }
        }
    }

    public void deleteNodeAfter (Node pointer, int targetValue){

        if(pointer!=null){

            if (pointer.getValue()==targetValue){
                pointer.setNext(pointer.getNext().getNext());

            } else {
                deleteNodeAfter(pointer.getNext(), targetValue);
            }    
        }
    }

    public void deleteNode (Node pointer, int targetValue){

        if(pointer!=null){

            if (pointer.getNext().getValue()==targetValue){
                pointer.setNext(pointer.getNext().getNext());

            } else {
                deleteNode(pointer.getNext(), targetValue);
            }    
        }
    }

    public void getList(Node pointer){
        if(pointer!=null){
            if(pointer.getNext()==null){ // caso base: es el ultimo nodo
                System.out.println(pointer.getValue());
            } else {
                System.out.println(pointer.getValue());
                getList(pointer.getNext());
            }
        }
    }


    public Node getRoot() {
        return root;
    }

}