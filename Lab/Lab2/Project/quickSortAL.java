import java.util.ArrayList;

/**
 * quickSortAL: quick sort para ArrayList<tripleta> segun .getDmg()
 */
public class quickSortAL {
    public static ArrayList<tripleta> quickSort(ArrayList<tripleta> trip, int ini, int end)
    {
        if(ini < end){
            int pi = partition(trip, ini, end);
            quickSort(trip, ini, pi - 1);
            quickSort(trip, pi + 1, end);
        }
        return trip;
    }
    public static int partition(ArrayList<tripleta> trip, int ini, int end)
    {
        int pivote = trip.get(end).getDmg();
        int i = ini - 1;

        // se ordenan los valores menores y mayores al pivote, encontrando la posición del mismo
        for(int j = ini; j < end; j++)
        {
            if(trip.get(j).getDmg() < pivote)
            {
                i++;
                tripleta temp = (tripleta)trip.get(i);
                trip.set(i, trip.get(j));
                trip.set(j, temp);
            }
        }
        tripleta temp = (tripleta)trip.get(i+1);
        trip.set(i+1, trip.get(end));
        trip.set(end, temp);

        return i+1;
    }
}
