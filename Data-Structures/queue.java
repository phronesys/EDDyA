/* 
    Queue implementation suing a linked list
    Methods:
        .dequeue (remove peek)
        .enqueue (push)
        .peek (look at the last)
        
*/

class linkedQueue{
    private class Node {
        int data;
        Node next;
    }
    
    Node front;
    Node back;
    linkedQueue() { this.front = this.back = null; }

    public boolean isEmpty() { 
        if (front == null && back == null) 
            return true;
        else 
            return false;
    }
    public int peek()
    {
        if (!isEmpty()) return back.data;
        System.out.println("\nQueue empty");
        return -1;
    }
    public void dequeue()
    {
        if (isEmpty()) {
            System.out.println("\nQueue empty");
            return;
        }
         

    }
    public void enqueue()
    {
        
    }
    public void printQueue()
    {

    }
}

class queue{

    public static void main(String[] args)
        {
        
        }

}
