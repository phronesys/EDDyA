import java.util.*;
class LinkedList {
    private class Node {
        int data;
        Node next;
    }
    Node head; // cabeza de la lista
    LinkedList(){ this.head = null; }
    /* public void add(int dat){ // reversed list? xd
        Node temp = new Node(); // primero creo un nuevo nodo
        temp.data = dat;
        temp.next = head;
        head = temp;
    } */ 
    
    public void add(int dat){
        if(!isEmpty()){
            Node temp = new Node();
            temp.data = dat;
            temp.next = null;
            head.next = temp;
            head = temp;
        } else {
            Node temp = new Node();
            temp.data = dat;
            temp.next = null;
            head = temp;
        }
    }
    public void print2(){
        
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
            System.out.println();
        } else {
            System.out.println("\nLista vacia...");
        }
    }
    public int get(int index){
        Node temp = null;
        if (index < 0) return -1;
        if(!isEmpty()){
            temp = head;
            for(int i = 0; i < index; i++) {
                if(temp.next == null) return -1;
                temp = temp.next;
            }
        }
        return temp.data;
    }

}
public class linkedlist {
    public static void main(String[] args) {
        LinkedList a = new LinkedList();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.print();
        System.out.println(a.get(4));
    }
}