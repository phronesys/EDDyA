/**
 * Selection Sort
 * Ordena haciendo swaps
 * Algoritmo estable
 */

public class selectionSort {

    public static void main(String[] args) {
        int[] a = {1, 10, 9, 7, 8, 5, 6, 4, 3, 2};
        SelectionSort(a);
        drawer.printArray(a);
    }
    public static void SelectionSort(int[] a){
        // Se busca el más pequeño y se intercambia 
        // con la actual pos en i
        
        int N = a.length;

        for (int i = 0; i < N; i++)
        {
            drawer.printArray(a);
            int min = i;
            for(int j = i+1; j < N; j++)
                if (a[j]< a[min]) min = j;
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }
}