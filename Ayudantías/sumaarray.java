import java.util.Scanner;

class Solution{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int x = 0;
        while(N != 0){
            x += scan.nextInt();
            N--;
        }
        System.out.println(x);
        scan.close();
    }
}