package model;

public class Main {

    static private LinkedList linkedList;
    static private Player player;


    public Main(){

        linkedList= new LinkedList();
        linkedList.getList(linkedList.getRoot());


    
    }

    public void createLinkedList(int numberOfQuestions, String nickname){
        player= new Player(nickname);

        for (int i=1; i<=numberOfQuestions; i++){
            linkedList.generateList(linkedList.getRoot(), i, player);

        }
        linkedList.getList(linkedList.getRoot());
    }

    public void start(){
        System.out.println("Cuanto es "+linkedList.getRoot().getQuestion()+" ?");


    }

    /* 
    hacer pregunr\ta
    recibir respues
    verificar respuesta
    avanzar de pregunta 

    */      

}
