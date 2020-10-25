import java.util.ArrayList;

/*  Heapsort para ArrayList<tripleta> 
    con minHeap para que el orden sea descendiente
*/
import java.util.*;

public class heapSortAL {
    
    public static ArrayList<tripleta> sort(ArrayList<tripleta> trip)
    {
        int n = trip.size();
        for(int i = n / 2 - 1; i >= 0; i--) 
        {
            heapify(trip, n, i);
        }
        // array list en minheap
        for(int i = n - 1; i >= 0; i--)
        {
            tripleta temp = (tripleta)trip.get(0); // en el root debe estar el menor elemento y será puesto al final
            trip.set(0, trip.get(i));
            trip.set(i, temp);

            heapify(trip, i, 0); // se restringe la cantidad de nodos a los no ordenados
        }
        return trip;
    }
    public static void heapify(ArrayList<tripleta> trip, int n, int i)
    {
        int smallest = i; // root pos
        int left = 2*i + 1;
        int right = 2*i + 2;

        // tiene que quedar la tripleta con menor dmg como root
        // primero se busca la posición donde esta el menor
        if(left < n && trip.get(left).getDmg() < trip.get(smallest).getDmg()){
            smallest = left;
        }
        if(right < n && trip.get(right).getDmg() < trip.get(smallest).getDmg()){
            smallest = right;
        }
        if(smallest != i){ // si es uno de los hijos
            tripleta temp = (tripleta)trip.get(i);
            trip.set(i, trip.get(smallest));
            trip.set(smallest, temp);

            // en caso verse alterado el orden de los sub nodos al cambiar
            heapify(trip, n, smallest); 
        }

    }
}
