import java.util.Scanner;


public class repeticiones1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String ADN = scan.nextLine();
        char[] adn = ADN.toCharArray();
        divide(adn, 0, adn.length-1);
        System.out.println(max);
        scan.close();
    }
    public static void divide(char[] adn, int ini, int end){
        if(ini == end) return; 
        int a = ini;
        int b = ini;
        int len = (b - a + 1); // length current subarray
        if(adn[ini] == adn[ini+1]){
            while(adn[a] == adn[b] && b < end){
                b++;
            }
            if(b == end){
                len = (b - a + 1);
            }
            divide(adn, b, end);
        }else{
            len = (b - a);
            divide(adn, b+1, end);
            
        }
        // b-1 es la ultima pos del substring
        if(len > max) max = len;
    }
    public static int max = Integer.MIN_VALUE;
}
