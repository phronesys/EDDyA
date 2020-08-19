import java.util.*;
class invert{

    static void Solution(String word){
        if(word.length() == 0) return;
        byte[] wrd = word.getBytes();
        int i = 0;
        int j = word.length() - 1;
        while(i < j){
            byte temp = wrd[i];
            wrd[i] = wrd[j];
            wrd[j] = temp;
            i++;
            j--;
        }
        String inverted = new String(wrd);
        System.out.println(inverted);
    }
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String cosa = scan.nextLine();
        Solution(cosa);
    }
}