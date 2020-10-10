import java.util.*;
import java.lang.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ecuacion2 {
    public static void main(String[] args) {
        int N = scan.nextInt();
        for(int i = 0; i < N; i++)
        {
            System.out.println(solve());
        }
        scan.close();
    }
    public static String solve()
    {
        //df.setRoundingMode(RoundingMode.DOWN);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();
        int e = scan.nextInt();
        int f = scan.nextInt();

        float x = 0;
        while(x <= 1.0)
        {
            double ec = (((float)a*Math.pow(Math.E, -(x))) 
                + ((float)b*Math.sin(x)) + ((float)c*Math.cos(x)) 
                + ((float)d*Math.tan(x)) + ((float)e*Math.pow(x, 2)) + (float)f);
            if(ec  < 0.00001){
                //System.out.println(x);
                return df.format(x);
            }
            x += 0.0001;
        }
        return "No existe";
    }
    public static Scanner scan = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("#.####");
}
