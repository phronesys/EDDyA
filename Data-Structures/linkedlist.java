import java.util.*;
class LinkedList {
    private class Node {
        int data;
        Node next;
    }
    Node head; // cabeza de la lista
    LinkedList(){ this.head = null; }
    public void add(int dat){
        Node temp = new Node(); // primero creo un nuevo nodo
        temp.data = dat;
        temp.next = head;
        head = temp;
    }
    public void remove(){
        if(isEmpty()){ System.out.println("\n Ya está vacio");
            return;
        }
        head = head.next;
    }
    public void clear(){
        while(!isEmpty()){
            head = head.next;
        }
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void print(){
        if(!isEmpty()){
            Node temp = head;
            System.out.println();
            while(temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        } else {
            System.out.println("\nLista vacia...");
        }
    }

}
public class linkedlist {
    public static void main(String[] args) {
        LinkedList a = new LinkedList();
        a.add(1);
        a.print();
        a.add(2);
        a.print();
        a.add(3);
        a.add(4);
        a.print();
        a.add(5);
        a.print();
        a.clear();
        a.add(1);
        a.add(123);
        a.add(1);
        a.print();
        a.remove();
        a.print();
    }
}