import java.util.*;

public class sumaspares {
    public static Queue<Integer> even = new LinkedList<Integer>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int size = s.length();
        int[] A = new int[size];
        for(int i = 0; i < size; i++)
        {
            A[i] = Character.getNumericValue(s.charAt(i));
        }
        
        int n_pair = countPair(A);
        for(int i = 0; i < size; i++)
        {
            System.out.print(n_pair + " ");
            if(A[i] == even.peek()){
                n_pair--;
                even.remove();
            }
            
        }
        System.out.println();
    }
    public static int countPair(int[] A){
        int cont = 0;
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] % 2 == 0){
                even.add(A[i]);
                cont++;
            }
                
        }
        return cont;
    }
}
