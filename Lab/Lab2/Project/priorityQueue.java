import java.util.ArrayList;
/* 
 * source:
 *      https://www.geeksforgeeks.org/building-heap-from-array/
 *      https://www.geeksforgeeks.org/max-heap-in-java/
 *      Codigo profe    
 */
public class priorityQueue {
    public static ArrayList<tripleta> heap;
    
    priorityQueue()
    {
        heap = new ArrayList<tripleta>();
    }
    private static int parent(int pos) {return (pos-1)/2; }
    private static int left(int pos) {return (pos*2)+1; }
    private static int right(int pos) {return (pos*2)+2; }


    private static void swap(int a, int b){
        tripleta temp;
        temp = (tripleta)heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }
    private static void Heapify(int pos)
    {
        // si corresponde a la parte de nodos ya extraidos se retorna
        if(pos >= (heap.size()/2 - 1) && pos <= heap.size() - 1) return;
        // si el dmg de padre es menor a uno de sus hijos
        if (heap.get(pos).getDmg() < heap.get(left(pos)).getDmg() ||
            heap.get(pos).getDmg() < heap.get(right(pos)).getDmg())
        {
            if(heap.get(left(pos)).getDmg() > heap.get(right(pos)).getDmg())
            {
                swap(pos, left(pos));
                Heapify(left(pos));
            }
            else
            {
                swap(pos, right(pos));
                Heapify(right(pos));
            }
        }
    }
    public tripleta getMax()
    {
        tripleta max = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        Heapify(0);
        return max; // esta tripleta debe añadirse al dataset
    }
    public void add(tripleta trip){
        heap.add(trip);

        int current = heap.size() - 1;
        // se debe arreglar el maxHeap
        // esto compara el nodo con el padre
        // si el nodo.dmg es mayor reemplaza la pos del padre
        while(heap.get(current).getDmg() > heap.get(parent(current)).getDmg() && current > 0){
            swap(current, parent(current));
            current = parent(current);
        }
    }
    public boolean isEmpty(){
        return (heap.size() > 0 == true);
    }
}
