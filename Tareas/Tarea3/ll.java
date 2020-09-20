import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ll lista = new ll();
        int N = scan.nextInt();
        for(int i = 0; i < N; i++){
            lista.add(scan.nextInt());
        }
        lista.printLLReversed();
    }
}
public class ll {
    private class Node{
        int data;
        Node next;
        Node back;
    }
    Node head = null;
    Node tail = null;
    
    public void add(int d){
        Node temp = new Node();
        temp.data = d;
        if(isEmpty()){
            head = tail = temp;  
            head.back = null;  
            tail.back = null;
        } else if(head.next == null){
            head.back = null; 
            head.next = temp;
            tail = temp;
            tail.back = head;
        } else {
            Node aux = new Node();
            aux = tail;
            tail.next = temp;
            tail = temp;
            tail.next = null;
            tail.back = aux;
        }
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void printLL(){
        Node temp = new Node();
        temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void printLLReversed(){
        Node temp = new Node();
        temp = tail;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.back;
        }
        System.out.println();
    }
    
}
