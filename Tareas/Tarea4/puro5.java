import java.util.Scanner;
import java.util.Arrays;

public class puro5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] notas = new int[N];

        float promActual = 0;
        for(int i = 0; i < N; i++)
        {
            notas[i] = scan.nextInt();
        }
        promActual = prom(notas);
        if(promActual >= 4.5){
            System.out.println(0);
        } else {
            Arrays.sort(notas); // QuickSort, no piden implementarlo e.e     
            solve(notas, promActual);
            System.out.println(index);
        }
        
        scan.close();
    }
    public static void solve(int[] notas, float promedio){
        while(promedio < 4.5){
            notas[index] = 5;
            index++;
            promedio = prom(notas);
        }
    }   
    public static float prom(int[] notas){
        float promedio = 0;
        for(int i = 0; i < notas.length; i++)
        {
            promedio += notas[i];
        }
        promedio /= (notas.length);
        return promedio;
    }
    public static int index = 0;
}
