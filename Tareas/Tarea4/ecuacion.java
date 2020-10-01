import java.util.Scanner;
import java.lang.Math;

public class ecuacion {
    public static void main(String[] args) {
        int N;
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        //int[] cases = new int[N];
        ArrayList cases = new ArrayList();
        for(int i = 0; i < N; i++){
            a = scan.nextInt(); 
            b = scan.nextInt(); 
            c = scan.nextInt(); 
            d = scan.nextInt(); 
            e = scan.nextInt(); 
            f = scan.nextInt(); 
            cases.add(solve(a,b,c,d,e,f));
        }
    }
    public static int solve(int a, int b, int c, int d, int e, int f)
    {
        int x;




        return 0;
    }
    // funciones a usar
    public static float aFun(int x){ return a*Math.pow(Math.E, -(x));}
    public static float bFun(int x){ return b*Math.sin(x);}
    public static float cFun(int x){ return c*Math.cos(x);}
    public static float dFun(int x){ return d*Math.tan(x);}
    public static float eFun(int x){ return e*Math.pow(x,2);} 
    public static float fFun(int x){ return f;}
    public static int a, b, c, d, e, f;
}
