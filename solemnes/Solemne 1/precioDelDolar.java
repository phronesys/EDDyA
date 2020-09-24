import java.util.Scanner;

public class precioDelDolar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        int N = scan.nextInt();
        int[] numeros = new int[N];
        for(int i = 0; i < T; i++){
            for(int j = 0; j < N; j++){
                numeros[j] = scan.nextInt();
            }
            System.out.print(1 + " ");
            for(int j = 1; j < N; j++){
                if(numeros[j] >= numeros[j-1]){
                    System.out.print((j+1) + " ");
                } else {
                    System.out.print(1 + " ");
                }
            }
            
            //System.out.println();
        }

        /* for(int i = 0; i < N; i++){
            numeros[i] = scan.nextInt();
        }
        // si es menor que el anterior se coloca un 1
        // si es mayor que el anterior se coloca index+1
        System.out.print(1 + " ");
        for(int i = 1; i < N; i++){
            if(numeros[i] >= numeros[i-1]){
                System.out.print((i+1) + " ");
            } else {
                System.out.print(1 + " ");
            }
        }
        for(int j = 0; j < T; j++){

        } */
    }
}
