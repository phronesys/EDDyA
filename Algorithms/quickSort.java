/*
 *  Quick Sort approach
 *  consiste en dividir el array según el valor del pivote
 *  en esta implementación el pivote es el ultimo elemento
 *  
 *  -Algoritmo no estable(cambiando el pivote se puede hacer estable)
 *  -Bueno para arrays
 *  -Malo pa linked lists
 *  
 * 
 */

public class quickSort {
    public static void main(String[] args) {
        int[] a = {1, 10, 9, 7, 8, 5, 6, 4, 3, 2};
        drawer.printArray(a);
        QuickSort(a, 1, a.length-1);
        //drawer.printArray(a);
    }
    public static void QuickSort(int A[], int ini, int end){
        drawer.printArray(A);
        if(ini < end){
            int pi = Partition(A, ini, end);
            QuickSort(A, ini, pi - 1);
            QuickSort(A, pi + 1, end);
        }
    }
    public static int Partition(int A[], int ini, int end){
        int pivote = A[end];
        int i = ini - 1; // lugar a dejar el valor menor que el pivote
        // si es mayor solo aumenta la pos de j
        for(int j = ini; j < end; j++){
            if(A[j] < pivote){
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        // aquí el pivote es colocado en la posición que le corresponde
        // (luego de todos los valores menores a él)
        int temp = A[i+1];
        A[i+1] = A[end];
        A[end] = temp;
        
        return i+1;
    }
}
