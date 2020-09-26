/**
 * BubbleSort
 *      -Revisa cada elemento con su siguiente, 
 *      intercambiandolos de posición si 
 *      están en orden equivocado.
 *      -Algoritmo Estable.
 */
class bubbleSort {
    public static void main(String[] args) {
        int[] a = {1, 10, 9, 7, 8, 5, 6, 4, 3, 2};
        BubbleSort(a);
        //drawer.printArray(a);
    }
    
    static void BubbleSort(int arr[]){
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            
            for(int j = 0; j < n - i - 1; j++) {
                drawer.printArray(arr);
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}