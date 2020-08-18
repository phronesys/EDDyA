// Enqueue: add element to last position
// Dequeue: remove the first entered element   

import java.util.*;

class Solution{


    static class queue{
        static Stack<Integer> a = new Stack<Integer>();
        static Stack<Integer> b = new Stack<Integer>();

        static void Enqueue(int x){
            a.push(x);
        }
        static void Dequeue(){
            if(b.isEmpty()){
                while(!a.isEmpty())
                {
                    b.push(a.pop());
                }
            }
            if (!b.isEmpty()){
                b.pop();
            }
        }
        static int getLast(){
            if(b.isEmpty()){
                while(!a.isEmpty())
                {
                    b.push(a.pop());
                }
                return b.peek();
            } else {
                return b.peek();
            }
        }
    };
    public static void main(String[] args)
    {
        queue thequeue = new queue();
        Scanner scan = new Scanner(System.in);
        int N;
        N = scan.nextInt();
        for(int i = 0; i < N; i++){
            switch(scan.nextInt()){
                case 1:
                    thequeue.Enqueue(scan.nextInt());
                    break;
                case 2:
                    thequeue.Dequeue();
                    break;
                case 3:
                    System.out.println(thequeue.getLast());
                    break;
                default:
                    return;
            }
        }
        scan.close();
    }    
}

