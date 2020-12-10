import java.util.HashMap;
import java.util.Scanner;

public class hashmap {
    public static void main(String[] args) {
        HashMap<String, Boolean> hm = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        int m, n;
        m = scan.nextInt();
        n = scan.nextInt();
        scan.nextLine();
        // first I should create a dictionary
        for(int i = 0; i < m; i++){
            String add = scan.nextLine();
            hm.put(add, true);
        }
        boolean check = true;
        for(int i = 0; i < n; i++){
            String currentIn = scan.nextLine();
            check = checkCurrent(currentIn, hm);
            if(check == false){
                System.out.println("No");
                break;
            }
        }
        if(check)
            System.out.println("Yes");
        scan.close();
            
    }
    public static boolean checkCurrent(String currentIn, HashMap<String, Boolean> hm){
        if(hm.isEmpty())
            return false;
        if(hm.get(currentIn) == true){
            hm.remove(currentIn);
            return true;
        }else {
            return false;
        }
    
    }
}
