import java.util.*;

public class collatz {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);    
        int n = scan.nextInt();
        coll(n);
        scan.close();
    }
    public static void coll(int n){
        if(n == 0) return;
        if(n == 1){
            System.out.println(n);
            return;
        }
        System.out.print(n + " ");
        if(n % 2 == 0){
            coll(n/2);
        }else {
            coll((n*3)+1);
        }
    }
}
