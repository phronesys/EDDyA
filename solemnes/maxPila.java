import java.util.*;

public class maxPila {
    public static void main(String[] args) {
        Stack pila = new Stack();
        Stack maxInPila = new Stack();
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        maxInPila.add(0);
        for(int i = 0; i < N; i++){
            switch(scan.nextInt()){
                case 1:
                    int x = scan.nextInt();
                    if((Integer)maxInPila.peek() < x){
                        maxInPila.add(x);
                    }
                    pila.add(x);
                    break;
                case 2:
                    if(maxInPila.peek() == pila.peek()) 
                        maxInPila.pop();
                    pila.pop();
                    break;
                case 3:
                    System.out.println(maxInPila.peek());
                    break;
                default:
                    break;
            }
        }
    }
}
