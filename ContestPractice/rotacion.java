import java.io.*;
import java.util.*;

public class rotacion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int D = scan.nextInt();
        int[] X = new int[N];
        for(int i = 0; i < N; i++){
            if((N - D + i) < N){
                X[N - D + i] = scan.nextInt();
            } else{
                X[N - i - 1] = scan.nextInt();
            }
        }
        for(int x: X){
            System.out.print(x + " ");
        }
        scan.close();
    }
}
