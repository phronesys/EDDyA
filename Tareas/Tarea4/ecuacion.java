import java.util.Scanner;
import java.lang.Math;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class ecuacion {
    public static void main(String[] args) {
        int N;
        int a, b, c, d, e, f;
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
        N = scan.nextInt();
        
        for(int i = 0; i < N; i++){
            boolean flag = false;
            a = scan.nextInt(); 
            b = scan.nextInt(); 
            c = scan.nextInt(); 
            d = scan.nextInt(); 
            e = scan.nextInt(); 
            f = scan.nextInt(); 
            for(double x = 0.0000; x <= 1.0; x += 0.0001){
                double ecu = (((float)a*Math.pow(Math.E, -(x))) + ((float)b*Math.sin(x)) + ((float)c*Math.cos(x)) + ((float)d*Math.tan(x)) + ((float)e*Math.pow(x, 2)) + f);
                
                if(ecu < 0.0001){
                    double num = Math.round(x * 10000d) /10000d;
                    System.out.println(num);
                    flag = true;
                    break;
                }
            }  
            if(!flag){
                System.out.println("No existe");
            }
        }
        
        scan.close();
    }
}
