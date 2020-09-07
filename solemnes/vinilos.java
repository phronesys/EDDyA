import java.util.*;

public class vinilos {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Queue<Integer> cola = new LinkedList<Integer>();
        Stack pila = new Stack();
        Stack max = new Stack();
        for(int i = 0; i < N; i++) {
            cola.add(scan.nextInt());
        }
        while (!cola.isEmpty())
        {
            if(pila.isEmpty()){
                pila.add(cola.poll());
            } else if((Integer)pila.peek() <= cola.peek()){
                pila.add(cola.poll());
                System.out.println("-");
            } else {
                while(!pila.isEmpty()) {
                    System.out.print(pila.pop() + " ");
                }
                System.out.println();
                pila.add(cola.poll());
            }
        }
        if(!pila.isEmpty()){
            while(!pila.isEmpty()) {
                System.out.print(pila.pop() + " ");
            }
            System.out.println();
        }
    }
}
