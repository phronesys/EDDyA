import java.util.*;
import java.io.*;

public class sortingtool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        LinkedHashMap<Integer, Integer> nums = new LinkedHashMap<Integer, Integer>();
        for(int i = 0; i < N; i++)
        {
            int n = scan.nextInt();
            int count = nums.containsKey(n) ? nums.get(n) : 0;
            nums.put(n, count + 1);
        }
        System.out.println(nums);
    }
}
