
import java.util.*;

/**
 *  insertionSort, quiclSort, heapSort
 *  priorityQueue (heapSort)
 *  priorityQueue (maxHeap)
 */
import java.util.Scanner;
public class App {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        priorityQHeapSort dataset2;
        ArrayList<tripleta> dataset;
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
                    dataset = new ArrayList<tripleta>();
                    System.out.println("Elija ordenamiento: ");
                    boolean running2 = true; 
                    while(running2)
                    {
                        System.out.println("0.- Back.");
                        System.out.println("1.- Insertion Sort O(N^2)!");
                        System.out.println("2.- Heap Sort");
                        System.out.println("3.- Quick Sort (ranking inverso)");
                        int x = scan.nextInt();
                        switch (x) {
                            case 0:
                                running2 = false;
                                break;
                            case 1:
                                // insertion
                                System.out.println("Se usará stats3.csv ...");
                                dataset = volcado.volcarNormal(x);
                                insertionSort.insertionSortDec(dataset);
                                printerHelper(dataset);

                                datasetOK = true;
                                break;
                            case 2:
                                // heapsort
                                dataset = volcado.volcarNormal(x);
                                heapSortAL.sort(dataset);
                                printerHelper(dataset);

                                datasetOK = true;
                                break;
                            case 3:
                                // quicksort
                                dataset = volcado.volcarNormal(x);
                                quickSortAL.quickSort(dataset, 0, dataset.size()-1);
                                printerHelper(dataset);

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
                    dataset2 = new priorityQHeapSort();
                    System.out.println("Elija Priority Queue: ");
                    boolean running3 = true;
                    while(running3)
                    {   
                        System.out.println("0.- Back.");
                        System.out.println("1.- PQ usando HeapSort");
                        System.out.println("2.- PQ usando MaxHeap");
                        int x = scan.nextInt();
                        switch(x)
                        {
                            case 0:
                                running3 = false;
                                break;
                            case 1:
                                // exec PQ usando HeapSort
                                // se usa stats3 pq esta estructura
                                // anda en O(N^2*logN) 
                                System.out.println("Usando stats3.csv ...");
                                dataset2 = volcado.volcarPQ(x);
                                printerHelperPQ(dataset2);

                                datasetOK = true;
                                break;
                            case 2:
                                // exec PQ usando MaxHeap
                                volcado.priorityQueue(x);
                                //printerHelper();

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
    }
    public static void printerHelper(ArrayList<tripleta> dataset)
    {
        System.out.println("0.- Abortar");
        System.out.println("1.- Exportar a out.csv");
        System.out.println("2.- Imprimir por terminal");
        int n = scan.nextInt();
        switch(n){
            case 0:
                System.out.println("uwu...");
                break;
            case 1:
                System.out.println("Exportando a out.csv");
                write.export(dataset);
                break;
            case 2:
                System.out.println("Imprimiendo datos");
                write.printerNormal(dataset);
                break;
            default:
                break;
        }
        
    }
    public static void printerHelperPQ(priorityQHeapSort dataset)
    {
        System.out.println("0.- Abortar");
        System.out.println("1.- Exportar a out.csv");
        System.out.println("2.- Imprimir por terminal");
        int n = scan.nextInt();
        switch(n){
            case 0:
                System.out.println("uwu...");
                break;
            case 1:
                System.out.println("Exportando a out.csv");
                //write.export(dataset);
                break;
            case 2:
                System.out.println("Imprimiendo datos");
                write.printerPQ(dataset);
                break;
            default:
                break;
        }
        
    }
}