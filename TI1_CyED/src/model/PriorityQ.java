package model;

class Node<V> {

    V data;
    double priority;
    int order;
    Node next; // el siguiente con menor prioridad

    public Node(V d, int o) {
        data = d;
        order = o;
        next = null;
    }
    public Node(V d, double p, int o) {
        data = d;
        priority = p;
        order = o;
        next = null;
    }
    public V getData() {
        return data;
    }

}
public class PriorityQ<V> {
    public Node<V> head;

    public PriorityQ(){
        head = null;
    }

    public V pop(){
        Node<V> temp = head;
        head = head.next;
        return temp.data;
    }

    public void push(V d, int o) {
        Node<V> temp = new Node(d, o);
        if(head == null) {
            head = temp;
        } else {
            Node<V> start = head;
            Node <V> prev = null;

            while (start != null && start.order > o) {
                prev = start;
                start = start.next;
            }
            if(prev == null){
                head = temp;
            } else {
                prev.next = temp;
            }
            temp.next = start;
        }
    }
    public void push(V d, double p, int o) {
        Node<V> temp = new Node(d, p,o);
        if(head == null) {
            head = temp;
        } else {

            Node<V> start = head;
            Node <V> prev = null;

            while (start != null && (start.priority > p || (start.priority == p && start.order < o))) {
                prev = start;
                start = start.next;
            }

            if(prev == null){
                head = temp;
            } else {
                prev.next = temp;
            }
            temp.next = start;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
    public Node getNext() {
        return head.next;
    }
    public V getData() {
        return head.data;

    }


}
