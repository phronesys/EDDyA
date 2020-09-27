/* 
 * Merge Sort is a Divide and Conquer Approach
 * It has a merge method, that consist in sorting an array
 * dividing it by two.
 * The main part occurs in mergesort method, which is recursive
 * and consist in subdividing the array in two.
 * 
 * Time complexity of Merge Sort is O(nLogn) 
 * in all 3 cases (worst, average and best)
 */
public class mergeSort {
    public static void main(String[] args) {
        int[] a = {1, 10, 9, 7, 8, 5, 6, 4, 3, 2};
        //merge(a, 0, (a.length/2), a.length);
        drawer.printArray(a);
    }
    // first subarray = arr[p..q]
    // second   ´´    = arr[q+1..r] 
    public static void merge(int a[], int p, int q, int r)
    {
        // from binarySearch: mitad = ini + (fin - ini)/2
        // length aux subarrays
        int n1 = q - p + 1; // 6
        int n2 = r - q +1; // 6

        // subarrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // copying into subarrays
        for(int i = 0; i < n1; i++)
            L[i] = a[p + i];
        for(int i = 0; i < n2; i++)
            R[i] = a[q + i];
        
        L[n1] = Integer.MAX_VALUE;
        R[n1] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        for(int k = p; k < r; k++)
        {
            if(L[i] <= R[j]){
                a[k] = L[i];
                i++;
            }else{
                a[k] = R[j];
                j++;
            }
        }

    }
    public static void sort()
    {

    }
}
