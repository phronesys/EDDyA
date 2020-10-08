import java.util.Scanner;

public class invertirString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String reversed = reverse(scan.nextLine());
        System.out.println(reversed);
        scan.close();
    }
    public static String reverse(String s){
        if(s.length() <= 1) return s;
        return reverse(s.substring(1)) + s.charAt(0);
    }
}
