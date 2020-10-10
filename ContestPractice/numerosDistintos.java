import java.util.*;

public class numerosDistintos {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        ArrayList<Integer> num = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            int x = scan.nextInt();
            if(!num.contains(x)){
                num.add(x);
            }
        }
        if(num.size() == 1){
            System.out.println(0);
        } else {
            System.out.println(num.size());
        }
        scan.close();
    }
}
