package model;

public class LinkedList {
    private Node root;
    private Node tail;

    public LinkedList() {
        this.root = null;
    }

    public void generateList(Node pointer, int value, Player player){
        Node node = new Node(value);
        if(root==null){ // caso base, lista vacía
            root=node;
            tail=node;
            node.setPlayer(player);
        }
        else if(pointer.getNext()==null){ // caso base, se encontro el ultimo
            pointer.setNext(node);
            tail=node;
            pointer.getNext().setPrevious(pointer);

        } else { // se sigue buscando el ultimo recursivamente
            generateList(pointer.getNext(), value, player);
        }
    }

    public void addNodeAfterTarget(Node pointer, int value, int targetValue) {
        if(pointer!=null) { // caso base, lista vacía o no se encontro el target
            if(pointer.getValue()==targetValue){ // se encontro el target
                Node node = new Node(value);
                node.setNext(pointer.getNext());
                pointer.setNext(node);
            } else { // se sigue buscando el target recursivamente
                addNodeAfterTarget(pointer.getNext(), value, targetValue);
            }
        }
    }

    
    public void getList(Node pointer){
        if(pointer!=null){
            if(pointer.getPlayer()!=null){
                System.out.print(" ["+pointer.getValue()+"*] ");
                getList(pointer.getNext());

            }
            else{ System.out.print(" ["+pointer.getValue()+"] ");
                getList(pointer.getNext());
            }
        }
        System.out.println();
    }

    public void deleteNode(Node pointer, int value){
        if(pointer!=null) { // caso base, lista vacía o no se encontro el target
            if (root.getValue() == value) { // caso en el que el target es el root
                root = pointer.getNext();
            } else if (pointer.getNext() != null) {
                if (pointer.getNext().getValue() == value) { // se encontro el target en el siguiente
                    pointer.setNext(pointer.getNext().getNext());
                    pointer.getNext().getNext().setPrevious(pointer);
                } else { // se sigue buscando el target recursivamente
                    deleteNode(pointer.getNext(), value);
                }
            }
        }

    }

    public Node getRoot() {
        return root;
    }
}
