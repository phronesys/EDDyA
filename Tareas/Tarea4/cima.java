import java.util.Scanner;

public class cima {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Integer[] array = new Integer[N];
        for(int i = 0; i < N; i++){
            array[i] = scan.nextInt();
        }
        sort(array, 0, N-1);
        if(array[N-1] != array[N-2]){
            System.out.println(array[N-1]);
        }else{
            System.out.println();
        }
        scan.close();
    }
    public static void merge(Integer a[], int p, int q, int r)
    {     
        // length aux subarrays
        int n1 = q - p + 1; 
        int n2 = r - q; 

        // subarrays
        Integer L[] = new Integer[n1]; 
        Integer R[] = new Integer[n2];

        // copying into subarrays
        for(int i = 0; i < n1; ++i) // 0,1,2,3,4; 5 pos de n1
            L[i] = a[p + i];    // recorre 0,1,2,3,4
        for(int j = 0; j < n2; ++j)
            R[j] = a[q + j +1];    // recorre 5,6,7,8,9 
              
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
    public static void sort(Integer[] a, int p, int r)
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
