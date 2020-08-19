import java.util.Scanner;

class Solution{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        if(scan.nextInt() % 2 == 0 ) 
            System.out.println("PAR");
        else
            System.out.println("IMPAR");
    }
}