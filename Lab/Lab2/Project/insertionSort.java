/**
 * Insertion Sort
 * Ordenamiento de cartas
 * Estable
 */
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
}
