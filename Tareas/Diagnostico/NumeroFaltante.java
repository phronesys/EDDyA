import java.util.*;


public class NumeroFaltante {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int sumaN = 0;
        int sumaX = 0;
        for (int i = 1; i < N+1; i++) {
            sumaN += i;
        }
        int x;
        for (int i = 0; i < N - 1; i++) {
            x = scan.nextInt();
            sumaX += x;
        }
        System.out.println(sumaN - sumaX);
    }
}