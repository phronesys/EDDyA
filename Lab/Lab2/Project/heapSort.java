
/**
 * heapSort 
 *      Como se esta trabajando con ArrayList, este codigo fue adaptado para ello.
 * 
 * code based on:
 * https://www.geeksforgeeks.org/heap-sort/
 * reciclado de: https://github.com/phronesys/EDDyA/blob/master/Algorithms/heapSort.java
 * 
 */
public class heapSort {

    public static void sort(int A[])
    {
        int n = A.length;
        for(int i = n / 2 - 1; i >= 0; i --) 
            heapify(A, n, i);
        
        for(int i = n - 1; i > 0; i--)
        {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;

            heapify(A, i, 0); 
        }
    }
    public static void heapify(int A[], int n, int i)
    {   
        int largest = i;
        int left = 2*i + 1; 
        int right = 2*i + 2; 

        if(left < n && A[left] > A[largest]){
            largest = left;
        }
        if(right < n && A[right] > A[largest]){
            largest = right;
        }
        if(largest != i){
            int temp =  A[i];
            A[i] = A[largest];
            A[largest] = temp;
            heapify(A, n, largest); 
        }
    }
}
