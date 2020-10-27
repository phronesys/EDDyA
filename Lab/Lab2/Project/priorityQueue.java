import java.util.ArrayList;
import java.io.*;
/* 
 * source:
 *      https://www.geeksforgeeks.org/building-heap-from-array/
 *      https://www.geeksforgeeks.org/max-heap-in-java/
 *      Codigo profe    
 */
public class priorityQueue {
    public ArrayList<tripleta> heap;
    
    priorityQueue()
    {
        heap = new ArrayList<tripleta>();
    }
    private int parent(int pos) {return (pos-1)/2; }
    private int left(int pos) {return (pos*2)+1; }
    private int right(int pos) {return (pos*2)+2; }


    private void swap(int a, int b){
        tripleta temp;
        temp = (tripleta)heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }
    private void Heapify(int pos)
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
        tripleta max = (tripleta)heap.get(0);
        heap.set(0, (tripleta)heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        Heapify(0);
        return max; // esta tripleta debe añadirse al dataset
    }
    private void heapifyUp(int pos)
    {
        tripleta temp = (tripleta)heap.get(pos);
        while( pos > 0 && temp.getDmg() > ((tripleta)heap.get(parent(pos))).getDmg())
        {
            heap.set(pos, (tripleta)heap.get(parent(pos)));
            pos = parent(pos);
        }
        heap.set(pos,temp);
    }

    public void add(tripleta trip){
        heap.add(trip);

        int current = heap.size() - 1;
        // se debe arreglar el maxHeap
        // esto compara el nodo con el padre
        // si el nodo.dmg es mayor reemplaza la pos del padre
        heapifyUp(current);
    }
    public void print()
    {
        for(int i = 0; i < (heap.size()-1)/2; i++)
        {
            
            System.out.println(heap.get(i).getId()+","+heap.get(i).getDmg()+","+heap.get(i).getChamp());
        }
    }
    public void printOrder()
    {
        while(heap.size() > 1)
        {
            tripleta tri = getMax();
            System.out.println(tri.getId()+","+tri.getDmg()+","+tri.getChamp());
        }
    }
    public void exportHeap()
    {
        write.export(heap);
    }
    public void exportOrder()
    {
        BufferedWriter writer;
        String outfile = "out.csv";
        try{
            writer = new BufferedWriter(new FileWriter(outfile, false));
            while(heap.size() > 1)
            {
                tripleta x = getMax();
                writer.write(Integer.toString(x.getId()));
                writer.write(",");
                writer.write(Integer.toString(x.getDmg()));
                writer.write(",");
                writer.write(x.getChamp());
                writer.write("\n");
            }
            writer.close();
        }catch(IOException e){e.printStackTrace();}
    }
    public boolean isEmpty(){
        return (heap.size() > 0 == true);
    }
}
