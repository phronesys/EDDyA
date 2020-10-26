/**
 *  insertionSort, quiclSort, heapSort
 *  priorityQueue (heapSort)
 *  priorityQueue (maxHeap)
 */
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean running = true;
        boolean datasetOK = false;
        while(running)
        {
            System.out.print("Elija el medio para llenar el dataset: \n");
            System.out.println("0.- Exit.");
            System.out.println("1.- Normal (Algoritmos de ordenamiento)");
            System.out.println("2.- Priority Queue");
            switch(scan.nextInt())
            {
                case 0:
                    running = false;
                    break;
                case 1:
                    System.out.println("Elija ordenamiento: ");
                    boolean running2 = true; 
                    while(running2)
                    {
                        System.out.println("0.- Back.");
                        System.out.println("1.- Insertion Sort O(N^2)!");
                        System.out.println("2.- Heap Sort");
                        System.out.println("3.- Quick Sort (ranking inverso)");
                        switch (scan.nextInt()) {
                            case 0:
                                running2 = false;
                                break;
                            case 1:
                                // insertion

                                datasetOK = true;
                                break;
                            case 2:
                                // heapsort


                                datasetOK = true;
                                break;
                            case 3:
                                // quicksort


                                datasetOK = true;
                                break;
                            default:
                                break;
                        }
                        if(datasetOK){
                            running = false;
                            running2 = false;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Elija Priority Queue: ");
                    boolean running3 = true;
                    while(running3)
                    {   
                        System.out.println("0.- Back.");
                        System.out.println("1.- PQ usando HeapSort");
                        System.out.println("2.- PQ usando MaxHeap");
                        switch(scan.nextInt())
                        {
                            case 0:
                                running3 = false;
                                break;
                            case 1:
                                // exec PQ usando HeapSort

                                datasetOK = true;
                                break;
                            case 2:
                                // exec PQ usando MaxHeap

                                datasetOK = true;
                                break;
                        }
                        if(datasetOK){
                            running = false;
                            running3 = false;
                        }
                    }
                    break;
                default:
                    break;
            }
        } 
        if(datasetOK){
            System.out.println("0.- Abortar");
            System.out.println("1.- Exportar a out.csv");
            System.out.println("2.- Imprimir por terminal");
            switch(scan.nextInt()){
                case 0:
                    System.out.println("uwu...");
                    break;
                case 1:
                    System.out.println("Exportando a out.csv");
                    // exportar
                    break;
                case 2:
                    System.out.println("Imprimiendo datos");
                    // imprimir
                    break;
                default:
                    break;
            }
        } 
    }
    
}