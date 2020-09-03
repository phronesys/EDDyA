import java.util.*;
class Solution{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // cantidad de drags
        
        int[] dps = new int[N];
        int[] ps = new int[N];
        for (int i = 0; i < N; i++){ 
            dps[i] = scan.nextInt();
        }
        for (int i = 0; i < N; i++) {
            ps[i] = scan.nextInt();
        }
        Dragon[] dragones = new Dragon[N];
        for (int i = 0; i < N; i++) {
            dragones[i] = new Dragon(dps[i], ps[i]);
        }
        // input is ready
        ordenarDragones(dragones);
        System.out.println(dañoRecibido(dragones, N));
        scan.close();
    }
    static void ordenarDragones(Dragon[] dragones)
    {
        Arrays.sort(dragones); // e.e merge sort
    }
    static int dañoRecibido(Dragon[] dragones, int N){
        int totalDmg = 0;
        int received = 0;
        for(int i = 0; i < N; i++){
            totalDmg += dragones[i].getDPS();
        }
        for(int i = 0; i < N; i++){
            received += (totalDmg * dragones[i].getPS());
            totalDmg = totalDmg - dragones[i].getDPS();
        }
        return received;
    }
}

class Dragon implements Comparable<Dragon>{
    int DPS, PS;
    Dragon(int dps, int ps){
        this.DPS = dps;
        this.PS = ps;
    }
    public int getDPS() { return DPS;}
    public int getPS() { return PS;}

    public int compareTo(Dragon compareDragon) {
        int comparePS = ((Dragon) compareDragon).getPS();

        return this.PS - comparePS;
    }
    // this makes Arrays.sort() work with an array class
    // reference link to compareTo() method 
    // https://mkyong.com/java/java-object-sorting-example-comparable-and-comparator/
}


