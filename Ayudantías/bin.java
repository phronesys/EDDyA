import java.util.Scanner;

class Solution 
{
    // porfin lo entendí!!, si, revisé el github :v
    static void bin(int n)
    {
        if(n > 1)
            bin(n / 2);
        System.out.println(n % 2 + " ");
    }
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        bin(scan.nextInt());
    }
}