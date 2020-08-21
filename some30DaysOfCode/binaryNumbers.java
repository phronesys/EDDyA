import java.util.Scanner;

public class binaryNumbers {
    // i already know how to convert to binary
    // i need to make it a string
    public static String binary = "";
    static void bin(int n)
    {
        if(n > 1)
            bin(n / 2);
        binary += Integer.toString(n % 2);
    }

    // function to find repetitive ones
    static int ones()
    {
        char[] binArray = binary.toCharArray();
        int count = 0;
        int max = 0; 
        for(int i = 0; i < binary.length(); i++)
        {
            if(binArray[i] == '0'){
                count = 0;
            }else {
                count++;
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        bin(scan.nextInt());
        System.out.println(ones());
        scan.close();
    }
}