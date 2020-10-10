import java.io.*;
import java.util.*;

public class rotacion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int D = scan.nextInt();
        CircularList cl = new CircularList();

        for(int i = 0; i < N; i++){
            // añadirlo a una lista circular
            
            cl.add(scan.nextInt());
        }
        if(D == N){
            cl.display();
        }else{
            cl.rotateLeft(D);
            cl.display();
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
    public void rotateLeft(int n){
        Node temp;

        if(head != null){
            for(int i = 0; i < n; i++){
                head = head.next;
                tail = tail.next;
            }
        }
    }
}
