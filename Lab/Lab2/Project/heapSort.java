
/**
 * heapSort
 * 
 * code based on:
 * https://www.geeksforgeeks.org/heap-sort/
 */
public class heapSort {

    public static void sort(int A[])
    {
        int n = A.length;
        // recorre cada nodo con hijo y lo ordena coo maxHeap
        for(int i = n / 2 - 1; i >= 0; i --) // empieza en el nodo donde sus hijos son los ultimos elementos
            heapify(A, n, i);
        
            // aca ya se tiene el maxHeap entero
        for(int i = n - 1; i > 0; i--)
        {
            // se guarda el root en la ultima mayor posición
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;

            heapify(A, i, 0);   // aca se deja en heap
            // este heap no se desordena con la recursion gracias
            // a que se evalua que los nodos hijos esten dentro del rango del array
            // ex: left < n , donde n corresponde al valor de i que se le manda.
        }
    }
    // this function converts a part of the heap in a max heap (top-down)
    public static void heapify(int A[], int n, int i)
    {   
        int largest = i;
        int left = 2*i + 1; // en el heap (completo) este es el nodo izquierdo del actual i
        int right = 2*i + 2; // hijo derecho

        if(left < n && A[left] > A[largest]){
            largest = left;
        }
        if(right < n && A[right] > A[largest]){
            largest = right;
        }
        // aca se tiene el valor mayor en largest entre el padre y los hijos
        if(largest != i){
            int temp =  A[i];
            A[i] = A[largest];
            A[largest] = temp;
            // se cambian los nodos correspondientes dejandolo en max heap
            heapify(A, n, largest); // se baja al hijo cambiado a hacer todo lo anterior
        }
    }
}
