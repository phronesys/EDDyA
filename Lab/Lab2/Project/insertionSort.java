/**
 * Insertion Sort
 * Ordenamiento de cartas
 * Estable
 */

import java.util.*;
public class insertionSort {
    public static void InsertionSort(int[] a)
    {
        int N = a.length;
        for (int i = 1; i < N; i++)
        {
            //drawer.printArray(a);
            for(int j = i; (j > 0 && a[j] < a[j-1]); j--)
            {
                int temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
            } 
        }
    }
    public static ArrayList<tripleta> insertionSortDec(ArrayList<tripleta> array)
    {
        for(int i = 1; i < array.size(); i++){
            tripleta temp = array.get(i);
            int j = i - 1;
            while(j >= 0 && array.get(j).getDmg() < temp.getDmg())
            {
                array.set(j+1, array.get(j));
                j = j - 1; 
            }
            array.set(j+1, temp);
        }
        return array;
    }
}
