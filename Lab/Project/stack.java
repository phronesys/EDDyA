/* 
    Stack implementation using a linked list
    Methods:    
        .push
        .pop
        .peek
        .isEmpty
*/
import java.util.Scanner;

class linkedStack{
    private class Node {
        int data;
        Node next;
    }
    Node end;
    //constructor 
    linkedStack(){ this.end = null; }

    public void push(int x)
    {   
        Node temp = new Node();

        temp.data = x;
        temp.next = end; // this is pointing to null
        end = temp; // this set end pointer to the new Node created
    }
        
    public void pop(){
        if (end == null) {
            System.out.println("\nStack is empty");
            return;
        }
        end = end.next;
    }
    public int peek(){
        if (end != null) {
            return end.data;
        } else {
            System.out.println("\nStack is empty");
            return -1;
        }
    }
    public boolean isEmpty(){
        return end == null;
    }
    public void print(){
        if (end == null) {
            System.out.println("\nStack is empty");
            return;
        } else {
            Node temp = end;
            while ( temp != null) {
                System.out.printf("%d --> ", temp.data);
                temp = temp.next;
            }
        }
    }

};

public class stack
{
    public static void main(String[] args)
    {
        linkedStack test = new linkedStack();
        boolean on = true;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("\n1.- Push");
            System.out.println("2.- Pop");
            System.out.println("3.- Peek");
            System.out.println("4.- isEmpty");
            System.out.println("5.- Print stack");
            switch(scan.nextInt()){
                case 1: 
                    int x = scan.nextInt();
                    test.push(x);
                    break;
                case 2:
                    test.pop();
                    break;
                case 3:
                    System.out.println(test.peek());
                    break;
                case 4:
                    System.out.println(test.isEmpty());
                    break;
                case 5:
                    test.print();
                    break;
                default:
                    on = false;
                    break;
                }
        } while(on);
        scan.close();
    }
}
