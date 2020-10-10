import java.io.*;
import java.util.*;

public class rotacion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int D = scan.nextInt();
        
        for(int i = 0; i < N; i++){
            // añadirlo a una lista circular
            CircularList cl = new CircularList();
            cl.add(scan.nextInt());
        }
        
        scan.close();
    }

}
class CircularList{
    public class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    public Node head = null;
    public Node tail = null;
    CircularList(){
        this.length = 0;
    }
    public void add(int data){
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }
    public void display(){
        Node current = head;
        if(head == null){
            System.out.println("Empty");
        } else {
            do{
                System.out.print(current.data + " ");
                current = current.next;
            }while(current != head);
            System.out.println();
        }
    }
    public void rotate(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < this.)
        }
    }
}
