import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class sparseArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        
        int N = scan.nextInt();
        String strings[] = new String[N];
        for(int i = 0; i < N; i++){
            strings[i] = scan.nextLine();
        }
        scan.nextLine();

        int M = scan.nextInt();
        String queries[] = new String[M];
        for(int i = 0; i < M; i++){
            queries[i] = scan.nextLine();
        }
        scan.nextLine();


        int[] result = new int[M];
        
        

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(strings[j].equals(queries[i])){
                   System.out.println(j);
                }
            }
        }
        /* for(int i : result){ 
            System.out.println(i);
        
        } */
        
    }
}
