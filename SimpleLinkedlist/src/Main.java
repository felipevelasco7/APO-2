package SimpleLinkedlist.src;

public class Main{

    static private SimpleLinkedList simpleLinkedList;

    public static void main (String[]args){

        simpleLinkedList= new SimpleLinkedList();

        simpleLinkedList.getList(simpleLinkedList.getRoot());

        simpleLinkedList.addNodeAtEnd(simpleLinkedList.getRoot(), 1);
        simpleLinkedList.addNodeAtEnd(simpleLinkedList.getRoot(), 2);
        simpleLinkedList.addNodeAtEnd(simpleLinkedList.getRoot(), 3);
        simpleLinkedList.addNodeAfter(simpleLinkedList.getRoot(), 10, 2);


        simpleLinkedList.getList(simpleLinkedList.getRoot());
    
    }
}
