import java.util.ArrayList;

public class MaxHeap 
{
    private ArrayList<Tripleta> Heap;

    public MaxHeap() 
    {
        Heap = new ArrayList<Tripleta>();
    }

    private int parent(int pos) {return (pos-1)/2;}
    private int leftChild(int pos) {return (2*pos)+1;}
    private int rightChild(int pos) {return (2*pos)+2;}

    private void swap(int fpos, int spos) {
        Tripleta tmp;
        tmp = (Tripleta)(Heap.get(fpos));
        Heap.set(fpos,Heap.get(spos));
        Heap.set(spos,tmp);
    }

    private void downHeapify(int pos) 
    {
        if (pos >= ((Heap.size()-1)/2) && pos <= (Heap.size()-1))
        {
            return;
        }
        if (((Tripleta)Heap.get(pos)).getDmg() < ((Tripleta)Heap.get(leftChild(pos))).getDmg() || 
            ((Tripleta)Heap.get(pos)).getDmg() < ((Tripleta)Heap.get(rightChild(pos))).getDmg()) 
        {
            if (((Tripleta)Heap.get(leftChild(pos))).getDmg() > ((Tripleta)Heap.get(rightChild(pos))).getDmg()) 
            {
                swap(pos, leftChild(pos));
                downHeapify(leftChild(pos));
            } 
            else 
            {
                swap(pos, rightChild(pos));
                downHeapify(rightChild(pos));
            }
        }
    }

    private void heapifyUp(int pos) 
    {
        Tripleta temp = (Tripleta)Heap.get(pos);
        while(pos>0 && temp.getDmg() > ((Tripleta)Heap.get(parent(pos))).getDmg())
        {
            Heap.set(pos,(Tripleta)Heap.get(parent(pos)));
            pos = parent(pos);
        }
        Heap.set(pos,temp);
    }

    public void insert(Tripleta element) 
    {
        Heap.add(element);
        int current = Heap.size()-1;
        heapifyUp(current);
    }

    public void print() 
    {
        for (int i=0; i<(Heap.size()-1)/2; i++) 
        {
            System.out.print(+ ((Tripleta)Heap.get(i)).getDmg() + ": L- " + ((Tripleta)Heap.get((2*i)+1)).getDmg() + " R- " + ((Tripleta)Heap.get((2*i)+2)).getDmg());
            System.out.println();
        }
    }

    public Tripleta extractMax() 
    {
        Tripleta max = ((Tripleta)Heap.get(0));
        Heap.set(0,(Tripleta)Heap.get(Heap.size()-1));
        Heap.remove(Heap.size()-1);
        downHeapify(0);
        return max;
    }

    public static void main(String[] arg)
    {
        MaxHeap maxHeap = new MaxHeap();
        Tripleta t1, t2, t3, t4, t5, t6, t7;
        t1 = new Tripleta("1", "1", "A");
        t2 = new Tripleta("2", "4", "B");
        t3 = new Tripleta("3", "2", "C");
        t4 = new Tripleta("4", "5", "D");
        t5 = new Tripleta("5", "13", "E");
        t6 = new Tripleta("6", "6", "F");
        t7 = new Tripleta("7", "17", "G");
        maxHeap.insert(t1);
        maxHeap.insert(t2);
        maxHeap.insert(t3);
        maxHeap.insert(t4);
        maxHeap.insert(t5);
        maxHeap.insert(t6);
        maxHeap.insert(t7);

        maxHeap.print();
        System.out.println("The max is " + maxHeap.extractMax().getDmg());
    }
}