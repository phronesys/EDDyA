/* 
    Queue implementation suing a linked list
    Methods:
        .dequeue (remove peek)
        .enqueue (push)
        .peek (look at the last)
        .printQueue
*/
import java.util.*;

public class nodeQueue{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        linkedQueue test = new linkedQueue();
        boolean on = true;
        
        do{
            System.out.println("\n1.- Enqueue");
            System.out.println("2.- Dequeue");
            System.out.println("3.- Peek");
            System.out.println("4.- Print Queue");
            switch (scan.nextInt()) {
                case 1:
                    test.enqueue(scan.nextInt());
                    break;
                case 2:
                    test.dequeue();
                    break;
                case 3:
                    System.out.println(test.peek());    
                    break;
                case 4:
                    test.printQueue();
                    break;
                default:
                    break;
            }
        }while(on);
        scan.close();
    }

}

class linkedQueue{
    private class Node {
        int data;
        Node next;
    }
    //      last      first
    // null<- 3 <- 2 <- 1 
    Node first;
    Node last;
    linkedQueue() { this.first = this.last = null; }

    public boolean isEmpty() { 
        if (first == null ) 
            return true;
        else 
            return false;
    }
    public int peek()
    {
        if (!isEmpty()) return first.data;
        System.out.println("\nQueue empty");
        return -1;
    }
    public void enqueue(int x)
    {
        Node temp = new Node();
        temp.data = x;
        temp.next = null;

        if (isEmpty()){
            last = first = temp;
        }else {
            last.next = temp;
            last = temp;
        }
    }
    public void dequeue()
    {
        if (isEmpty()) {
            System.out.println("\nQueue empty");
            return;
        }
        Node temp = new Node();
        temp = first;
        first = first.next;
        temp = null;
    }
    public void printQueue()
    {
        Node temp = new Node();
        temp = first;
        while(temp != null)
        {
            System.out.printf("%d ->", temp.data);
            temp = temp.next;
        }
    }
}


