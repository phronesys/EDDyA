import java.util.*;


class Solution
{
    static class MaxStack{
        static Stack<Integer> Elementos = new Stack<Integer>();
        static Stack<Integer> MaxElemento = new Stack<Integer>();

        static void push(int x)
        {
            Elementos.push(x);
            if(Elementos.size() == 1){
                MaxElemento.push(x);
                return;
            }
            if(x > MaxElemento.peek())
                MaxElemento.push(x);
            else
                MaxElemento.push(MaxElemento.peek());
        }
        static int getMax()
        {
            return MaxElemento.peek();
        }
        static void pop()
        {
            Elementos.pop();
            MaxElemento.pop();
        }
    };
    public static void main(String[] args)
    {
        MaxStack maxstack = new MaxStack();
        Scanner scan = new Scanner(System.in);
        int N;
        N = scan.nextInt();
        for (int i = 0; i < N; i++){
            switch(scan.nextInt()){
                case 1:
                    maxstack.push(scan.nextInt());
                    break;
                case 2:
                    maxstack.pop();
                    break;
                case 3:
                    System.out.println(maxstack.getMax());
                    break;
                default:
                    break;
            }
        }
        scan.close();
    }
}