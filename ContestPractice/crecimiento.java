import java.util.Scanner;

public class crecimiento {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt();
        int T = scan.nextInt();
        int x = 0;
        if(M > T){
            System.out.println(x);
        } else {
            while(T >= M){
                T *= 2;
                M *= 3;
                x++;
            }
            System.out.println(x);
        }
        scan.close();
    }
}
