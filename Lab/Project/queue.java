import java.util.ArrayList;
public class queue {
    public ArrayList items;
    public queue(queue copy){
        ArrayList copia = new ArrayList(copy.items);
        this.items = copia;
    }

    public queue()
    {
        items = new ArrayList();
    }

    public Object front()
    {
        return items.get(0);
    }

    public void dequeue()
    {
        if (!isEmpty()) {
            items.remove(0);
        } else {
            System.out.println("Queue is already empty!!");
        }
    }

    public void enqueue(Object in)
    {
        items.add(in);   
    }
    public void printQueue()
    {
        if(!isEmpty())
        {
            for(int i = 0; i < items.size(); i++){
                System.out.println(items.get(i));
            }
            
        }
    }
    public Boolean isEmpty()
    {
        return (items.size() == 0);
    }
}