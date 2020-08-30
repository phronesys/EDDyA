public class solution3{

    public static void main(String[] args)
    {
        int[] arr = {1, 3, 4, 5, 6};
        // se busca faltante de numeros de 1 hasta n=6
        int n = 6;
        boolean[] table = new boolean[n];
        int number = 0;

        for (int i = 0; i < n - 1; ++i) {
            //System.out.println(arr[i] - 1);
            // Se deja en true las posiciones 0 2 3 4 5
            table[arr[i] - 1] = true; 
        }
        for(int i = 0; i < n; ++i) {
            System.out.println(table[i]);
            if(table[i] == false){ // se busca donde están los false
                number = i + 1;
                
            }
        }
        System.out.println(number);
        // resulta útil para encontrar más de un número faltante en un array
    }
}
