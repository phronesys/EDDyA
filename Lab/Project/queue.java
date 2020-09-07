import java.util.ArrayList;
public class queue {
    private ArrayList items;

    public queue()
    {
        items = new ArrayList();
    }

    public Object peek()
    {
        return items.get(items.size());
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
    
    public Boolean isEmpty()
    {
        return (items.size() == 0);
    }
}