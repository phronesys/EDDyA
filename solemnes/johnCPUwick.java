import java.util.*;

public class johnCPUwick {
    public static void main(String[] args) {
        List<Integer> actual = new ArrayList<Integer>();
        List<Integer> perfecta = new ArrayList<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        
        for(int i = 0; i < N; i++){
            actual.add(scan.nextInt());
        }
        for(int i = 0; i < N; i++){
            perfecta.add(scan.nextInt());
        }
        int unidad = 0;
        boolean isNotOrdered = true;
        int index = 0;
        for(int i = 0; i < N; i++){
            unidad++;
            while(actual.get(i) != perfecta.get(i)){
                actual.add(actual.get(i));
                actual.remove(i);
                unidad++;
            }

        }
        
        System.out.println(unidad);

    }
}
