import java.util.Scanner;
import java.lang.Math;

public class manzanas {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Long sumA = 0L;
        Long sumB = 0L;
        for(int i = 0; i < N; i++){
            if(sumA == 0L || sumA < sumB){
                sumA += scan.nextLong();
            }else{
                sumB += scan.nextLong();
            }
        }
        System.out.println(Math.abs(sumA - sumB));
        scan.close();
    }
}
