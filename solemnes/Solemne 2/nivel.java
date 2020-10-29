import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.lang.*;
public class nivel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack stack = new Stack();
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = scan.nextInt();
        }
        if(k == 0){
            System.out.println(nums[0]);
        }else{
            for(int i = (int)Math.pow(2,k); i >= Math.pow(2,(k-1)); i--)
            {
                stack.push(nums[i]);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
    
}
