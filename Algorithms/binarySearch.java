import java.util.*;

public class binarySearch {
    public static void main(String[] args) {
        int[] uwu = new int[100];
        for(int i = 0; i < 100; i++){
            uwu[i] = i+1;
        }
        
        int x = search(31,uwu, 0, uwu.length-1);
        System.out.println("encontrado " + x);
        int[] ewe = {2,3,4,10,40};
        System.out.println(search(10, ewe, 0, ewe.length-1));
    }
    static int search(int x, int arr[], int ini, int fin){
        if(fin > ini){
            int mitad = ini + (fin - ini)/2; // esta parte es super importante
            if(x == mitad){
                return mitad;
            } 
            if(x < arr[mitad]){
                return search(x, arr, ini, mitad -1);
            }    
            return search(x, arr, mitad +1, fin);
        }
        return -1;
    }
}