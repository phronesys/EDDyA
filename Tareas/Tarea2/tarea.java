public class tarea {
    public static void main(String[] args) {
        int arr[] = {23,4,5,8,231,2,3};
        
        System.out.println(algoc(11587,1187));
    }
    static void print(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    static void algo1(int arr[]) {
        // este algoritmo ordena numeros en forma creciente
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) { 
            int min_idx = i;
            for(int j = i + 1; j < n; j++){
                // si arr en j es menor que arr en min index, j será el index del menor elemento
                if(arr[j] < arr[min_idx]) min_idx = j; 
            }
            // desde j hasta n se tiene el numero menor
            // se intercambia en la primera pos del array
            // en la siguiente vuelta se buscará el segundo menor numero.
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
    // este también ordena numeros crecientemente
    static void algo(int[] array, int n) {
        int i, j, size_table;
        //int max = ~0, min = -(~0);
        int max = -999999999;
        int min = 999999999;
        for(i = 0; i < n; ++i) {
            if (max < array[i]) max = array[i];
            if (min > array[i]) min = array[i];
        }
        // se buscan valores maximos y minimos del array
        // ex: 
        // max = 99 y min = 1 -> 99 - 1 + 1 = 99 size
        size_table = max - min + 1;
        System.out.println(size_table);
        int[] table = new int[size_table];
        // se crea un array que tiene de tamaño la distancia entre el max y min
        for(i = 0; i < n; ++i)
            ++table[array[i] - min];

        //print(table); 
        //esto imprime cada posición en donde están los valores de el min -> max
        // por ejemplo, tengo valores de 1 al 5 en el array, pondrá 1's en sus posiciones
        // y si tengo el 231, también un 1 en esa posición
        for(i = 0, j = 0; i < size_table; ++i) {
            if ((table[i]--) > 0){ 
                array[j] = (i + min);
                /* table[i]--;
                array[j] = (i + min); */
                j++;
            }
        }
        // error:
        // java.lang.ArrayIndexOutOfBoundsException: Index 17 out of bounds for length 7
        // fixed code
        // cambié else ++j; a aumentar j cuando table == 1 luego de agregar el valor
        // la forma en que logré que funcionara no admite numeros repetidos
        // por lo que el codigo en este estado, ordena las cantidades en bruto que hay dentro del array

        System.out.println();
        //print(table);
    }

    static int algoc(int a, int b){
        System.out.println("uwu");
        if (b == 0) return a;
        return algoc(b, a%b);
    }

}