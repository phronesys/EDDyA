/**
 * maxHeap:
 *      
 * 
 * source:
 *      https://www.geeksforgeeks.org/building-heap-from-array/
 */
public class maxHeap {

    public static void buildHeapArray(int A[], int n){
        for(int i = (n / 2) - 1; i >= 0; i--) heapSort.heapify(A, n, i);    // con esto puedo hacer un maxHeap recursivo usando
                                                                            // heapify ya implementado en heapSort
    }
    public static void buildBinaryHeap(){

    }
    
    
    
}
