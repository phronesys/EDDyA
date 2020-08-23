import java.util.*;


public class UnosYCeros {

    static void bin(String s, String fin, int i)
    {   
        if(i == s.length()){
            System.out.println(fin);
            return;
        }
        while(s.charAt(i) != '?'){
            fin += s.charAt(i);
            i++;
        }
        //System.out.println(fin);
        bin(s, fin+'0', i+1);
        bin(s, fin+'1', i+1);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine(); //100?10?
        String fin = "";
        int i = 0;
        bin(s, fin, i);
        scan.close();
    }
}