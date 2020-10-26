import java.util.ArrayList;
public class priorityQHeapSort {
    public ArrayList<tripleta> queue;

    public priorityQHeapSort()
    {
        queue = new ArrayList<tripleta>();
    }
    public tripleta dequeue()
    {
        tripleta pop = null;
        if(queue.size() != 0){
            pop = queue.get(0);
            queue.remove(0);
        }
        return pop;
    }
    public void enqueue(tripleta push)
    {
        queue.add(push);
        if(queue.size() > 1) heapSortAL.sort(queue); 
        // cada vez que se inserta una tripleta se ordenaría

    }
    public Boolean isEmpty()
    {
        return (queue.size() == 0);
    }
}
