import java.util.*;
public class juegoDePrefijos {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Queue<Character> check = new LinkedList();
        Character first = 'a';
        String word = " ";


        int n = scan.nextInt();
        String[] words = new String[n];
        scan.nextLine();
        for(int i = 0; i < n; i++)
        {
            word = scan.nextLine();
            if(i == 0){
                first = word.charAt(0);
            }
            if(word.length() < minLength){
                minLength = word.length();
            }
            check.add(word.charAt(0));
            words[i] = word;
        }

        boolean ExistePrefijoComun = true;
        for(Character x: check)
        {
            if(x != first) ExistePrefijoComun = false;
        }
        if(ExistePrefijoComun){
            String prefijo = divide(words, 0, n-1);
            System.out.println(prefijo);
        }
        scan.close();
    }
    public static String divide(String[] words, int ini, int end)
    {
        if(ini == end) return words[ini];
        int mid = ini + (end - ini)/2; // si el largo es 5, sería 2 a la izquierda 

        String a = divide(words, ini, mid);
        String b = divide(words, mid+1, end);

        String comun = "";
        int an = a.length();
        int bn = b.length();
        int i = 0;
        int j = 0;
        while(i < an && j < bn)
        {
            if(a.charAt(i) == b.charAt(i)){
                comun += a.charAt(i);
            } else {
                break;
            }
            i++;
            j++;
        }
        return comun;
    }
    public static int minLength = 99999;
}
