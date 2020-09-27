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
        drawer.printArray(a);
        //merge(a, 0, (a.length/2), a.length);
        sort(a, 0, a.length -1);
        drawer.printArray(a);
    }
    // first subarray = arr[p..q]
    // second   ´´    = arr[q+1..r] 
    public static void merge(int a[], int p, int q, int r)
    {     
        // length aux subarrays
        int n1 = q - p + 1; 
        int n2 = r - q; 

        // subarrays
        int L[] = new int[n1]; 
        int R[] = new int[n2];

        // copying into subarrays
        for(int i = 0; i < n1; ++i) // 0,1,2,3,4; 5 pos de n1
            L[i] = a[p + i];    // recorre 0,1,2,3,4
        for(int j = 0; j < n2; ++j)
            R[j] = a[q + j +1];    // recorre 5,6,7,8,9 
        
        
        drawer.printArray(L);
        drawer.printArray(R);
        int i = 0;
        int j = 0;

        int k = p;
        while(i < n1 && j < n2)
        {
            if(L[i] <= R[j]){
                a[k] = L[i];
                i++;
            }else{
                a[k] = R[j];
                j++;
            }
            k++;
        } 
        while(i < n1){
            a[k] = L[i];
            i++;
            k++;
        }
        while(j < n2){
            a[k] = R[j];
            j++;
            k++;
        }
        
    }
    public static void sort(int[] a, int p, int r)
    {
        if(p < r)
        {
            int q = p + (r - p)/2; // mitad
            sort(a, p, q);
            sort(a, q+1, r);
            merge(a, p, q, r);
        } 
    }
}
